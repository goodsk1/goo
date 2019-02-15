package com.hqu.lsw.admin.dao;

import com.hqu.lsw.pojo.AdminDO;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @Description 管理员Dao层接口
 * @Author shengwei.liu@ luckincoffee.com
 * @Date 2019/1/22
 */
public interface AdminMapper {
    /**
     * 根据用户名和密码获取AdminDO
     * @param map
     * @return
     */
    AdminDO getByNameAndPwd(Map<String,Object> map);

    /**
     * 根据主键查找管理员
     * @param adminId
     * @return
     */
    AdminDO getByPrimaryKey(Long adminId);
}
