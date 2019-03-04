package com.hqu.lsw.admin.service.impl;

import com.hqu.lsw.admin.service.AdminUserService;
import com.hqu.lsw.pojo.PageHelp;
import com.hqu.lsw.pojo.entity.UserDO;
import com.hqu.lsw.small.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author shengwei.liu@luckincoffee.com
 * @Date 2019/3/4
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {
    /**
     * 会员接口
     */
    @Autowired
    UserMapper userMapper;

    @Override
    public PageHelp<UserDO> listUsers(Map<Object, Object> map, UserDO user) {
        map.put("userinfo", user);
        PageHelp<UserDO> pageUtil = new PageHelp<UserDO>();
        List<UserDO> listUser = userMapper.selectUserinfoLimit(map);
        int count = userMapper.countUser(map);
        pageUtil.setList(listUser);
        pageUtil.setRecord(count);
        return pageUtil;
    }
}
