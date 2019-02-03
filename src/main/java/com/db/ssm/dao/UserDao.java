package com.db.ssm.dao;

import com.db.ssm.pojo.User;
import com.db.ssm.vo.UserDept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/1/25 0025 下午 10:43
 */
public interface UserDao {
    //查询总记录数
     int rowConut(@Param("username") String username);
    //获取当前页值
     List<UserDept> findPageObjects(
             @Param("username") String username,
            @Param("startIndex") Integer startIndex,
            @Param("pageSize") Integer pageSize);

    int validById(@Param("id") Integer id,@Param("valid") Integer valid,
                  @Param("modifiedUser") String modifiedUser);

    //将用户信息写入到数据库
    int insertUser(User user);

    //修改信息查询
    UserDept findObjectById(Integer userId);

    //更新数据
    int updateObjects(User user);

    //shiro验证查询
    User findUserByUserName(String username);

    //删除用户
    int deleteObject(@Param("id") Integer[] id);
}
