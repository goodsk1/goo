package com.hqu.lsw.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 * @Author shengwei.liu@luckincoffee.com
 * @Date 2019/3/4
 */
@Controller
@RequestMapping("/project")
public class ProjectController {

    /**
     * 跳转项目列表
     * @return
     */
    @RequestMapping("/toProjectList")
    public String toProjectList(){
        return "admin/projectList";
    }
}
