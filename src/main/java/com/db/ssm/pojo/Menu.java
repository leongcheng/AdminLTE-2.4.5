package com.db.ssm.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 封装用户添加请求中的菜单数据
 * Created by Administrator on 2019/1/21 0021 下午 8:43
 */
public class Menu implements Serializable {
    private static final long serialVersionUID = -8817528184356944164L;
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
    /**创建用户*/
    private String createdUser;
    /**修改用户*/
    private String modifiedUser;
    private Date createdTime;
    private Date modifiedTime;

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

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", parentId=" + parentId +
                ", url='" + url + '\'' +
                ", permission='" + permission + '\'' +
                ", sort=" + sort +
                ", note='" + note + '\'' +
                ", createdUser='" + createdUser + '\'' +
                ", modifiedUser='" + modifiedUser + '\'' +
                ", createdTime=" + createdTime +
                ", modifiedTime=" + modifiedTime +
                '}';
    }
}
