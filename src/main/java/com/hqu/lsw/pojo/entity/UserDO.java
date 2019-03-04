package com.hqu.lsw.pojo.entity;

import javax.validation.constraints.Pattern;

/**
 * @Description 用户实体
 * @Author shengwei.liu@luckincoffee.com
 * @Date 2019/3/4
 */
public class UserDO {
    /**
     * 用户id
     */
    private Long id;

    /**
     * 登录名
     */
    @Pattern(regexp = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})", message = "用户名必须是2-5位中文或者6-16位英文和数字的组合")
    private String loginName;

    /**
     *登陆密码
     */
    private String loginPwd;

    /**
     * 真实姓名
     */
    private String trueName;

    /**
     * 邮箱
     */
    @Pattern(regexp = "^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$", message = "邮箱格式不正确")
    private String email;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 地址
     */
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
