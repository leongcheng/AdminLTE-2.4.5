package com.db.ssm.dao;

/**
 * 角色菜单中间表
 * Created by Administrator on 2019/1/21 0021 下午 5:48
 */
public interface RoleMenuDao {

     //删除菜单关联信息
     int deleteObjectByMenuId(Integer menu_id);
}
