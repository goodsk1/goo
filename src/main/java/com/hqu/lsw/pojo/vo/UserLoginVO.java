package com.hqu.lsw.pojo.vo;

import javax.validation.constraints.Pattern;

/**
 * @Description: 从前端获取的的用户登录或注册信息vo
 * @Author: shengwei.liu@luckincoffee.com
 * @Date:2019/4/19 18:12
 * */
public class UserLoginVO {
    /*
     * 用户帐号
     */
    @Pattern(regexp = "^[a-zA-Z0-9_-]{4,16}$",message = "用户名必须为4到16位（字母，数字，下划线，减号）")
    private String loginName;
    /*
     * 用户密码
     *
     * */
    @Pattern(regexp = "^\\w{4,16}$",message = "密码必须为4到16位（数字，字母，下划线）")
    private String loginPwd;


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
     * 获取 用户密码
     *
     * @return loginPwd 用户密码
     */
    public String getLoginPwd() {
        return this.loginPwd;
    }

    /**
     * 设置 用户密码
     *
     * @param loginPwd 用户密码
     */
    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }
}
