package com.hqu.lsw.small.controller;

import com.hqu.lsw.pojo.Result;
import com.hqu.lsw.pojo.dto.CategoryDTO;
import com.hqu.lsw.small.service.SnackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description 零食相关Controller
 * @Author 刘圣伟 shengwei.liu@luckincoffee.com
 * @Date 2019/4/24 20:54
 */
public class SnackController {

    /*
     * 零食相关Service
     * */
    @Autowired
    private SnackService snackService;

    /**
     * 获取小程序端零食列表
     *
     * @return: 零食列表
     * */
    @RequestMapping("/getProductList")
    @ResponseBody
    public Result getSnackList(){
        List<CategoryDTO> productList = snackService.getSnackList();
        return Result.success(200,"获取商品列表成功",productList);
    }
}
