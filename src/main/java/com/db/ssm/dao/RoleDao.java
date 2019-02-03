package com.db.ssm.dao;


import com.db.ssm.vo.CheckBox;
import com.db.ssm.pojo.Role;
import com.db.ssm.vo.RoleMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/1/22 0022 下午 9:45
 */
public interface RoleDao  {

    //角色查询
    int rowsCount(@Param("name") String name);
    //角色分页
    List<Role> findPageObject(@Param("name") String name,
                              @Param("startIndex") int startIndex,@Param("pageSize") int pageSize);

    //删除角色
    int deleteObject(Integer id);

    //新建角色
    int insertObject(Role role);

    //基于角色id查询角色与菜单数据
    RoleMenu  findObjectById(Integer id);

    int updateRoleIds(Role role);

    //添加用户
    List<CheckBox> findObjects();
}
