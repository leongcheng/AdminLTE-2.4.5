package com.db.ssm.common.exception;

import com.db.ssm.common.vo.JsonResult;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Logger;

/**
 * 全局异常查理类
 * Created by Administrator on 2019/1/20 0020 下午 9:10
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    //JDK中的自带的日志API
    private Logger log = Logger.getLogger(GlobalExceptionHandler.class.getName());

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public JsonResult doHandleRuntimeException(RuntimeException e){
        e.printStackTrace();
        log.info(e.getMessage());
        return new JsonResult(e);
    }

    @ExceptionHandler(ShiroException.class)
    @ResponseBody
    public JsonResult doShiroException(ShiroException e){
        e.printStackTrace();
        JsonResult result = new JsonResult();
        if(e instanceof UnknownAccountException){
            result.setMessage("用户不存在");
        }else if(e instanceof LockedAccountException){
            result.setMessage("账号已被禁用");
        }else if(e instanceof IncorrectCredentialsException){
            result.setMessage("用户名或密码不正确");
        }else {
            result.setMessage(e.getMessage());
        }
        return  result;
    }
}
