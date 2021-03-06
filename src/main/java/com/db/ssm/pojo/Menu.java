package com.db.ssm.pojo;


import com.db.ssm.vo.BasePojo;

/**
 * 菜单管理
 * Created by Administrator on 2019/1/21 0021 下午 8:43
 */
public class Menu extends BasePojo {
    private static final long serialVersionUID = -3984949352091671663L;
    private Integer id;
    /**菜单类型(两种:按钮,普通菜单)*/
    private Integer type = 1;
    /**菜单名称*/
    private String name;
    /**上级菜单id*/
    private Integer parentId;
    /**菜单url*/
    private String url;
    /**授权标识(sys:log:delete)*/
    private String permission;
    /**排序号*/
    private Integer sort;
    /**备注*/
    private String note;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", parentId=" + parentId +
                ", url='" + url + '\'' +
                ", permission='" + permission + '\'' +
                ", sort=" + sort +
                ", note='" + note + '\'' +
                '}';
    }
}
