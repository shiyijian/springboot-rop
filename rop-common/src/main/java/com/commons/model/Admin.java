package com.commons.model;

import java.io.Serializable;
import java.util.Date;

public class Admin implements Serializable{
    /**
     * id
     */
    private Long id;

    /**
     * 账户昵称
     */
    private String name;

    /**
     * 账户手机号
     */
    private String mobile;

    /**
     * 账户密码
     */
    private String password;

    /**
     * 账号状态 0禁用1正常
     */
    private Byte status;

    /**
     * 最后登录的时间
     */
    private Date lastLoginTime;

    /**
     * 创建时间
     */
    private Date gmtCreated;

    /**
     * 修改时间
     */
    private Date gmtModified;

    /**
     * 逻辑删除标志位
     */
    private Byte deleteMark;

    /**
     * 逻辑删除时间戳
     */
    private Long deleteTimestamp;

    /**
     * id
     * @return id id
     */
    public Long getId() {
        return id;
    }

    /**
     * id
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 账户昵称
     * @return name 账户昵称
     */
    public String getName() {
        return name;
    }

    /**
     * 账户昵称
     * @param name 账户昵称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 账户手机号
     * @return mobile 账户手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 账户手机号
     * @param mobile 账户手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 账户密码
     * @return password 账户密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 账户密码
     * @param password 账户密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 账号状态 0禁用1正常
     * @return status 账号状态 0禁用1正常
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 账号状态 0禁用1正常
     * @param status 账号状态 0禁用1正常
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * 最后登录的时间
     * @return last_login_time 最后登录的时间
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * 最后登录的时间
     * @param lastLoginTime 最后登录的时间
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * 创建时间
     * @return gmt_created 创建时间
     */
    public Date getGmtCreated() {
        return gmtCreated;
    }

    /**
     * 创建时间
     * @param gmtCreated 创建时间
     */
    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    /**
     * 修改时间
     * @return gmt_modified 修改时间
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * 修改时间
     * @param gmtModified 修改时间
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * 逻辑删除标志位
     * @return delete_mark 逻辑删除标志位
     */
    public Byte getDeleteMark() {
        return deleteMark;
    }

    /**
     * 逻辑删除标志位
     * @param deleteMark 逻辑删除标志位
     */
    public void setDeleteMark(Byte deleteMark) {
        this.deleteMark = deleteMark;
    }

    /**
     * 逻辑删除时间戳
     * @return delete_timestamp 逻辑删除时间戳
     */
    public Long getDeleteTimestamp() {
        return deleteTimestamp;
    }

    /**
     * 逻辑删除时间戳
     * @param deleteTimestamp 逻辑删除时间戳
     */
    public void setDeleteTimestamp(Long deleteTimestamp) {
        this.deleteTimestamp = deleteTimestamp;
    }
}