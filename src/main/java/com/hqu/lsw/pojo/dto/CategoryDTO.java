package com.hqu.lsw.pojo.dto;

import java.util.List;

/**
 * @Description: 零食类别
 * @Author: shengwei.liu@luckincoffee.com
 * @Date:2019/4/19 18:12
 */
public class CategoryDTO {

    /*
     * 零食分类id
     * */
    private Integer id;

    /*
     * 零食分类
     * */
    private String name;

    /**
     * 零食列表
     */
    private List<SnackDTO> snackDTOS;

    /**
     * 获取 零食分类id
     *
     * @return id 零食分类id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * 设置 零食分类id
     *
     * @param id 零食分类id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 零食分类
     *
     * @return name 零食分类
     */
    public String getName() {
        return this.name;
    }

    /**
     * 设置 零食分类
     *
     * @param name 零食分类
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     *
     * @return snackDTOS
     */
    public List<SnackDTO> getSnackDTOS() {
        return this.snackDTOS;
    }

    /**
     * 设置
     *
     * @param snackDTOS
     */
    public void setSnackDTOS(List<SnackDTO> snackDTOS) {
        this.snackDTOS = snackDTOS;
    }
}
