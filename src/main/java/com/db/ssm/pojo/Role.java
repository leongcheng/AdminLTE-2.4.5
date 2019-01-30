package com.db.ssm.pojo;


import com.db.ssm.vo.BasePojo;

/**
 * 角色信息
 * Created by Administrator on 2019/1/22 0022 下午 9:24
 */
public class Role extends BasePojo {
    private static final long serialVersionUID = 3011034502104280496L;
    private Integer id;
    private String name;
    private String note;

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

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
