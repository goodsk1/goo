package com.hqu.lsw.admin.service;

import com.hqu.lsw.pojo.PageHelp;
import com.hqu.lsw.pojo.entity.DoAdminOrder;
import com.hqu.lsw.pojo.entity.Receiptinfo;

import java.util.Map;

/**
 * @Description
 * @Author 刘圣伟 shengwei.liu@luckincoffee.com
 * @Date 2019/4/1 09:22
 */
public interface AdminOrderService {


    /**
     *获取订单列表
     * @param map   查询收货信息的条件（使用map封装）
     * @return  订单列表
     */
    PageHelp<DoAdminOrder> listOrders(Map<Object, Object> map);

    /**
     * 获取订单信息
     * @param rId   收货信息的主键id
     * @return  会员收货信息
     */
    Receiptinfo getOrder(int rId);

    /**
     *更新订单信息
     * @param receiptinfo
     * @return
     */
    int updateAdminOrder(Receiptinfo receiptinfo);

    /**
     * 确认发货
     * @param id
     * @param eId
     * @return
     */
    int modifyOrderinfo(int id,int typeNum, int eId);
}
