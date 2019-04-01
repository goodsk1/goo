package com.hqu.lsw.pojo.entity;

import java.util.Set;


/**
 * @Description 收货信息实体
 * @Author shengwei.liu
 * @Date 2019/4/1 10:18
 */
public class Receiptinfo {
    /**
     * 主键id
     */
	private Integer rId;

    /**
     * 订单id
     */
    private String oId;

    /**
     * 订单收货人姓名
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
     * 订单详情
     */
    private Set<OrderDetail> orderDetailSet;
    
    public Receiptinfo(){
    	
    }

    public Receiptinfo(Set<OrderDetail> orderDetailSet) {
		super();
		this.orderDetailSet = orderDetailSet;
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

	public Set<OrderDetail> getOrderdetailSet() {
		return orderDetailSet;
	}

	public void setOrderdetailSet(Set<OrderDetail> orderdetailSet) {
		this.orderDetailSet = orderdetailSet;
	}

	@Override
	public String toString() {
		return "Receiptinfo [rId=" + rId + ", oId=" + oId + ", oName=" + oName
				+ ", oPhone=" + oPhone + ", oAddress=" + oAddress
				+ ", orderdetailSet=" + orderDetailSet + "]";
	}
}
