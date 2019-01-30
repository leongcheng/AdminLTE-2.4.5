package com.db.ssm.service.impl;

import com.db.ssm.common.exception.ServiceException;
import com.db.ssm.common.vo.PageObject;
import com.db.ssm.dao.UserRoleDao;
import com.db.ssm.pojo.User;
import com.db.ssm.service.UserService;
import com.db.ssm.vo.UserDept;
import com.db.ssm.dao.UserDao;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


/**
 * 用户业务
 * Created by Administrator on 2019/1/25 0025 下午 10:44
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserRoleDao userRoleDao;

    //数据封装展现
    @Override
    public PageObject<UserDept> findObjects(String username, Integer pageCurrent) {
        if (pageCurrent == null || pageCurrent <= 0) {
            throw new ServiceException("参数不合法");
        }
        //1.依据条件获取总记录数
        int rowCount = userDao.rowConut(username);
        if (rowCount == 0) {
            throw new ServiceException("记录不存在");
        }
        //2.计算起始位置的值
        int pageSize = 3;
        int startIndex = (pageCurrent - 1) * pageSize;
        //获取当前页数
        List<UserDept> records =
                userDao.findPageObjects(username, startIndex, pageSize);
        //3.封装数据
        PageObject<UserDept> pageObject = new PageObject<>();
        pageObject.setPageCurrent(pageCurrent);
        pageObject.setRowCount(rowCount);
        pageObject.setPageSize(pageSize);
        pageObject.setRecords(records);
        pageObject.setPageCount((rowCount - 1) / pageSize + 1);
        return pageObject;
    }

    //用户权限配置
    @Override
    public int validById(Integer id, Integer valid, String modifiedUser) {
        if (id == null || id <= 0) {
            throw new ServiceException("参数不合法,ID =" + id);
        }
        if (valid != 1 && valid != 0) {
            throw new ServiceException("参数不合法 valid =" + valid);
        }
        if (StringUtils.isEmpty(modifiedUser)) {
            throw new ServiceException("修改用户不能为空");
        }
        int rows = 0;
        try {
            rows = userDao.validById(id, valid, modifiedUser);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceException("系统维护中...");
        }
        if (rows == 0) {
            throw new ServiceException("用户不存在");
        }
        return rows;
    }

    @Override
    public int saveObject(User user, Integer[] roleIds) {
        if (user == null) {
            throw new ServiceException("用户不能为空");
        }
        if (StringUtils.isEmpty(user.getUsername())) {
            throw new ServiceException("用户名不能为空");
        }
        if (StringUtils.isEmpty(user.getPassword())) {
            throw new ServiceException("密码不能为空");
        }
        if (roleIds == null || roleIds.length == 0) {
            throw new ServiceException("请为用户配置权限");
        }
        //将数据写入数据库中
        String salt = UUID.randomUUID().toString();
        user.setSalt(salt);
        //密码加密
        SimpleHash hashPassWord = new SimpleHash("MD5", user.getPassword(), salt);
        user.setPassword(hashPassWord.toString());

        int rows = userDao.insertUser(user);
        userRoleDao.insertObjects(user.getId(), roleIds);
        return rows;
    }

    @Override
    public Map<String, Object> findObjectById(Integer userId) {
        if (userId == null) {
            throw new ServiceException("参数不合法");
        }
        //业务查询
        UserDept user = userDao.findObjectById(userId);
        if (user == null) {
            throw new ServiceException("用户不存在");
        }
        List<Integer> roleId = userRoleDao.findRoleIdsByUserId(userId);
        HashMap<String, Object> map = new HashMap<>();
        map.put("user", user);
        map.put("roleId", roleId);
        return map;
    }

    //更新保存的数据
    @Override
    public int updateObject(User user, Integer[] roleIds) {
        //1.参数有效性验证
        if (user == null) {
            throw new ServiceException("保存对象不能为空");
        }
        if (StringUtils.isEmpty(user.getUsername())) {
            throw new ServiceException("用户信息不能为空");
        }
        if (StringUtils.isEmpty(roleIds)) {
            throw new ServiceException("请选择角色信息");
        }

        if (!StringUtils.isEmpty(user.getPassword())) {
            //2.密码加密
            String salt = UUID.randomUUID().toString();
            SimpleHash hash =
                    new SimpleHash("MD5", user.getPassword(), salt);
        }
        //3.更新数据
        int rows = 0;
        try {
            rows = userDao.updateObjects(user);
            userRoleDao.deleteByUserId(user.getId());
            userRoleDao.insertObjects(user.getId(), roleIds);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceException("数据更新失败,稍后请重试!");
        }
        return rows;
    }
}
