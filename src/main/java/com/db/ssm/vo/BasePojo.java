package com.db.ssm.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2019/1/22 0022 下午 9:34
 */
public class BasePojo implements Serializable {
    private static final long serialVersionUID = -842126683906034139L;
    /**创建用户*/
    private Date createdTime;
    /**修改用户*/
    private Date modifiedTime;
    /**创建时间*/
    private String createdUser;
    /**修改时间*/
    private String modifiedUser;

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

    @Override
    public String toString() {
        return "BasePojo{" +
                "createdTime=" + createdTime +
                ", modifiedTime=" + modifiedTime +
                ", createdUser='" + createdUser + '\'' +
                ", modifiedUser='" + modifiedUser + '\'' +
                '}';
    }
}
