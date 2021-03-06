package com.db.ssm.controller;

import com.db.ssm.common.vo.Node;
import com.db.ssm.pojo.Menu;
import com.db.ssm.service.MenuService;
import com.db.ssm.common.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 菜单管理
 * Created by Administrator on 2019/1/21 0021 下午 4:38
 */
@Controller
@RequestMapping("/menu/")
public class MenuController {

    @Autowired
    private MenuService menuService;

    //菜单页面
    @RequestMapping("doMenuListUI")
    public String doMenuListUI(){
        return "sys/menu_list";
    }

    //修改添加页面
    @RequestMapping("doMenuEditUI")
    public String doMenuEditUI(){
        return "sys/menu_edit";
    }

    //呈现菜单页面
    @RequestMapping("doFindObjects")
    @ResponseBody
    public JsonResult doFindObjects(){
        List<Map<String ,Object>> data = menuService.findObjects();
        return new JsonResult(data);
    }

    //删除菜单信息
    @ResponseBody
    @RequestMapping("doDeleteObject")
    public JsonResult doDeleteObject(Integer id){
        menuService.deleteObject(id);
        return new JsonResult("删除成功");
    }

    //呈现上级菜单信息
    @ResponseBody
    @RequestMapping("doFindZtreeMenuNodes")
    public JsonResult doFindZtreeMenuNodes(){
        List<Node> data = menuService.findZtreeMenuNodes();
        return new JsonResult(data);
    }

    //菜单添加操作
    @ResponseBody
    @RequestMapping("doSaveObject")
    public JsonResult doSaveObject(Menu menu) {
            menuService.saveObkect(menu);
            return new JsonResult("添加成功");
    }

    //修改菜单信息
    @RequestMapping("doUpdateObject")
    @ResponseBody
    public JsonResult doUpdateObject(Menu menu){
        menuService.updateObject(menu);
        return new JsonResult("修改成功");
    }
}
