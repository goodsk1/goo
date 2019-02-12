package com.hqu.lsw.pojo;


import java.util.Date;

/**
 * @Description 管理员实体类
 * @Author shengwei.liu@ luckincoffee.com
 * @Date 2019/1/21
 */
public class AdminDO {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 登陆名
     */
    private String adminName;

    /**
     * 登陆密码
     */
    private String adminPwd;

    /**
     * 邮箱
     */
    private String adminEmail;

    /**
     * 登陆时间
     */
    private Date loginTime;

    /**
     * 登陆ip
     */
    private String loginIp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }
}















