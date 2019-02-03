package com.db.ssm.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/1/23 0023 上午 12:25
 */
public interface UserRoleDao {
    //根据id删除角色与用户的关系数据
     int deleteObjectById(Integer roleId);

     //负责将用户与角色的关系数据写入到数据库
    int insertObjects(@Param("userId") Integer userId,
                      @Param("roleIds") Integer[] roleIds);
    //修改用户角色信息
    List<Integer> findRoleIdsByUserId(Integer userId);

    //更新数据删除
    int deleteByUserId(Integer userId);

    //删除用户与角色关联信息
    int deleteUserRoleByIds(Integer[] userId);

}
