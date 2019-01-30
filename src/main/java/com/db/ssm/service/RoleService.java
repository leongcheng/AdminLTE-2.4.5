package com.db.ssm.service;

import com.db.ssm.vo.CheckBox;
import com.db.ssm.common.vo.PageObject;
import com.db.ssm.pojo.Role;
import com.db.ssm.vo.RoleMenu;

import java.util.List;

/**
 * Created by Administrator on 2019/1/22 0022 下午 9:45
 */
public interface RoleService {

    //呈现角色数据
    public PageObject<Role> findPageObject(String name, Integer pageCurrent) ;

    //删除角色信息
    int deleteId(Integer id);

    //添加角色信息
    int saveObject(Role role, Integer[] menuIds);

    //修改角色
    RoleMenu  findObjectById(Integer id);

    //更新角色以及角色与菜单的关系数据
    int uodateObject(Role role , Integer[] menuIds);

    //用户添加
    List<CheckBox> findObjects();


}
