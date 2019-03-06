package com.hqu.lsw.business.dao;

import com.hqu.lsw.pojo.entity.ManufactorDO;

import java.util.Map;

/**
 * @Description
 * @Author shengwei.liu@luckincoffee.com
 * @Date 2019/3/5
 */
public interface BusinessMapper {
    /**
     * 根据用户名和密码获取ManufactorDO
     * @param map
     * @return
     */
    ManufactorDO getByNameAndPwd(Map<String,Object> map);

}
