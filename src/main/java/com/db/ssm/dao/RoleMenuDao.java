package com.db.ssm.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色菜单中间表
 * Created by Administrator on 2019/1/21 0021 下午 5:48
 */
public interface RoleMenuDao {

    //删除菜单关联信息
    int deleteObjectByMenuId(Integer menuId);

    //部门删除
    int deleteId(Integer id);

    //角色菜单关联id
    int deleteMneuIdsByRoleId(Integer id);

    //新建角色菜单
    int insertObjects(@Param("roleId") Integer roleId,@Param("menuIds") Integer[] menuIds);

    //修改角色信息
    List<Integer> findMneuIdsByRoleIds(@Param("roleIds") Integer[] roleIds);

    //删除原数据
    int deleteByRoleId(Integer roleId);
    //插入新修改数据
//    int insertObjects(@Param("roleId") Integer roleId,@Param("menuIds") Integer[] menuIds);
}
