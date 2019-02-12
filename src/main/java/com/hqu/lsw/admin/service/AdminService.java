package com.hqu.lsw.admin.service;

import com.hqu.lsw.pojo.AdminDO;

/**
 * @Description
 * @Author shengwei.liu@ luckincoffee.com
 * @Date 2019/1/22
 */
public interface AdminService {

    AdminDO checkLogin(String adminName,String adminPwd);
}
