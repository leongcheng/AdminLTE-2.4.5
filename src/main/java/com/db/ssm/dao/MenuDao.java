package com.db.ssm.dao;

import com.db.ssm.common.vo.Node;
import com.db.ssm.pojo.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 菜单管理
 * Created by Administrator on 2019/1/21 0021 下午 4:29
 * @author Administrator
 */
public interface MenuDao {
    //查询菜单
    List<Map<String, Object>> findObjects();

    //查询子元素菜单信息
    int query(Integer id);

    //删除菜单元素
    int deleteObject(Integer id);

    //添加菜单呈现信息
    List<Node> findZtreeMenuNodes();

    //添加菜单信息
    int insertMenu(Menu menu);

    //更新菜单信息
    int updateObject(Menu menu);

    //基于菜单id查找权限标识信息
    List<String> findPermissions(@Param("menuIds") Integer[] menuIds);
}


