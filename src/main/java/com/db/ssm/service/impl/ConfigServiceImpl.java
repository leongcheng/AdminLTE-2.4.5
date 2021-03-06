package com.db.ssm.service.impl;

import com.db.ssm.common.Utli.PageUtil;
import com.db.ssm.common.exception.ServiceException;
import com.db.ssm.common.vo.PageObject;
import com.db.ssm.dao.ConfigDao;
import com.db.ssm.pojo.Config;
import com.db.ssm.service.ConfigService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by Administrator on 2019/2/3 0003 下午 6:51
 */
@Service
public class ConfigServiceImpl implements ConfigService {

    @Autowired
    private ConfigDao configDao;
    @Override
    public PageObject<Config> findPageObject(String name, Integer pageCurrent) {
        if(pageCurrent ==null||pageCurrent<1){
            throw new ServiceException("当前没有记录");
        }
        int rowCount =configDao.rowsCount(name);
        if(rowCount == 0){
            throw new ServiceException("没有资源信息");
        }
        int pageSize = 3;
        int startIndex = (pageCurrent-1)*pageSize;
        List<Config> records = configDao.findPageObjects(name,startIndex,pageSize);
        return PageUtil.pageObject(rowCount,records,  pageCurrent, pageSize);
    }

    //删除记录
    @RequiresPermissions("sys:config:delete")
    @Override
    public int deleteObjectId(Integer[] ids) {
        if(ids == null||ids.length ==0){
            throw new ServiceException("请先选择需要删除的记录");
        }
        int rows;
        try {
            rows = configDao.deleteIds(ids);
        }catch (Exception e){
            e.printStackTrace();
            throw new ServiceException("系统繁忙,请重试");
        }
        if(rows == 0){
            throw new ServiceException("记录不存在");
        }

        return rows;
    }

    //添加
    @Override
    public int insertObject(Config config) {
        if(config == null){
            throw new ServiceException("添加内容不能为空");
        }
        if(StringUtils.isEmpty(config.getName())){
            throw new ServiceException("参数名不正确");
        }
        if(StringUtils.isEmpty(config.getNote())){
            throw new ServiceException("参数值不能为空");
        }
        if(StringUtils.isEmpty(config.getValue())){
            throw new ServiceException("描述不能为空");
        }
        int rows;
        try {
            rows = configDao.insertObject(config);
        }catch (Exception e){
            e.printStackTrace();
            throw new ServiceException("保存失败");
        }
        return rows;
    }

    //修改
    @Override
    public int updateObject(Config config) {
        if(StringUtils.isEmpty(config)){
            throw new ServiceException("资源不能为空");
        }
        int rows;
        try {
            rows = configDao.updateObject(config);
        }catch (Exception e){
            e.printStackTrace();
            throw new ServiceException("修改失败");
        }
        return rows;
    }
}
