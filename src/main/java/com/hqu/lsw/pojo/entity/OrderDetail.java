package com.hqu.lsw.pojo.entity;


/**
 * @Description 订单详情实体
 * @Author shengwei.liu
 * @Date 2019/4/1 10:18
 */
public class OrderDetail {
    /**
     * 主键id
     */
	private Integer dId;

    /**
     * 订单id
     */
    private String oId;

    /**
     * 零食名称
     */
    private String sName;

    /**
     * 零食id
     */
	private Integer sId;

    /**
     * 购买零食数量
     */
    private Integer oNum;

    /**
     * 订单总额
     */
    private Double oMoney;

    /**
     * 零食实体
     */
    private Snackinfo snackinfo;
    
	public Snackinfo getSnackinfo() {
		return snackinfo;
	}

	public void setSnackinfo(Snackinfo snackinfo) {
		this.snackinfo = snackinfo;
	}

	public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
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
    
    @Override
   	public String toString() {
   		return "Orderdetail [dId=" + dId + ", oId=" + oId + ", sName=" + sName
   				+ ", sId=" + sId + ", oNum=" + oNum + ", oMoney=" + oMoney
   				+ ", snackinfo=" + snackinfo + "]";
   	}
}
