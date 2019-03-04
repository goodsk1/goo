package com.hqu.lsw.small.dao;

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
     * @param map
     * @return
     */
    UserBO getUser(Map<Object,Object> map);

    /**
     * 分页查询用户
     * @param map
     * @return
     */
    List<UserDO> selectUserinfoLimit(Map<Object, Object> map);

    /**
     * 获取用户数量
     * @param map
     * @return
     */
    int countUser(Map<Object, Object> map);


    /**
     *删除用户
     * @param userId
     * @return
     */
    int deleteByPrimaryKey(Integer userId);

    /**
     * 查询用户
     * @param id
     * @return
     */
    UserDO selectByPrimaryKey(Integer id);

    /**
     * 更新用户
     * @param user
     * @return
     */
    int updateByPrimaryKeySelective(UserDO user);

}
