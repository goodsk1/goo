package com.hqu.lsw.small.dao;

import com.hqu.lsw.pojo.bo.UserBO;
import com.hqu.lsw.pojo.dto.UserDTO;

import java.util.Map;

/**
 * @Description
 * @Author shengwei.liu@ luckincoffee.com
 * @Date 2019/2/25
 */
public interface UserMapper {

    /**
     * 根据用户名和密码查询用户
     * @param map
     * @return
     */
    UserBO getUser(Map<Object,Object> map);





}
