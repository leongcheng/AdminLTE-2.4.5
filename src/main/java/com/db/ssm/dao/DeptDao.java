package com.db.ssm.dao;

import com.db.ssm.common.vo.Node;
import com.db.ssm.pojo.Dept;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/1/22 0022 下午 3:44
 */
public interface DeptDao {

    List<Map<String,Object>> findObjects();

    List<Node> findZtreeDeptNodes();

    int saveObjects(Dept dept);

    int query(Integer id);

    int userCountByDeptId(Integer id);

    int updateObject(Dept dept);

    int deleteId(Integer id);
}
