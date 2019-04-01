package com.hqu.lsw.admin.dao;

import com.hqu.lsw.pojo.entity.DoAdminOrder;
import com.hqu.lsw.pojo.entity.Order;
import com.hqu.lsw.pojo.entity.OrderDetail;

import java.util.List;
import java.util.Map;

/**
 * @Description 订单 dao层
 * @Author 刘圣伟 shengwei.liu@luckincoffee.com
 * @Date 2019/4/1 09:26
 */
public interface OrderMapper {


    /**
     * 管理员查询订单
     * @param map
     * @return
     */
    List<DoAdminOrder> selectAdminOrderLimit(Map<Object, Object> map);

    /**
     * 管理员查看订单数量
     * @param map
     * @return
     */
    int countAdminOrder(Map<Object, Object> map);

    /**
     * 更新订单
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Order record);

    /**
     * 获取订单中零食的数量
     * @param id
     * @return
     */
    List<OrderDetail> selectPushSnackNum(int id);
}
