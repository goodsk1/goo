package com.hqu.lsw.pojo.entity;


/**
 * @Description 管理员查看订单对象
 * @Author shengwei.liu
 * @Date 2019/4/1 10:18
 */
public class DoAdminOrder {

    /**
     * t_order表主键id
     */
    int id;

    /**
     * 订单编号
     */
    String oId;

    /**
     * 用户id
     */
    int uId;

    /**
     * 执行发货，修改相关操作的管理员id
     */
    int eId;

    /**
     * 下订单的时间
     */
    String oTime;

    /**
     * 订单类型
     */
    int oType;

    /**
     * 收货信息表主键id
     */
    int rId;

    /**
     * 订单姓名
     */
    String oName;

    /**
     * 订单手机号
     */
    String oPhone;

    /**
     * 收货地址
     */
    String oAddress;

    /**
     * 管理员id
     */
    int adId;

    /**
     * 管理员登录名
     */
    String adUsername;

    /**
     * 会员登录名
     */
    String uUsername;

    public String getuUsername() {
        return uUsername;
    }

    public void setuUsername(String uUsername) {
        this.uUsername = uUsername;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public int geteId() {
        return eId;
    }

    public void seteId(int eId) {
        this.eId = eId;
    }

    public String getoTime() {
        return oTime;
    }

    public void setoTime(String oTime) {
        this.oTime = oTime;
    }

    public int getoType() {
        return oType;
    }

    public void setoType(int oType) {
        this.oType = oType;
    }

    public int getrId() {
        return rId;
    }

    public void setrId(int rId) {
        this.rId = rId;
    }

    public String getoName() {
        return oName;
    }

    public void setoName(String oName) {
        this.oName = oName;
    }

    public String getoPhone() {
        return oPhone;
    }

    public void setoPhone(String oPhone) {
        this.oPhone = oPhone;
    }

    public String getoAddress() {
        return oAddress;
    }

    public void setoAddress(String oAddress) {
        this.oAddress = oAddress;
    }

    public int getAdId() {
        return adId;
    }

    public void setAdId(int adId) {
        this.adId = adId;
    }

    public String getAdUsername() {
        return adUsername;
    }

    public void setAdUsername(String adUsername) {
        this.adUsername = adUsername;
    }
}
