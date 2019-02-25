package com.hqu.lsw.pojo.bo;

/**
 * @Description 厂家信息列表展示BO
 * @Author shengwei.liu@ luckincoffee.com
 * @Date 2019/2/16
 */
public class ManufactorBO {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 厂家昵称
     */
    private String nickName;

    /**
     * 厂家地址
     */
    private String address;

    /**
     * 厂家电话
     */
    private String phone;

    /**
     * 厂家邮箱
     */
    private String email;

    /**
     * 厂家所属行业
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }
}























