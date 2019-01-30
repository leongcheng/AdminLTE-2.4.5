package com.db.ssm.vo;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/1/27 0027 下午 7:36
 */
public class CheckBox implements Serializable {
    private static final long serialVersionUID = -4974104316447268117L;
    private Integer id;
    private String name;

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

    @Override
    public String toString() {
        return "CheckBox{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
