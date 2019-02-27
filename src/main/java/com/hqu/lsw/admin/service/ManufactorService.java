package com.hqu.lsw.admin.service;

import com.hqu.lsw.pojo.PaginationResult;
import com.hqu.lsw.pojo.bo.ManufactorBO;
import com.hqu.lsw.pojo.dto.ManufactorQueryPageDTO;
import com.hqu.lsw.pojo.dto.OperationLogDTO;
import com.hqu.lsw.pojo.entity.ManufactorDO;

import java.util.List;

/**
 * @Description 厂家相关操作service
 * @Author shengwei.liu@ luckincoffee.com
 * @Date 2019/2/25
 */
public interface ManufactorService {


    /**
     * 查询厂家信息列表
     *
     * @param manufactorQueryPageDTO 厂家查询条件封装对象
     * @return
     */
    PaginationResult<ManufactorBO> getManufactorList(ManufactorQueryPageDTO manufactorQueryPageDTO);

    /**
     * 新增厂家信息记录
     *
     * @param manufactorDO
     * @return
     */
    void addManufactor(ManufactorDO manufactorDO);

    /**
     * 插入操作记录
     *
     * @param operationLogDTO
     */
    void insertOperationLog(OperationLogDTO operationLogDTO);

}
