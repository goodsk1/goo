package com.hqu.lsw.admin.controller;

import com.hqu.lsw.admin.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description
 * @Author shengwei.liu@ luckincoffee.com
 * @Date 2019/1/22
 */
@Controller
@RequestMapping("/admin")
public class AdminController {


    private static final String LOGIN_INDEX="admin/login";

    private Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    public ModelAndView login(String adminName,String adminPwd){
        ModelAndView mav = new ModelAndView(LOGIN_INDEX);
        logger.info("hhhh");
        return mav;
    }

}
