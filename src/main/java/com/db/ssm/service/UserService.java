package com.db.ssm.service;

import com.db.ssm.common.vo.PageObject;
import com.db.ssm.pojo.User;
import com.db.ssm.vo.UserDept;

import java.util.Map;

/**
 * Created by Administrator on 2019/1/25 0025 下午 10:43
 */
public interface UserService {
    PageObject<UserDept> findObjects(String username, Integer pageCurrent);

    //查询
    int validById(Integer id, Integer valid, String modifiedUser);

    //用户添加
    int saveObject(User user, Integer[] roleIds);

    //修改用户信息
    Map<String,Object> findObjectById(Integer userId);

    //更新保存修改数据
    int updateObject(User user, Integer[] roleIds);
}
