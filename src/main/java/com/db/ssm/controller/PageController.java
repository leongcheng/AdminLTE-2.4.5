package com.db.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    //首页访问
    @RequestMapping("doIndexUI")
    public String doIndexUI(){
        return "starter";
    }

    //返回日志分页页面
    @RequestMapping("/doPageUI")
    public String doPageUI(){
        return "common/page";
    }


}
