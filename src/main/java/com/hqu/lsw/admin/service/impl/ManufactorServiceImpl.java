package com.hqu.lsw.admin.service.impl;

import com.alibaba.fastjson.JSON;
import com.hqu.lsw.admin.dao.ManufactorMapper;
import com.hqu.lsw.admin.service.ManufactorService;
import com.hqu.lsw.pojo.PaginationResult;
import com.hqu.lsw.pojo.bo.ManufactorBO;
import com.hqu.lsw.pojo.dto.ManufactorQueryPageDTO;
import com.hqu.lsw.pojo.dto.OperationLogDTO;
import com.hqu.lsw.pojo.entity.ManufactorDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    protected Logger LOGGER = LoggerFactory.getLogger(ManufactorServiceImpl.class);

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
        List<ManufactorBO> manufactorBOList = manufactorMapper.listManufactor(manufactorQueryPageDTO);
        return new PaginationResult<>(count,manufactorBOList);
    }

    /**
     * 新增厂家信息记录
     * @param manufactorDO
     * @return
     */
    @Override
    public void addManufactor(ManufactorDO manufactorDO) {
        manufactorMapper.addManufactor(manufactorDO);
    }

    /**
     * 插入操作记录
     *
     * @param operationLogDTO
     */
    @Override
    public void insertOperationLog(OperationLogDTO operationLogDTO) {
        try{
            manufactorMapper.insertOperationLog(operationLogDTO);
        }catch (Exception e){
            LOGGER.error("插入操作记录失败：operationLogDTO{}, {}", JSON.toJSON(operationLogDTO),e);
        }
    }

    /**
     * 删除厂家信息
     * @return
     */
    @Override
    public Long deleteManufactor(Long id){
        return manufactorMapper.deleteManufactor(id);
    }
}

















