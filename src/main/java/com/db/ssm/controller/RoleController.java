package com.db.ssm.controller;

import com.db.ssm.common.vo.JsonResult;
import com.db.ssm.common.vo.PageObject;
import com.db.ssm.pojo.Role;
import com.db.ssm.service.RoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 角色管理
 * Created by Administrator on 2019/1/22 0022 下午 9:10
 */
@Controller
@RequestMapping("/role/")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("doRoleListUI")
    public String doRoleListUI(){
        return "sys/role_list";
    }

    @RequestMapping("doRoleEditUI")
    public String doRoleEditUI(){
        return "sys/role_edit";
    }

    //角色列表呈现

    @ResponseBody
    @RequestMapping("doFindPageObjects")
    public JsonResult doFindPageObjects(String name, Integer pageCurrent){
        PageObject<Role> pageObject =
                roleService.findPageObject(name,pageCurrent);
        return new JsonResult(pageObject);
    }
    //删除角色信息
    @ResponseBody
    @RequestMapping("doDeleteObject")
    public JsonResult doDeleteObject(Integer id ){
        roleService.deleteId(id);
        return new JsonResult("删除成功");
    }

    //添加角色信息
    @ResponseBody
    @RequestMapping("doSaveObject")
    public JsonResult doFindObjectById(Role role,Integer[] menuIds){
            roleService.saveObject(role,menuIds);
        return new JsonResult("添加成功");
    }

    //角色信息修改页面
    @ResponseBody
    @RequestMapping("doFindObjectById")
    public JsonResult doFindObjectById(Integer id){
        return new JsonResult(roleService.findObjectById(id));
    }

    //更新角色与菜单的关系数据
    @ResponseBody
    @RequestMapping("doUpdateObject")
    public JsonResult doUpdateObject(Role role ,Integer[] menuIds){
        roleService.uodateObject(role,menuIds);
        return new JsonResult("修改成功");
    }

    @RequestMapping("doFindRoles")
    @ResponseBody
    public JsonResult doFindObjects(){
        return new JsonResult( roleService.findObjects());
    }











}
