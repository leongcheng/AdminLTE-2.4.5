package com.db.ssm.controller;

import com.db.ssm.pojo.Log;
import com.db.ssm.common.vo.PageObject;
import com.db.ssm.service.impl.LogService;
import com.db.ssm.common.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/log/")
public class LogController {

    @Autowired
    private LogService logService;

    @RequestMapping("doLogListUI")
    public String doLogListUI(){
        return "sys/log_list";
    }

    //日志查询
    @RequestMapping( value = "doFindPageObjects",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public JsonResult doFindPageObjects(String username,Integer pageCurrent){
            PageObject<Log> pageObject =
                    logService.findPageObjects(username, pageCurrent);
        return new JsonResult(pageObject);
    }

    //删除日志
    @RequestMapping("doDeleteObjects")
    @ResponseBody
    public JsonResult doDeleteObjects(Integer... ids){
            logService.deleteObjects(ids);
            return new JsonResult("删除成功");
    }



    //日志查询
//    @RequestMapping( value = "doFindPageObjects",method = {RequestMethod.GET,RequestMethod.POST})
//    @ResponseBody
//    public SysResult doFindPageObjects(String username, Integer pageCurrent){
//        PageObject<Log> pageObject =
//                logService.findPageObjects(username, pageCurrent);
//        return new JsonResult(pageObject);
//    }
}
