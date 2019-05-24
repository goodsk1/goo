package com.hqu.lsw.small.service.impl;

import com.hqu.lsw.pojo.dto.CategoryDTO;
import com.hqu.lsw.small.dao.SnackMapper;
import com.hqu.lsw.small.service.SnackService;

import java.util.List;

/**
 * @Description 零食相关service实现类
 * @Author 刘圣伟 shengwei.liu@luckincoffee.com
 * @Date 2019/4/24 20:56
 */
public class SnackServiceImpl implements SnackService {

    /**
     * 零食dao接口
     */
    SnackMapper snackMapper;

    /**
     * 获取零食列表怕
     *
     * @return List<CategoryDTO>
     */
    public List<CategoryDTO> getSnackList() {
        return snackMapper.getSnackList();
    }

}
