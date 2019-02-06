package com.db.ssm.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解操作行为记录日志
 * Created by Administrator on 2019/2/1 0001 下午 11:33
 */
@Retention(RetentionPolicy.RUNTIME)//运行时有效
@Target(ElementType.METHOD)//只修饰方法
public @interface RequestLog {
    String value() default "";
}
