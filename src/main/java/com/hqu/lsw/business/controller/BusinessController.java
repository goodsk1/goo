package com.hqu.lsw.business.controller;


import com.hqu.lsw.business.service.BusinessService;
import com.hqu.lsw.pojo.entity.ManufactorDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 商家controller
 * @Author shengwei.liu@luckincoffee.com
 * @Date 2019/3/5
 */
@Controller
@RequestMapping("/business")
public class BusinessController {

    private Logger logger = LoggerFactory.getLogger(BusinessController.class);

    private static final String LOGIN_INDEX = "business/businessLogin";

    private static final String TO_HOME="business/businessMain";

    @Autowired
    private BusinessService businessService;

    @RequestMapping("/login")
    public ModelAndView toLogin() {
        ModelAndView mav = new ModelAndView(LOGIN_INDEX);
        return mav;
    }

    /**
     * 检查登陆
     * @param model
     * @param busName
     * @param busPwd
     * @param session
     * @return
     */
    @RequestMapping("/checkLogin")
    public String checkLogin(Model model, String busName, String busPwd, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        map.put("loginName", busName);
        map.put("loginPwd", busPwd);
        ManufactorDO manufactorDO = businessService.checkLogin(map);
        if (manufactorDO != null) {
            session.setAttribute("manufactorDO", manufactorDO);
            session.setAttribute("manufactorId", manufactorDO.getId());
            session.setAttribute("manufactorName", manufactorDO.getLoginName());
            return "redirect:toHome";
        }
        model.addAttribute("msg", "用户名或密码错误");
        return LOGIN_INDEX;
    }

    /**
     * 跳转后台主页面
     *
     * @return
     */
    @RequestMapping("/toHome")
    public String toHome(){
        return TO_HOME;
    }

    /**
     * 退出登陆
     *
     * @param request
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("manufactorDO");
        return LOGIN_INDEX;
    }
}
























