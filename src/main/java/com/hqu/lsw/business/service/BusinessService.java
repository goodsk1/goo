package com.hqu.lsw.business.service;

import com.hqu.lsw.pojo.entity.ManufactorDO;

import java.util.Map;

/**
 * @Description
 * @Author shengwei.liu@luckincoffee.com
 * @Date 2019/3/5
 */
public interface BusinessService {

    /**
     * 检查用户名和密码
     *
     * @param map
     * @return
     */
    ManufactorDO checkLogin(Map<String,Object> map);

}
