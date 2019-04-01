package com.hqu.lsw.pojo.entity;


import java.util.Set;

/**
 * @Description 我的订单实体
 * @Author shengwei.liu
 * @Date 2019/4/1 10:18
 */
public class DoMyOrder {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 订单id
     */
    private String oId;

    /**
     * 会员id
     */
    private Integer uId;

    /**
     * 操作的管理员id
     */
    private Integer eId;

    /**
     * 下订单的时间
     */
    private String oTime;

    /**
     * 收货信息表id
     */
    private Integer rId;

    /**
     * 订单类型(-1:未发货；1:完成，0：已发货)
     */
    private Integer oType;

    /**
     *订单收货人姓名
     */
    private String oName;

    /**
     * 收货人手机号
     */
    private String oPhone;

    /**
     * 收货人地址
     */
    private String oAddress;

    /**
     * 订单里商品的详情
     */
    private Set<OrderDetail> orderdetailSet;

    public DoMyOrder(){

    }

    public DoMyOrder(Set<OrderDetail> orderdetailSet) {
        super();
        this.setOrderdetailSet(orderdetailSet);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public String getoId() {
        return oId;
    }


    public void setoId(String oId) {
        this.oId = oId;
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


    public Integer getuId() {
        return uId;
    }


    public void setuId(Integer uId) {
        this.uId = uId;
    }


    public String getoTime() {
        return oTime;
    }


    public void setoTime(String oTime) {
        this.oTime = oTime;
    }


    public Integer getoType() {
        return oType;
    }


    public void setoType(Integer oType) {
        this.oType = oType;
    }


    public Set<OrderDetail> getOrderdetailSet() {
        return orderdetailSet;
    }


    public void setOrderdetailSet(Set<OrderDetail> orderdetailSet) {
        this.orderdetailSet = orderdetailSet;
    }
}
