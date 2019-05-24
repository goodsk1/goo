package com.hqu.lsw.small.service.impl;

import com.hqu.lsw.pojo.Address;
import com.hqu.lsw.pojo.User;
import com.hqu.lsw.pojo.bo.UserBO;
import com.hqu.lsw.pojo.dto.UserDTO;
import com.hqu.lsw.small.dao.UserMapper;
import com.hqu.lsw.small.exception.BusinessException;
import com.hqu.lsw.small.service.UserService;
import com.hqu.lsw.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    /**
     * 注册用户
     *
     * @param user 用户信息
     */
    @Override
    public void userRegister(User user){
        UserDTO userDTO = userMapper.getLoginUserByName(user.getLoginName());
        if(userDTO !=null) {
            //throw new BusinessException("dd");
        }
        user.setPassword(MD5.MD5Encode(user.getPassword()));
        userMapper.insertUser(user);
    }

    /**
     * 返回个人用户信息
     * @param user 用户信息
     * @return
     */
    @Override
    public UserDTO getUserInfo(User user) {
        return userMapper.getUserInfo(user.getId());
    }

    /**
     * 返回单用户地址列表信息
     *
     * @param id 主键id
     * @return
     */
    @Override
    public List<Address> getAddress(Integer id){
        return userMapper.getAddressList(id);
    }
}
