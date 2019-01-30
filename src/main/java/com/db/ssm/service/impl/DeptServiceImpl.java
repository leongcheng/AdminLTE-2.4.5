package com.db.ssm.service.impl;

import com.db.ssm.common.exception.ServiceException;
import com.db.ssm.common.vo.Node;
import com.db.ssm.dao.DeptDao;
import com.db.ssm.pojo.Dept;
import com.db.ssm.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/1/22 0022 下午 3:45
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    //角色数据封装呈现
    @Override
    public List<Map<String, Object>> findObjects() {
        return deptDao.findObjects();
    }

    //上级菜单页面呈现
    @Override
    public List<Node> findZtreeDeptNodes() {
        return deptDao.findZtreeDeptNodes();
    }

    //添加数据
    @Override
    public int saveObjects(Dept dept) {
        if (dept == null) {
            throw new ServiceException("添加数据不正确"); }
        if (StringUtils.isEmpty(dept.getName())) {
            throw new ServiceException("部门不能为空"); }
        int rows;
        try {
            rows = deptDao.saveObjects(dept);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceException("保存失败");
        }
        return rows;
    }

    //删除员工信息
    @Override
    public int deleteObject(Integer id) {
        //1.参数合法性
        if(id == null || id <=0){
            throw new ServiceException("数据不合法,id ="+id); }
        //2.判定此id对应的菜单是否有子元素
        int query = deptDao.query(id);
        if(query > 0){
            throw new ServiceException("请先删除部门下员工"); }
        //2.1判断此部门下还有没有员工
//        int userCount = deptDao.UserCountByDeptId(id);
//        if(userCount == 0){
//            throw new ServiceException("部门内有员工,不允许删除");
//        }
         int rows = deptDao.deleteId(id);
        if(rows == 0){
            throw new ServiceException("部门信息不存在");
        }
        return rows;
    }

    //修改角色信息
    @Override
    public int updateObject(Dept dept) {
        if(dept == null){ throw new ServiceException("保存数据不能为空"); }
        if(StringUtils.isEmpty(dept.getName())){ throw new ServiceException("部门名不能为空"); }
        int rows;
        //2.更新数据
        try{
            rows=deptDao.updateObject(dept);
        }catch(Exception e){
            e.printStackTrace();
            throw new ServiceException("修改失败");
        }
        return rows;
    }
}