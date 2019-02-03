package com.db.ssm.service;

import com.db.ssm.common.vo.PageObject;
import com.db.ssm.pojo.Config;

/**
 * Created by Administrator on 2019/2/3 0003 下午 6:51
 */
public interface ConfigService {
    //查询
    PageObject<Config> findPageObject(String name, Integer pageCurrent);
    //删除
    int  deleteObjectId(Integer[] ids);
}
