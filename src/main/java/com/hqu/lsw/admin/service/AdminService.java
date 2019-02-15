package com.hqu.lsw.admin.service;

import com.hqu.lsw.pojo.AdminDO;

import java.util.Map;

/**
 * @Description 管理员Service接口
 * @Author shengwei.liu@ luckincoffee.com
 * @Date 2019/1/22
 */
public interface AdminService {

    /**
     * 检查用户名和密码
     * @param map
     * @return
     */
    AdminDO checkLogin(Map<String,Object> map);

    /**
     * 获取管理员信息
     * @param adminId
     * @return
     */
    AdminDO getAdmininfo(Long adminId);
}
