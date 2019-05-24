package com.hqu.lsw.pojo;

import com.hqu.lsw.pojo.dto.UserDTO;

/**
 * @Description
 * @Author 刘圣伟 shengwei.liu@luckincoffee.com
 * @Date 2019/4/12 20:44
 */
public class Address {

    /*
     * 主键id
     * */
    private Integer id;

    /*
     * 地址明细
     * */
    private String detail;

    /*
     * 是否默认
     * */
    private Boolean isDefault;

    /*
     * 关联用户信息
     * */
    private Integer userId;

    /**
     * 获取 地址id
     *
     * @return id 地址id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * 设置 地址id
     *
     * @param id 地址id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 地址明细
     *
     * @return detail 地址明细
     */
    public String getDetail() {
        return this.detail;
    }

    /**
     * 设置 地址明细
     *
     * @param detail 地址明细
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }

    /**
     * 获取 是否默认
     *
     * @return isDefault 是否默认
     */
    public Boolean getIsDefault() {
        return this.isDefault;
    }

    /**
     * 设置 是否默认
     *
     * @param isDefault 是否默认
     */
    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    /**
     * 获取 关联用户信息
     *
     * @return userId 关联用户信息
     */
    public Integer getUserId() {
        return this.userId;
    }

    /**
     * 设置 关联用户信息
     *
     * @param userId 关联用户信息
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
