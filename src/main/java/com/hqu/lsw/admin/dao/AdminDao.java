package com.hqu.lsw.admin.dao;

import com.hqu.lsw.pojo.AdminDO;
import org.springframework.stereotype.Repository;

/**
 * @Description
 * @Author shengwei.liu@ luckincoffee.com
 * @Date 2019/1/22
 */
public interface AdminDao {
    AdminDO getByNameAndPwd(String adminName,String adminPwd);

}
