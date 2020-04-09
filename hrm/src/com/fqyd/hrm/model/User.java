package com.fqyd.hrm.model;

import java.util.Date;

public class User {
    /**
     * 用户ID
     */
    private Integer id;

    /**
     * 登录名称
     */
    private String username;

    /**
     * 用户名
     */
    private String realname;

    /**
     * 密码
     */
    private String password;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 注册时间
     */
    private Date createTime;

    /**
     * 用户ID
     * @return id 用户ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 用户ID
     * @param id 用户ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 登录名称
     * @return username 登录名称
     */
    public String getUsername() {
        return username;
    }

    /**
     * 登录名称
     * @param username 登录名称
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 用户名
     * @return realname 用户名
     */
    public String getRealname() {
        return realname;
    }

    /**
     * 用户名
     * @param realname 用户名
     */
    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    /**
     * 密码
     * @return password 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 状态
     * @return status 状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态
     * @param status 状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 注册时间
     * @return create_time 注册时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 注册时间
     * @param createTime 注册时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", realname=").append(realname);
        sb.append(", password=").append(password);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}