package com.hqu.lsw.small.dao;

import com.hqu.lsw.pojo.Address;
import com.hqu.lsw.pojo.User;
import com.hqu.lsw.pojo.bo.UserBO;
import com.hqu.lsw.pojo.dto.UserDTO;
import com.hqu.lsw.pojo.entity.UserDO;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author shengwei.liu@ luckincoffee.com
 * @Date 2019/2/25
 */
public interface UserMapper {

    /**
     * 根据用户名和密码查询用户
     *
     * @param map
     * @return
     */
    UserBO getUser(Map<Object,Object> map);

    /**
     * 分页查询用户
     *
     * @param map
     * @return
     */
    List<UserDO> selectUserinfoLimit(Map<Object, Object> map);

    /**
     * 获取用户数量
     *
     * @param map
     * @return
     */
    int countUser(Map<Object, Object> map);


    /**
     *删除用户
     *
     * @param userId
     * @return
     */
    int deleteByPrimaryKey(Integer userId);

    /**
     * 查询用户
     *
     * @param id
     * @return
     */
    UserDO selectByPrimaryKey(Integer id);

    /**
     * 更新用户
     *
     * @param user
     * @return
     */
    int updateByPrimaryKeySelective(UserDO user);

    /**
     * 根据用户注册帐号获取用户的登录信息
     *
     * @param: account 用户帐号
     * @return: UserDTO 用户的登录信息
     * */
    UserDTO getLoginUserByName(String account);

    /**
     * 新增用户
     *
     * @param record
     * @return
     */
    int insertUser(User record);

    /**
     * 根据用户id 获取用户信息
     *
     * @param id
     * @return
     */
    UserDTO getUserInfo(Integer id);

    List<Address> getAddressList(Integer id);
}
