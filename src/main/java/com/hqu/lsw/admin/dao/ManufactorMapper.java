package com.hqu.lsw.admin.dao;

import com.hqu.lsw.pojo.bo.ManufactorBO;
import com.hqu.lsw.pojo.dto.ManufactorQueryPageDTO;

import java.util.List;

/**
 * @Description 商家Dao层接口
 * @Author shengwei.liu@ luckincoffee.com
 * @Date 2019/2/16
 */
public interface ManufactorMapper {

    /**
     * 查询厂家信息列表
     * @param manufactorQueryPageDTO 厂家查询条件封装对象
     * @return
     */
    List<ManufactorBO> listManufactor(ManufactorQueryPageDTO manufactorQueryPageDTO);

    /**
     * 获取商家总数
     * @param manufactorQueryPageDTO
     * @return
     */
    Long countByExample(ManufactorQueryPageDTO manufactorQueryPageDTO);
}
