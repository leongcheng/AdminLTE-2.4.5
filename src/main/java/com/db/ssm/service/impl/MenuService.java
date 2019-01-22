package com.db.ssm.service.impl;

import com.db.ssm.common.vo.Node;
import com.db.ssm.pojo.Menu;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/1/21 0021 下午 4:37
 */
public interface MenuService {
    //查询菜单信息
    List<Map<String,Object>> findObjects();

    //删除菜单信息
    int deleteObject(Integer id);

    //呈现菜单信息
    List<Node> findZtreeMenuNodes();

    //添加菜单信息
    void saveObkect(Menu menu);

}
