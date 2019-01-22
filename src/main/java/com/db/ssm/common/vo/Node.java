package com.db.ssm.common.vo;

import java.io.Serializable;

/**
 * 修改菜单页面封装数据
 * Created by Administrator on 2019/1/21 0021 下午 7:53
 */
public class Node implements Serializable {

    private static final long serialVersionUID = 923482583847441316L;
    private Integer id;
    private String name;
    private Integer parentId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentId=" + parentId +
                '}';
    }
}
