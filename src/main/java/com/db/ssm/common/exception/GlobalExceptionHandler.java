package com.db.ssm.common.exception;

import com.db.ssm.common.vo.JsonResult;
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

    //封装错误信息
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public JsonResult doHandleRuntimeException(RuntimeException e){
        e.printStackTrace();
        log.info(e.getMessage());
        return new JsonResult(e);
    }


}
