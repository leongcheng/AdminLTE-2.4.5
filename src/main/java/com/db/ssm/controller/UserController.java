package com.db.ssm.controller;

import com.db.ssm.common.vo.JsonResult;
import com.db.ssm.common.vo.PageObject;
import com.db.ssm.pojo.User;
import com.db.ssm.service.RoleService;
import com.db.ssm.service.UserService;
import com.db.ssm.vo.UserDept;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 用户管理
 * Created by Administrator on 2019/1/25 0025 下午 10:20
 */
@Controller
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @RequestMapping("doUserListUI")
    public String doUserListUI() {
        return "sys/user_list";
    }

    @RequestMapping("doUserEditUI")
    public String doUserEditUI() {
        return "sys/user_edit";
    }

    //用户数据呈现
    @RequestMapping("doFindPageObjects")
    @ResponseBody
    public JsonResult doFindPageObjects(String username, Integer pageCurrent) {
        PageObject<UserDept> pageObject =
                userService.findObjects(username, pageCurrent);
        return new JsonResult(pageObject);
    }

    //用户权限切换
    @RequestMapping("doValidById")
    @ResponseBody
    public JsonResult doValidById(Integer id, Integer valid) {
        //登录成功后获取用户身份
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        userService.validById(id, valid, user.getUsername());
        return new JsonResult("权限切换成功");
    }

    //用户添加到用户信息
    @ResponseBody
    @RequestMapping("doFindObjects")
    public JsonResult doFindObjects() {
        return new JsonResult(roleService.findObjects());
    }

    @RequestMapping("doSaveObject")
    @ResponseBody
    public JsonResult doSaveObject(User user, Integer[] roleIds) {
        userService.saveObject(user, roleIds);
        return new JsonResult("添加成功");
    }

    //修改用户信息
    @RequestMapping("doFindObjectById")
    @ResponseBody
    public JsonResult doFindObjectById(Integer id) {
        Map<String, Object> map =
                userService.findObjectById(id);
        return new JsonResult(map);
    }

    //更新保存数据
    @RequestMapping("doUpdateObject")
    @ResponseBody
    public JsonResult doUpdateObject(User user, Integer[] roleIds) {
        userService.updateObject(user, roleIds);
        return new JsonResult("修改成功");
    }

    //删除用户
    @ResponseBody
    @RequestMapping("doDeleteObject")
    public JsonResult doDeleteObject(Integer[] id){
        userService.deleteObjectId(id);
        return new JsonResult("删除成功");
    }


    //访问登录页面
    @RequestMapping("doLogin")
    @ResponseBody
    public JsonResult doLogin(String username,String password){
        //1.封装用户名密码信息到token对象
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        //2.获取一个Subject对象(主体对象)
        Subject subject = SecurityUtils.getSubject();
        //3.通过Subject提交token对象到认证管理器
        subject.login(token);
        //验证过程:
        //1)token会传给shiro的SecurityManager
        //2)SecurityManager将token传递给认证管理器
        //3)认证管理器会将token传递给realm
        return new JsonResult("登录成功");
    }
}
