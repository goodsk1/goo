package com.hqu.lsw.admin.service.impl;

import com.hqu.lsw.admin.dao.AdminMapper;
import com.hqu.lsw.admin.service.AdminService;
import com.hqu.lsw.pojo.AdminDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Description 管理员Service实现类
 * @Author shengwei.liu@luckincoffee.com
 * @Date 2019/1/22
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminDao;

    /**
     * 检查用户名和密码
     *
     * @param map
     * @return
     */
    @Override
    public AdminDO checkLogin(Map<String,Object> map) {
        return adminDao.getByNameAndPwd(map);
    }

    /**
     * 获取管理员信息
     *
     * @param adminId
     * @return
     */
    @Override
    public AdminDO getAdmininfo(Long adminId){
        return adminDao.getByPrimaryKey(adminId);
    }
}
