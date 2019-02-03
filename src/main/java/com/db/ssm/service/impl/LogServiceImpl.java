package com.db.ssm.service.impl;

import com.db.ssm.common.annotation.RequestLog;
import com.db.ssm.common.exception.ServiceException;
import com.db.ssm.dao.LogDao;
import com.db.ssm.pojo.Log;
import com.db.ssm.common.vo.PageObject;
import com.db.ssm.service.LogService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogDao logDao;

    @RequestLog("用户行为记录")
    @Override
    public PageObject<Log> findPageObjects(String username, Integer pageCurrent) {
        //1.验证参数的合法性
        if (pageCurrent == null || pageCurrent < 1) {
            throw new IllegalArgumentException("当前编码不正确");
        }
        //基于条件查询总记录数
        int rowCount = logDao.rowsCount(username);
        //判断查询的结果是否为0
        if (rowCount == 0) {
            throw new ServiceException("日志记录不存在");
        }
        //计算当前页码数
        int pageSize = 3;
        int startIndex = (pageCurrent - 1) * pageSize;
        //查询当前位置的数据
        List<Log> records =
                logDao.findPageObjects(username, startIndex, pageSize);
        //对分页信息以及当前页记录封装
        PageObject<Log> pageObject = new PageObject<>();
        pageObject.setRowCount(rowCount);
        pageObject.setPageCurrent(pageCurrent);
        pageObject.setPageSize(pageSize);
        pageObject.setRecords(records);
        pageObject.setPageCount((rowCount - 1)/pageSize +1);
        return pageObject;
    }

    //日志记录删除
    @RequiresPermissions("sys:log:delete")
    @Override
    public int deleteObjects(Integer... ids) {
       //1.删除前判断参数的合法性
        if(ids == null || ids.length ==0){
            throw new IllegalArgumentException("请先选择需要删除的记录");
        }
        //2.执行删除操作
        int rows;
        try{
            rows = logDao.deleteObjects(ids);
        }catch (Throwable e){
            e.printStackTrace();
            throw new ServiceException("系统升级中,请稍后再试");
        }
        //3.对删除的结果进行验证
        if(rows == 0){
            throw new ServiceException("记录不存在,请重试");
        }
        //4.返回结果
        return rows;
    }


}
