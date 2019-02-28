package com.hqu.lsw.small.service;

import com.hqu.lsw.pojo.bo.UserBO;

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


}
