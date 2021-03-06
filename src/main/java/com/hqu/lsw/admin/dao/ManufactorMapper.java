package com.hqu.lsw.admin.dao;

import com.hqu.lsw.pojo.bo.ManufactorBO;
import com.hqu.lsw.pojo.dto.ManufactorQueryPageDTO;
import com.hqu.lsw.pojo.dto.OperationLogDTO;
import com.hqu.lsw.pojo.entity.ManufactorDO;

import java.util.List;

/**
 * @Description 商家Dao层接口
 * @Author shengwei.liu@luckincoffee.com
 * @Date 2019/2/16
 */
public interface ManufactorMapper {

    /**
     * 查询厂家信息列表
     *
     * @param manufactorQueryPageDTO 厂家查询条件封装对象
     * @return
     */
    List<ManufactorBO> listManufactor(ManufactorQueryPageDTO manufactorQueryPageDTO);

    /**
     * 获取商家总数
     *
     * @param manufactorQueryPageDTO
     * @return
     */
    Long countByExample(ManufactorQueryPageDTO manufactorQueryPageDTO);

    /**
     * 新增厂家信息记录
     *
     * @param manufactorDO
     * @return
     */
    int addManufactor(ManufactorDO manufactorDO);

    /**
     * 插入物料操作记录
     *
     * @param operationLogDTO
     */
    void insertOperationLog(OperationLogDTO operationLogDTO);

    /**
     * 删除厂家信息
     * @param id
     * @return
     */
    Long deleteManufactor(Long id);
}
















