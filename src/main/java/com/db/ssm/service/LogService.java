package com.db.ssm.service;

import com.db.ssm.pojo.Log;
import com.db.ssm.common.vo.PageObject;

public interface LogService {
    /**分页查询*/
    PageObject<Log> findPageObjects(String username, Integer pageCurrent);
    /**日志删除*/
    int deleteObjects(Integer... ids);
}
