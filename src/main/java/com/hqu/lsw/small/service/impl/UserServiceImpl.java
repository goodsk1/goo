package com.hqu.lsw.small.service.impl;

import com.hqu.lsw.pojo.bo.UserBO;
import com.hqu.lsw.small.dao.UserMapper;
import com.hqu.lsw.small.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Description
 * @Author shengwei.liu@ luckincoffee.com
 * @Date 2019/2/25
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * 用户接口
     */
    @Autowired
    private UserMapper userMapper;

    /**
     * 根据用户名和密码查询用户
     * @param map
     * @return
     */
    @Override
    public UserBO getUser(Map<Object, Object> map) {
        return userMapper.getUser(map);
    }


}
