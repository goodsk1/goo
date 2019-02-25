package com.hqu.lsw.admin.controller;

import com.hqu.lsw.admin.common.CommonConstants;
import com.hqu.lsw.admin.service.ManufactorService;
import com.hqu.lsw.pojo.PaginationResult;
import com.hqu.lsw.pojo.ResultInfo;
import com.hqu.lsw.pojo.ao.ManufactorQueryPageAO;
import com.hqu.lsw.pojo.bo.ManufactorBO;
import com.hqu.lsw.pojo.dto.ManufactorQueryPageDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description 合作厂家相关操作Controller
 * @Author shengwei.liu@ luckincoffee.com
 * @Date 2019/2/15
 */
@Controller
@RequestMapping("/manufactor")
public class ManufactorController {

    /**
     * 厂家相关操作servie接口
     */
    @Autowired
    private ManufactorService manufactorService;

    /**
     * 跳转合作厂家列表
     * @return
     */
    @RequestMapping("/toManufactorList")
    public String toManufactorList(){
        return "admin/manufactorList";
    }

    /**
     * 查询厂家列表
     * @param manufactorQueryPageAO
     * @return
     */
    @RequestMapping("/getList")
    @ResponseBody
    public ResultInfo getList(ManufactorQueryPageAO manufactorQueryPageAO){
        if(manufactorQueryPageAO == null){
            ResultInfo.errorMessage("参数错误");
        }
        ManufactorQueryPageDTO manufactorQueryPageDTO = buildManufactorDTO(manufactorQueryPageAO);
        PaginationResult<ManufactorBO> page = manufactorService.getManufactorList(manufactorQueryPageDTO);
        return ResultInfo.success(page);

    }

    /**
     * 组装DTO
     * @param manufactorQueryPageAO
     * @return
     */
    public ManufactorQueryPageDTO buildManufactorDTO(ManufactorQueryPageAO manufactorQueryPageAO){
        ManufactorQueryPageDTO manufactorQueryPageDTO = new ManufactorQueryPageDTO();
        manufactorQueryPageDTO.setPageNo(manufactorQueryPageAO.getPage());
        if(manufactorQueryPageAO.getRows() == CommonConstants.INT_ZERO.intValue()){
            manufactorQueryPageDTO.setPageSize(CommonConstants.SIZE);
        }else{
            manufactorQueryPageDTO.setPageSize(manufactorQueryPageAO.getRows());
        }
        BeanUtils.copyProperties(manufactorQueryPageAO,manufactorQueryPageDTO);
        return manufactorQueryPageDTO;
    }

}

