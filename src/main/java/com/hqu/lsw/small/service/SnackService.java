package com.hqu.lsw.small.service;

import com.hqu.lsw.pojo.dto.CategoryDTO;

import java.util.List;

/**
 * @Description 零食相关service
 * @Author 刘圣伟 shengwei.liu@luckincoffee.com
 * @Date 2019/4/24 20:56
 */
public interface SnackService {

    /**
     * 获取零食列表怕
     *
     * @return List<CategoryDTO>
     */
    List<CategoryDTO> getSnackList();
}
