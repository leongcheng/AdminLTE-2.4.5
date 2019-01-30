package com.db.ssm.vo;

import java.io.Serializable;
import java.util.List;

/**
 *  定义值对象用于封装角色和菜单数据，
 *  可以基于角色id查询角色和菜单数据
 *  然后封装到此对象
 * Created by Administrator on 2019/1/23 0023 下午 3:48
 */
public class RoleMenu implements Serializable {
    private static final long serialVersionUID = 4869958646399973026L;
    /**角色名称*/
    private String name;
    /**角色备注*/
    private String note;
    /**菜单id*/
    private List<Integer> menuIds;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<Integer> getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(List<Integer> menuIds) {
        this.menuIds = menuIds;
    }

    @Override
    public String toString() {
        return "RoleMenu{" +
                "name='" + name + '\'' +
                ", note='" + note + '\'' +
                ", menuIds=" + menuIds +
                '}';
    }
}
