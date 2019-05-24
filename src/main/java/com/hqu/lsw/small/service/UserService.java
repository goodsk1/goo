package com.hqu.lsw.small.service;

import com.hqu.lsw.pojo.Address;
import com.hqu.lsw.pojo.User;
import com.hqu.lsw.pojo.bo.UserBO;
import com.hqu.lsw.pojo.dto.UserDTO;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author shengwei.liu@ luckincoffee.com
 * @Date 2019/2/25
 */
public interface UserService {
    /**
     * 根据用户名和密码查询用户
     * @param map
     * @return
     */
    UserBO getUser(Map<Object,Object> map);

    /**
     * 注册用户
     *
     * @param user 用户信息
     */
    void userRegister(User user);

    /**
     * 返回个人用户信息
     * @param user 用户信息
     * @return
     */
    UserDTO getUserInfo(User user);

    /**
     * 获取用户地址信息
     *
     * @param id 主键id
     * @return
     */
    List<Address> getAddress(Integer id);
}
