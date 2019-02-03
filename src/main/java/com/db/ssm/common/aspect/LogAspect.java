package com.db.ssm.common.aspect;

import com.db.ssm.common.Utli.IPUtils;
import com.db.ssm.common.Utli.ShiroUtils;
import com.db.ssm.common.annotation.RequestLog;
import com.db.ssm.dao.LogDao;
import com.db.ssm.pojo.Log;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.lang.reflect.Method;
import java.util.Date;
import java.util.logging.Logger;


/**
 * 记录用户日志
 * Created by Administrator on 2019/2/1 0001 下午 4:05
 */
@Aspect
@Component
public class LogAspect {
    //private Logger log = Logger.getLogger(LogAspect.class);
    @Autowired
    private LogDao logDao;

    @Pointcut("@annotation(com.db.ssm.common.annotation.RequestLog)")
    public void logPointCut() {
    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        //执行目标方法(result为目标方法的结果)
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long totalTime = endTime- startTime;
        System.out.println("方法执行的总时长:"+totalTime);
        saveLog(joinPoint,totalTime);
        return result;
    }

    private void saveLog(ProceedingJoinPoint joinPoint, long totalTime) throws Exception {
        //1.获取日志信息
        //1.1获取方法签名信息(记录了目标方法信息)
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        //1.2获取目标方法名
        String methodName = methodSignature.getMethod().getName();
        //1.3获取目标方法参数类型
        Class<?>[] returnType = methodSignature.getMethod().getParameterTypes();
        //1.4获取目标方法对象
        Class<?> targetClass = joinPoint.getTarget().getClass();
        Method className = targetClass.getDeclaredMethod(methodName,returnType);
        //1.5获取类方法的信息(类名+"."+方法名)
        String method = targetClass.getName()+"."+methodName;
        //1.6获取登录用户名
        String username = ShiroUtils.getUser().getUsername();
        //1.7获取用户IP地址
        String ipAddr = IPUtils.getIpAddr();
        //1.8将参数转为字符串
        Object[] pointArgs = joinPoint.getArgs();
        String params = new ObjectMapper().writeValueAsString(pointArgs);
       //2.封装日志信息
        Log log = new Log();
        //2.1判断方法上是否有注解操作名
        boolean flag = className.isAnnotationPresent(RequestLog.class);
        if(flag){
            RequestLog requestLog = className.getDeclaredAnnotation(RequestLog.class);
            log.setOperation(requestLog.value());
        }
        log.setUsername(username);
        log.setMethod(method);
        log.setParams(params);
        log.setIp(ipAddr);
        log.setTime(totalTime);
        log.setCreatedTime(new Date());
        //3.保存日志信息
        logDao.insertObject(log);


    }

}
