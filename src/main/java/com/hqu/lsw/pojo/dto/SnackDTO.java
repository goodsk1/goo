package com.hqu.lsw.pojo.dto;

/**
 * @Description
 * @Author 刘圣伟 shengwei.liu@luckincoffee.com
 * @Date 2019/4/24 20:59
 */
public class SnackDTO {

    Integer id;

    String sName;

    String sPrice;

    Integer sSCore;

    String sDese;

    String sPictureUrl;

    /**
     * 获取
     *
     * @return id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * 设置
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取
     *
     * @return sName
     */
    public String getSName() {
        return this.sName;
    }

    /**
     * 设置
     *
     * @param sName
     */
    public void setSName(String sName) {
        this.sName = sName;
    }

    /**
     * 获取
     *
     * @return sPrice
     */
    public String getSPrice() {
        return this.sPrice;
    }

    /**
     * 设置
     *
     * @param sPrice
     */
    public void setSPrice(String sPrice) {
        this.sPrice = sPrice;
    }

    /**
     * 获取
     *
     * @return sSCore
     */
    public Integer getSSCore() {
        return this.sSCore;
    }

    /**
     * 设置
     *
     * @param sSCore
     */
    public void setSSCore(Integer sSCore) {
        this.sSCore = sSCore;
    }

    /**
     * 获取
     *
     * @return sDese
     */
    public String getSDese() {
        return this.sDese;
    }

    /**
     * 设置
     *
     * @param sDese
     */
    public void setSDese(String sDese) {
        this.sDese = sDese;
    }

    /**
     * 获取
     *
     * @return sPictureUrl
     */
    public String getSPictureUrl() {
        return this.sPictureUrl;
    }

    /**
     * 设置
     *
     * @param sPictureUrl
     */
    public void setSPictureUrl(String sPictureUrl) {
        this.sPictureUrl = sPictureUrl;
    }
}
