package com.db.ssm.service;

import com.db.ssm.common.vo.Node;
import com.db.ssm.pojo.Dept;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/1/22 0022 下午 3:45
 */
public interface DeptService {
    //封装角色数据的呈现
    List<Map<String,Object>> findObjects();

    List<Node> findZtreeDeptNodes();

    int saveObjects(Dept dept);

    int deleteObject(Integer id);

    int updateObject(Dept dept);
}
