package com.hqu.lsw.small.dao;

import com.hqu.lsw.pojo.dto.CategoryDTO;

import java.util.List;

/**
 * @Description
 * @Author 刘圣伟 shengwei.liu@luckincoffee.com
 * @Date 2019/4/22 21:03
 */
public interface SnackMapper {

    /**
     * 获取零食列表
     *
     * @return: 零食列表
     * */
    List<CategoryDTO> getSnackList();
}
