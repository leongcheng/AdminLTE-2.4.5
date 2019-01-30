package com.db.ssm.controller;

import com.db.ssm.common.vo.JsonResult;
import com.db.ssm.pojo.Dept;
import com.db.ssm.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 用户角色
 * Created by Administrator on 2019/1/22 0022 下午 3:32
 */

@Controller
@RequestMapping("/dept/")
public class DeptController {
    @Autowired
    private DeptService deptService;

    //角色页面跳转
    @RequestMapping("doDeptListUI")
    public String doDeptListUI(){
        return "sys/dept_list";
    }

    @RequestMapping("doDeptEditUI")
    public String doDeptEditUI(){
        return "sys/dept_edit";
    }

    //部门信息
    @ResponseBody
    @RequestMapping("doFindObjects")
    public JsonResult doFindObjects(){
        return new JsonResult(deptService.findObjects());
    }

    //添加上级页面的呈现
    @ResponseBody
    @RequestMapping("doFindZTreeNodes")
    public JsonResult doFindZTreeNodes(){
        return new JsonResult(deptService.findZtreeDeptNodes());
    }

    //添加页面
    @ResponseBody
    @RequestMapping("doSaveObject")
    public JsonResult doSaveObject(Dept dept){
        deptService.saveObjects(dept);
        return new JsonResult("添加成功");
    }

    //删除
    @ResponseBody
    @RequestMapping("doDeleteObject")
    public JsonResult doDeleteObject(Integer id){
        deptService.deleteObject(id);
        return new JsonResult("删除成功");
    }

    //修改部门信息
    @ResponseBody
    @RequestMapping("doUpdateObject")
    public JsonResult doUpdateObject(Dept dept){
            deptService.updateObject(dept);
            return new JsonResult("更新成功");
    }

}
