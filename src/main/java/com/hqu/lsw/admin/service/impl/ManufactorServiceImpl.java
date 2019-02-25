package com.hqu.lsw.admin.service.impl;

import com.hqu.lsw.admin.dao.ManufactorMapper;
import com.hqu.lsw.admin.service.ManufactorService;
import com.hqu.lsw.pojo.PaginationResult;
import com.hqu.lsw.pojo.bo.ManufactorBO;
import com.hqu.lsw.pojo.dto.ManufactorQueryPageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description 厂家相关操作service实现类
 * @Author shengwei.liu@ luckincoffee.com
 * @Date 2019/2/25
 */
@Service
public class ManufactorServiceImpl implements ManufactorService {

    /**
     * 厂家相关操作dao接口
     */
    @Autowired
    private ManufactorMapper manufactorMapper;


    /**
     * 查询厂家信息列表
     * @param manufactorQueryPageDTO 厂家查询条件封装对象
     * @return
     */
    @Override
    public PaginationResult<ManufactorBO> getManufactorList(ManufactorQueryPageDTO manufactorQueryPageDTO) {
        Long count = manufactorMapper.countByExample(manufactorQueryPageDTO);
        List<ManufactorBO> manufactorBOList = manufactorMapper.getManufactorList(manufactorQueryPageDTO);
        return new PaginationResult<>(count,manufactorBOList);
    }
}
