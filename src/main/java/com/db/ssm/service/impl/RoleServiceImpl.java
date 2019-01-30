package com.db.ssm.service.impl;

import com.db.ssm.common.exception.ServiceException;
import com.db.ssm.service.RoleService;
import com.db.ssm.vo.CheckBox;
import com.db.ssm.common.vo.PageObject;
import com.db.ssm.dao.RoleDao;
import com.db.ssm.dao.RoleMenuDao;
import com.db.ssm.dao.UserRoleDao;
import com.db.ssm.pojo.Role;
import com.db.ssm.vo.RoleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by Administrator on 2019/1/22 0022 下午 9:45
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;
    @Autowired
    private RoleMenuDao roleMenuDao;
    @Autowired
    private UserRoleDao userRoleDao;

    //分页查询角色信息,并查询角色总记录数据
    @Override
    public PageObject<Role> findPageObject(String name, Integer pageCurrent) {
        //参数合法性判断
        if (pageCurrent == null || pageCurrent < 1) {
            throw new IllegalArgumentException("当前页码值不正确");
        }
        //1.查询总记录数
        int rowCount = roleDao.rowsCount(name);
        if (rowCount == 0) {
            throw new ServiceException("记录不存在");
        }
        //2.查询当前页信息
        int pageSize = 3;
        int start = (pageCurrent - 1) * pageSize;
        List<Role> records =
                roleDao.findPageObject(name, start, pageSize);
        //3.对分页信息进行封装
        PageObject<Role> pageObject = new PageObject<>();
        pageObject.setPageCount(rowCount);
        pageObject.setPageCurrent(pageCurrent);
        pageObject.setPageSize(pageSize);
        pageObject.setRecords(records);
        pageObject.setPageCount((rowCount - 1)/pageSize +1);
        return pageObject;
    }

    //删除角色信息
    @Override
    public int deleteId(Integer id) {
        if (id < 1 || id == null) {
            throw new ServiceException("有子菜单未删除 ,id=" + id);
        }
        //删除角色自身id
        int rows = roleDao.deleteObject(id);
        if (rows == 0) {
            throw new ServiceException("数据不存在");
        }
        //根据id删除角色与用户的关系数据
        userRoleDao.deleteObjectById(id);
        //根据id删除角色与菜单的关系数据
        roleMenuDao.deleteMneuIdsByRoleId(id);
        return rows;
    }

    //新增角色
    @Override
    public int saveObject(Role role, Integer[] menuIds) {
        if (role == null) {
            throw new ServiceException("保存数据不能为空");
        }
        if (StringUtils.isEmpty(role.getName())) {
            throw new ServiceException("信息不能为空");
        }
        if (menuIds == null || menuIds.length == 0) {
            throw new ServiceException("角色未赋予权限");
        }
        //新增角色信息
        int rows = roleDao.insertObject(role);
        //新增角色菜单信息
        roleMenuDao.insertObjects(role.getId(), menuIds);
        return rows;
    }


    //修改角色信息
    @Override
    public RoleMenu  findObjectById(Integer id) {
        //1.参数有效性验证
        if(id == null||id< 1 ){
            throw new IllegalArgumentException("id值无效");}
        //2.查询角色自身信息
        RoleMenu  result = roleDao.findObjectById(id);
        if(result == null){
            throw new ServiceException("此记录可能已经不存在");}
        return result;
    }

    //更新角色以及角色与菜单的关系数据
    @Override
    public int uodateObject(Role role, Integer[] menuIds) {
        if(role == null){
            throw new ServiceException("修改数据不能为空"); }
        if(role.getId() == null){
            throw new ServiceException("id值不正确"); }
        if(StringUtils.isEmpty(role.getName())){
            throw new ServiceException("角色信息不能为空"); }
        if(menuIds == null||menuIds.length == 0){
            throw new ServiceException("角色权限未设置"); }
        int rows = roleDao.updateRoleIds(role);
        if(rows == 0){
            throw new ServiceException("角色信息不存在"); }
        //对原来的数据进行删除
        roleMenuDao.deleteByRoleId(role.getId());
        //插入新的数据
        roleMenuDao.insertObjects(role.getId(),menuIds);
        return rows;
    }

    //用户添加
    @Override
    public List<CheckBox> findObjects() {
      List<CheckBox> roles = roleDao.findObjects();
      if(roles == null || roles.isEmpty()){
          throw new ServiceException("没有角色信息");
      }
        return roles;
    }


}
