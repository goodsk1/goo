package com.hqu.lsw.pojo.entity;

/**
 * @Description
 * @Author 刘圣伟 shengwei.liu@luckincoffee.com
 * @Date 2019/3/26 14:57
 */

public class Snackinfo {
    /**
     * 主键id
     */
    private Integer sId;

    /**
     * 批次号
     */
    private String sBatch;

    /**
     * 零食名字
     */
    private String sName;

    /**
     * 零食价格
     */
    private Double sPrice;

    /**
     * 零食折扣
     */
    private String sDiscount;

    /**
     * 零食图片url
     */
    private String sPictureurl;

    /**
     * 零食品牌
     */
    private String sBrand;

    /**
     * 零食产地
     */
    private String sPlace;

    /**
     * 零食是否进口（1是，0不是）
     */
    private Integer sImported;

    /**
     * 零食购买可获得的积分
     */
    private Integer sScore;

    /**
     * 零食生产日期
     */
    private String sPdate;

    /**
     * 保质期
     */
    private String sQdate;

    /**
     * 当前状态（1---上架，0---草稿，-1--下架）
     */
    private Integer state;

    /**
     * 上架日期
     */
    private String sCreatedate;

    /**
     * 描述
     */
    private String sDese;

    /**
     * 剩余数量
     */
    private Integer sNumber;

    /**
     * 零食类型
     */
    private String sType;

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getsBatch() {
        return sBatch;
    }

    public void setsBatch(String sBatch) {
        this.sBatch = sBatch;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public Double getsPrice() {
        return sPrice;
    }

    public void setsPrice(Double sPrice) {
        this.sPrice = sPrice;
    }

    public String getsDiscount() {
        return sDiscount;
    }

    public void setsDiscount(String sDiscount) {
        this.sDiscount = sDiscount;
    }

    public String getsPictureurl() {
        return sPictureurl;
    }

    public void setsPictureurl(String sPictureurl) {
        this.sPictureurl = sPictureurl;
    }

    public String getsBrand() {
        return sBrand;
    }

    public void setsBrand(String sBrand) {
        this.sBrand = sBrand;
    }

    public String getsPlace() {
        return sPlace;
    }

    public void setsPlace(String sPlace) {
        this.sPlace = sPlace;
    }

    public Integer getsImported() {
        return sImported;
    }

    public void setsImported(Integer sImported) {
        this.sImported = sImported;
    }

    public Integer getsScore() {
        return sScore;
    }

    public void setsScore(Integer sScore) {
        this.sScore = sScore;
    }

    public String getsPdate() {
        return sPdate;
    }

    public void setsPdate(String sPdate) {
        this.sPdate = sPdate;
    }

    public String getsQdate() {
        return sQdate;
    }

    public void setsQdate(String sQdate) {
        this.sQdate = sQdate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getsCreatedate() {
        return sCreatedate;
    }

    public void setsCreatedate(String sCreatedate) {
        this.sCreatedate = sCreatedate;
    }

    public String getsDese() {
        return sDese;
    }

    public void setsDese(String sDese) {
        this.sDese = sDese;
    }

    public Integer getsNumber() {
        return sNumber;
    }

    public void setsNumber(Integer sNumber) {
        this.sNumber = sNumber;
    }

    @Override
    public String toString() {
        return "Snackinfo [sId=" + sId + ", sBatch=" + sBatch + ", sName="
                + sName + ", sPrice=" + sPrice + ", sDiscount=" + sDiscount
                + ", sPictureurl=" + sPictureurl + ", sBrand=" + sBrand
                + ", sPlace=" + sPlace + ", sImported=" + sImported
                + ", sScore=" + sScore + ", sPdate=" + sPdate + ", sQdate="
                + sQdate + ", state=" + state + ", sCreatedate=" + sCreatedate
                + ", sDese=" + sDese + ", sNumber=" + sNumber + "]";
    }

    public String getsType() {
        return sType;
    }

    public void setsType(String sType) {
        this.sType = sType;
    }
}
