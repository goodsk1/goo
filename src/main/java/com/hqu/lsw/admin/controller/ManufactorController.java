package com.hqu.lsw.admin.controller;

import com.hqu.lsw.admin.common.CommonConstants;
import com.hqu.lsw.admin.service.ManufactorService;
import com.hqu.lsw.pojo.PaginationResult;
import com.hqu.lsw.pojo.ResultInfo;
import com.hqu.lsw.pojo.ao.ManufactorQueryPageAO;
import com.hqu.lsw.pojo.bo.ManufactorBO;
import com.hqu.lsw.pojo.dto.ManufactorQueryPageDTO;
import com.hqu.lsw.pojo.dto.OperationLogDTO;
import com.hqu.lsw.pojo.entity.ManufactorDO;
import com.hqu.lsw.pojo.enums.FunctionTypeEnum;
import com.hqu.lsw.pojo.enums.OperationEnum;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @Description 合作厂家相关操作Controller
 * @Author shengwei.liu@luckincoffee.com
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

    /**
     * 跳转厂家新增页面
     * @return
     */
    @RequestMapping("/toAddView")
    public ModelAndView toAddManufactor(){
        ModelAndView mav = new ModelAndView("admin/manufactorAdd");
        return mav;
    }

    /**
     * 新增厂家信息
     * @param manufactorDO
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo addManufactor(ManufactorDO manufactorDO,HttpSession session){
        if(manufactorDO == null){
            return ResultInfo.errorMessage("参数异常");
        }
        try{
            manufactorService.addManufactor(manufactorDO);
            //插入操作记录
            OperationLogDTO operationLogDTO = buildOperationLogDTO(OperationEnum.NEW.getIndex(),session);
            manufactorService.insertOperationLog(operationLogDTO);
            return ResultInfo.successMessage("新增成功");
        }catch (Exception e){
            return ResultInfo.errorMessage(e.getMessage());
        }
    }

    /**
     * 构建操作记录dto
     * @param index
     * @param session
     * @return
     */
    private OperationLogDTO buildOperationLogDTO(Integer index, HttpSession session){
        OperationLogDTO operationLogDTO = new OperationLogDTO();
        operationLogDTO.setCreateId((long)session.getAttribute("adminId"));
        operationLogDTO.setCreateName(session.getAttribute("adminName").toString());
        operationLogDTO.setCreateTime(new Date());
        operationLogDTO.setFunctionType(FunctionTypeEnum.MANUFACTOR_INFO.getIndex());
        operationLogDTO.setOperType(FunctionTypeEnum.getNameByIndex(index));
        return operationLogDTO;
    }

    /**
     * 删除厂家信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteManufactor",method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo deleteManufactor(Long id){
        if(id == null){
            return ResultInfo.errorMessage("参数错误");
        }
        manufactorService.deleteManufactor(id);
        return ResultInfo.errorMessage("删除成功");
    }
}



















