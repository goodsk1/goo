package com.hqu.lsw.small.service;

import com.hqu.lsw.pojo.PageHelp;
import com.hqu.lsw.pojo.entity.DoSnack;

import java.util.Map;

/**
 * @Description
 * @Author 刘圣伟 shengwei.liu@luckincoffee.com
 * @Date 2019/4/1 10:00
 */
public interface ShopService {

    /**
     * 获取订单详情
     * @param map
     * @return
     */
    PageHelp<DoSnack> getOrderDetail(Map<Object, Object> map);
}
