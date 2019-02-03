package com.db.ssm.pojo;

import com.db.ssm.vo.BasePojo;

/**
 * 系统资源
 * Created by Administrator on 2019/2/3 0003 下午 6:49
 */
public class Config  extends BasePojo {
    private static final long serialVersionUID = 8663513563966987641L;
    private Integer id;
    private String name;
    private String note;
    private String value;

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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Config{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", note='" + note + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
