package com.hqu.lsw.admin.service.impl;

import com.hqu.lsw.admin.dao.AdminDao;
import com.hqu.lsw.admin.service.AdminService;
import com.hqu.lsw.pojo.AdminDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author shengwei.liu@ luckincoffee.com
 * @Date 2019/1/22
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Override
    public AdminDO checkLogin(String adminName, String adminPwd) {
        return null;
    }
}
