package com.hqu.lsw.small.controller;

import com.hqu.lsw.pojo.Result;
import com.hqu.lsw.pojo.bo.UserBO;
import com.hqu.lsw.small.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 用户Controller（小程序端）
 * @Author shengwei.liu@ luckincoffee.com
 * @Date 2019/2/25
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Result login(@RequestParam("phone") String loginName, @RequestParam("password") String loginPwd){
        Map<Object,Object> map = new HashMap<Object,Object>();
        map.put("loginName",loginName);
        map.put("loginPwd",loginPwd);
        UserBO userBO = userService.getUser(map);
        if(userBO != null){
            return Result.success(200,"登陆成功","haha");
        }
        return Result.fail(300,"登陆错误");

    }

}