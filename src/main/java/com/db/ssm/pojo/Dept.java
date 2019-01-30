package com.db.ssm.pojo;

import com.db.ssm.vo.BasePojo;

/**
 * 部门信息
 * Created by Administrator on 2019/1/22 0022 下午 3:45
 */
public class Dept extends BasePojo {
    private static final long serialVersionUID = -821969250691934494L;
    private Integer id;
    /**部门名称*/
    private String name;
    /**部门id*/
    private Integer parentId;
    /**排序号*/
    private Integer sort;
    /**备注*/
    private String note;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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
        return "Dept{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentId=" + parentId +
                ", sort=" + sort +
                ", note='" + note + '\'' +
                '}';
    }
}
