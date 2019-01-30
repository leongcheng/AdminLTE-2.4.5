package com.db.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2019/1/28 0028 下午 9:50
 */
@Controller
@RequestMapping("/config/")
public class ConfigController {

    @RequestMapping("doConfigListUI")
    public String doConfigListUI(){
        return "sys/config_list";
    }
}
