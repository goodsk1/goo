package com.hqu.lsw.pojo.entity;

import java.util.Date;


/**
 * @Description 订单实体
 * @Author shengwei.liu
 * @Date 2019/4/1
 */
public class Order {
    /**
     * 主键id
     */
    private Integer id;

    /**
     *订单编号
     */
    private String oId;

    /**
     * 用户id
     */
    private Integer uId;

    /**
     * 操作员id
     */
    private Integer eId;

    /**
     * 订单提交时间
     */
    private Date oTime;

    /**
     * 订单类型（-1:未发货；1:完成，0：已发货）
     */
    private Integer oType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public Date getoTime() {
        return oTime;
    }

    public void setoTime(Date oTime) {
        this.oTime = oTime;
    }

    public Integer getoType() {
        return oType;
    }

    public void setoType(Integer oType) {
        this.oType = oType;
    }
}

















