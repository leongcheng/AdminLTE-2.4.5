package com.db.ssm.vo;


import com.db.ssm.pojo.Dept;

/**
 * 用户关联部门信息表
 * Created by Administrator on 2019/1/25 0025 下午 10:50
 */
public class UserDept extends BasePojo {
    private static final long serialVersionUID = -2020234421156626182L;
    private Integer id;
    //用户名
    private String username;
    //md5密码
    private String password;
    //盐值加密
    private String salt;
    //邮箱
    private String email;
    //电话
    private String mobile;
    private Integer valid = 1;
    //部门表
    private Dept dept;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "UserDept{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", valid=" + valid +
                ", dept=" + dept +
                '}';
    }
}
