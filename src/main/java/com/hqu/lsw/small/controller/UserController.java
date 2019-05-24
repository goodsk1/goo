package com.hqu.lsw.small.controller;

import com.hqu.lsw.pojo.Address;
import com.hqu.lsw.pojo.Result;
import com.hqu.lsw.pojo.User;
import com.hqu.lsw.pojo.bo.UserBO;
import com.hqu.lsw.pojo.dto.UserDTO;
import com.hqu.lsw.pojo.vo.UserLoginVO;
import com.hqu.lsw.small.common.constants;
import com.hqu.lsw.small.service.UserService;
import com.hqu.lsw.util.Token;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 用户Controller（小程序端）
 * @Author shengwei.liu@luckincoffee.com
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
        String token = Token.genetateToken();
        if(userBO != null){
            return Result.success(200,"登陆成功",token);
        }
        return Result.fail(300,"登陆错误");

    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Result updateData(String name,boolean sex,String phone){
        return null;
    }

    /**
     * 用户注册
     *
     * @param userLoginVO 注册需要的帐号密码
     * @return Result 成功提示
     */
    @RequestMapping("/register")
    @ResponseBody
    public Result Register(@Validated UserLoginVO userLoginVO) {
        User user = new User();
        BeanUtils.copyProperties(userLoginVO, user);
        userService.userRegister(user);
        return Result.success(200, "注册成功");
    }

    /**
     * 根据用户id获取用户的信息
     *
     * @param id 用户id
     * @return Result 结果
     */
    @RequestMapping("/getUserInfo")
    @ResponseBody
    public Result getUserInfo(Integer id) {
        if (id == null) {
            return Result.fail(constants.FAIL,"失败");
        }
        User user = new User();
        user.setId(id);
        UserDTO userDTO = userService.getUserInfo(user);
        return Result.success(constants.SUCCESS, "成功", userDTO);
    }


    @RequestMapping("/getAddress")
    @ResponseBody
    public Result getAddress(Integer id) {
        if (id == null) {
            return Result.fail(constants.FAIL,"失败");
        }
        List<Address> addressList = userService.getAddress(id);

        return Result.success(200, "获取用户地址列表成功", addressList);
    }
}