package com.hqu.lsw.pojo.dto;

/**
 * @Description 厂家分页条件查询DTO
 * @Author shengwei.liu@ luckincoffee.com
 * @Date 2019/2/16
 */
public class ManufactorQueryPageDTO {


    /**
     * 主键id
     */
    private Long id;


    /**
     * 厂家名称
     */
    private String nickName;


    /**
     * 厂家地址
     */
    private String address;


    /**
     * 厂家所在城市
     */
    private String city;

    /**
     * 厂家所在行业
     */
    private String industry;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }
}




















