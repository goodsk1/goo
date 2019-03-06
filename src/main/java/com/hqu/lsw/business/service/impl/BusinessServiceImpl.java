package com.hqu.lsw.business.service.impl;

import com.hqu.lsw.business.dao.BusinessMapper;
import com.hqu.lsw.business.service.BusinessService;
import com.hqu.lsw.pojo.entity.ManufactorDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Description 商家版后台service接口
 * @Author shengwei.liu@luckincoffee.com
 * @Date 2019/3/5
 */
@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private BusinessMapper businessMapper;
    /**
     * 检查用户名和密码
     *
     * @param map
     * @return
     */
    @Override
    public ManufactorDO checkLogin(Map<String,Object> map){
        return businessMapper.getByNameAndPwd(map);
    }
}
