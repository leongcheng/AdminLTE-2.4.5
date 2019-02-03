package com.db.ssm.dao;

import com.db.ssm.pojo.Log;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 基于条件分页查询日志信息
 */
public interface LogDao{

    /**将数据库中的每条日志信息封装到一个SysLog对象中*/
     List<Log> findPageObjects(
            @Param("username") String username,//查询条件（哪个用户的日志信息）
            @Param("startIndex")int startIndex,//当前页的起始位置
            @Param("pageSize")int pageSize);//当前页面大小

    /**基于条件查询总记录数*/
    int rowsCount(@Param("username") String username);

    /**删除日志记录*/
    int deleteObjects(@Param("ids") Integer... ids);

    /**日志添加*/
    int insertObject(Log log);

}
