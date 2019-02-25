package com.hqu.lsw.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description 合作厂家相关操作Controller
 * @Author shengwei.liu@ luckincoffee.com
 * @Date 2019/2/15
 */
@Controller
@RequestMapping("/admin")
public class ManufactorController {


    /**
     * 跳转合作厂家列表
     * @return
     */
    @RequestMapping("/toManufactorList")
    public String toManufactorList(){
        return "admin/manufactorList";
    }



}

