package com.hqu.lsw.admin.service;

import com.hqu.lsw.pojo.PageHelp;
import com.hqu.lsw.pojo.entity.UserDO;

import java.util.Map;

/**
 * @Description
 * @Author shengwei.liu@luckincoffee.com
 * @Date 2019/3/4
 */
public interface AdminUserService {

    /**
     * 查询会员信息列表
     * @param map   查询会员信息的条件（使用map封装）
     * @param user
     * @return
     */
    PageHelp<UserDO> listUsers(Map<Object, Object> map, UserDO user);

    /**
     * 删除会员信息
     * @param uId
     * @return
     */
    int deleteUser(int uId);

    /**
     * 获取会员详细信息
     * @param uId
     * @return
     */
    UserDO getUserinfo(int uId);

    /**
     * 更新会员信息
     * @param user
     * @return
     */
    int modifyUserinfo(UserDO user);
}
