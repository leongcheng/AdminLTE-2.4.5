package com.db.ssm.dao;

import com.db.ssm.pojo.Config;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/2/3 0003 下午 6:49
 */
public interface ConfigDao {
    //查询总页数
    int rowsCount(@Param("name") String name);
    //获取记录总数
    List<Config> findPageObjects(@Param("name") String name, @Param("startIndex") Integer startIndex,
                                 @Param("pageSize") Integer pageSize);
    //删除信息
    int deleteIds(@Param("ids") Integer[] ids);
}
