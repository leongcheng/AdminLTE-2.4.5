package com.db.ssm.controller;

import com.db.ssm.common.vo.JsonResult;
import com.db.ssm.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2019/1/28 0028 下午 9:50
 */
@Controller
@RequestMapping("/config/")
public class ConfigController {

    @Autowired
    private ConfigService configService;
    @RequestMapping("doConfigListUI")
    public String doConfigListUI(){
        return "sys/config_list";
    }


    //查询
    @ResponseBody
    @RequestMapping("doFindPageObjects")
    public JsonResult doFindPageObjects(String name,Integer pageCurrent){
        return new JsonResult(configService.findPageObject(name,pageCurrent));
    }

    //删除
    @RequestMapping("doDeleteObjects")
    @ResponseBody
    private JsonResult doDeleteObjects(Integer[] ids){
        configService.deleteObjectId(ids);
        return new JsonResult("删除成功");
    }
}
