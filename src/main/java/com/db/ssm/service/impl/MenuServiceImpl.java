package com.db.ssm.service.impl;

import com.db.ssm.common.exception.ServiceException;
import com.db.ssm.dao.MenuDao;
import com.db.ssm.common.vo.Node;
import com.db.ssm.dao.RoleMenuDao;
import com.db.ssm.pojo.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 菜单管理
 * Created by Administrator on 2019/1/21 0021 下午 4:37
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;
    @Autowired
    private RoleMenuDao roleMenuDao;

    @Override
    public List<Map<String, Object>> findObjects() {
        //查询菜单信息
        List<Map<String, Object>> list = menuDao.findObjects();
        //判断是否有数据
        if (list == null || list.size() == 0) {
            throw new IllegalArgumentException("没有找到对应的记录");
        }
        return list;
    }

    //删除菜单信息
    @Override
    public int deleteObject(Integer id) {
        //1.验证数据的合法性
        if (id == null || id < 1) {
            throw new ServiceException("请先选择需要删除的信息");
        }
        //2.基于ID进行子元素的查询
        int count = menuDao.query(id);
        if (count > 0) {
            throw new ServiceException("请先删除子菜单");
        }
        int rows = menuDao.deleteObject(id);
        //3.删除菜单元素
        if (rows == 0) {
            throw new ServiceException("菜单信息已不存在");
        }
        //4.删除角色,菜单关系数据
        roleMenuDao.deleteObjectByMenuId(id);
        return rows;
    }

    //修改菜单信息
    @Override
    public List<Node> findZtreeMenuNodes() {
        List<Node> list = menuDao.findZtreeMenuNodes();
        return list;
    }

    //添加菜单信息
    @Override
    public void saveObkect(Menu menu) {
        //1.合法验证
        if (menu == null) {
            throw new ServiceException("保存对象不能为空");
        }
        if (StringUtils.isEmpty(menu.getName())) {
            throw new ServiceException("菜单名不能为空");
        }
        //2.保存数据
//        int rows ;
//        try{
//            rows =  menuDao.insertMenu(menu);
//        }catch(Exception e){
//            e.printStackTrace();
//            throw new ServiceException("保存失败");
//        }
//        return rows;
        menu.setModifiedTime(new Date());
        menu.setModifiedTime(menu.getCreatedTime());
        menuDao.insert(menu);
    }
}