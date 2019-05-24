package com.hqu.lsw.pojo;

import java.util.Date;

/**
 * @Description: 映射数据库用户表的实体类
 * @Author: shengwei.liu@luckincoffee.com
 * @Date:2019/4/19 18:12
 * */
public class User {
    /*
     * 用户id
     * */
    private Integer id;

    /*
     * 用户帐号
     * */
    private String loginName;

    /*
     * 用户名字
     * */
    private String trueName;

    /*
     * 用户性别
     * */
    private Boolean sex;

    /*
     * 电话
     * */
    private String phone;

    /*
     * 用户密码
     * */
    private String password;

    /*
     * 用户剩余积分
     * */
    private Integer score;

    /**
     * 获取 用户id
     *
     * @return id 用户id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * 设置 用户id
     *
     * @param id 用户id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 用户帐号
     *
     * @return loginName 用户帐号
     */
    public String getLoginName() {
        return this.loginName;
    }

    /**
     * 设置 用户帐号
     *
     * @param loginName 用户帐号
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * 获取 用户名字
     *
     * @return trueName 用户名字
     */
    public String getTrueName() {
        return this.trueName;
    }

    /**
     * 设置 用户名字
     *
     * @param trueName 用户名字
     */
    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    /**
     * 获取 用户性别
     *
     * @return sex 用户性别
     */
    public Boolean getSex() {
        return this.sex;
    }

    /**
     * 设置 用户性别
     *
     * @param sex 用户性别
     */
    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    /**
     * 获取 电话
     *
     * @return phone 电话
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     * 设置 电话
     *
     * @param phone 电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取 用户密码
     *
     * @return password 用户密码
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * 设置 用户密码
     *
     * @param password 用户密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取 用户剩余积分
     *
     * @return score 用户剩余积分
     */
    public Integer getScore() {
        return this.score;
    }

    /**
     * 设置 用户剩余积分
     *
     * @param score 用户剩余积分
     */
    public void setScore(Integer score) {
        this.score = score;
    }
}