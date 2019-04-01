package com.hqu.lsw.pojo.entity;


/**
 * @Description 订单详情中展示的对象
 * @Author shengwei.liu
 * @Date 2019/4/1 10:18
 */
public class DoSnack {

    /**
     * 订单详情orderdetail表的主键id
     */
    private int dId;

    /**
     * 订单数量
     */
    private Integer oNum;

    /**
     * 订单金额
     */
    private Double oMoney;

    /**
     * snack表的图片url字段
     */
    private String picUrl;

    /**
     *零食名字
     */
    private String sName;

    public int getdId() {
        return dId;
    }

    public void setdId(int dId) {
        this.dId = dId;
    }

    public Integer getoNum() {
        return oNum;
    }

    public void setoNum(Integer oNum) {
        this.oNum = oNum;
    }

    public Double getoMoney() {
        return oMoney;
    }

    public void setoMoney(Double oMoney) {
        this.oMoney = oMoney;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }
}
