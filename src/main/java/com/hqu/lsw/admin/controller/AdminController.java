package com.hqu.lsw.admin.controller;

import com.hqu.lsw.admin.service.AdminService;
import com.hqu.lsw.pojo.AdminDO;
import com.hqu.lsw.pojo.Msg;
import com.hqu.lsw.util.MD5;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 管理员controller
 * @Author shengwei.liu@ luckincoffee.com
 * @Date 2019/1/22
 */
@Controller
@RequestMapping("/admin")
public class AdminController {


    private static final String LOGIN_INDEX="admin/login";
    private static final String TO_HOME="admin/home";

    private Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    public ModelAndView toLogin(){
        ModelAndView mav = new ModelAndView(LOGIN_INDEX);
        return mav;
    }

    /**
     * 检查登陆
     * @param model
     * @param adminName
     * @param adminPwd
     * @param session
     * @return
     */
    @RequestMapping("/checkLogin")
    public String checkLogin(Model model, String adminName, String adminPwd, HttpSession session){
        Map<String,Object> map = new HashMap<>();
        map.put("adminName",adminName);
        map.put("adminPwd",adminPwd);
        AdminDO admin = adminService.checkLogin(map);
        if(admin != null){
            session.setAttribute("Admin",admin);
            session.setAttribute("adminId",admin.getId());
            return "redirect:toHome";
        }
        model.addAttribute("msg","用户名或密码错误");
        return LOGIN_INDEX;
    }

    /**
     * 跳转后台主页面
     * @return
     */
    @RequestMapping("/toHome")
    public String toHome(){
        return TO_HOME;
    }

    /**
     * 退出登陆
     * @param request
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("Admin");
        return LOGIN_INDEX;
    }

    /**
     * 跳转管理员信息页面
     * @return
     */
    @RequestMapping("/toAdmininfo")
    public String toAdmininfo(){
        return "admin/adminInfo";
    }

    /**
     * 加载管理员信息
     * @param request
     * @return
     */
    @RequestMapping("/showAdmininfo")
    @ResponseBody
    public Msg showAdmininfo(HttpServletRequest request){
        Long  adminId =(Long) request.getSession().getAttribute("adminId");
        Msg m = new Msg();
        AdminDO adminDO = adminService.getAdmininfo(adminId);
        MD5 md5 = new MD5();
        String password = md5.MD5Encode(adminDO.getAdminPwd());
        adminDO.setAdminPwd(password);
        m.setTag(adminDO);
        m.setMsg("成功");
        return m;
    }
}
