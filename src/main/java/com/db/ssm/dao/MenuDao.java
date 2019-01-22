package com.db.ssm.dao;

import com.db.ssm.common.mapper.SysMapper;
import com.db.ssm.common.vo.Node;
import com.db.ssm.pojo.Menu;

import java.util.List;
import java.util.Map;

/**
 * 菜单管理
 * Created by Administrator on 2019/1/21 0021 下午 4:29
 */
public interface MenuDao extends SysMapper<Menu> {
    //查询菜单
    List<Map<String,Object>> findObjects();
    //查询子元素菜单信息
    int query(Integer id);
    //删除菜单元素
    int deleteObject(Integer id);
    //修改菜单信息
    List<Node> findZtreeMenuNodes();
    //添加菜单信息
//    int insertMenu(Menu menu);
}
