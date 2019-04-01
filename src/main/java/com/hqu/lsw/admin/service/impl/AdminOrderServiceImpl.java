package com.hqu.lsw.admin.service.impl;

import com.hqu.lsw.admin.dao.OrderMapper;
import com.hqu.lsw.admin.dao.ReceiptinfoMapper;
import com.hqu.lsw.admin.dao.SnackinfoMapper;
import com.hqu.lsw.admin.service.AdminOrderService;
import com.hqu.lsw.pojo.PageHelp;
import com.hqu.lsw.pojo.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author 刘圣伟 shengwei.liu@luckincoffee.com
 * @Date 2019/4/1 09:23
 */
@Service
public class AdminOrderServiceImpl implements AdminOrderService {

    /**
     * 收货信息管理接口
     */
    @Autowired
    ReceiptinfoMapper receiptinfoMapper;

    /**
     * 订单管理接口
     */
    @Autowired
    OrderMapper adminOrderMapper;

    /**
     * 零食管理接口
     */
    @Autowired
    SnackinfoMapper snackinfoMapper;

    @Override
    public PageHelp<DoAdminOrder> listOrders(Map<Object, Object> map) {
        PageHelp<DoAdminOrder> pageUtil=new PageHelp<DoAdminOrder>();
        List<DoAdminOrder> orderList = adminOrderMapper.selectAdminOrderLimit(map);
        int count = adminOrderMapper.countAdminOrder(map);
        pageUtil.setList(orderList);
        pageUtil.setRecord(count);
        return pageUtil;
    }

    @Override
    public Receiptinfo getOrder(int rId){
        return receiptinfoMapper.selectByPrimaryKey(rId);
    }

    @Override
    public int updateAdminOrder(Receiptinfo receiptinfo) {
        return receiptinfoMapper.updateByPrimaryKeySelective(receiptinfo);
    }

    @Override
    public int modifyOrderinfo(int id,int typeNum, int eId){
        int flag = 100;
        Order order = new Order();
        order.setId(id);
        order.setoType(typeNum);
        List<OrderDetail> sum = getAllSnackNum(id);
        for (OrderDetail orderDetail:sum){
            Snackinfo s = snackinfoMapper.selectByPrimaryKey(orderDetail.getsId());
            if (s.getsNumber()-orderDetail.getoNum()<0){
                return flag;
            }
        }
        for (OrderDetail orderDetail:sum){
            Snackinfo s = snackinfoMapper.selectByPrimaryKey(orderDetail.getsId());
            s.setsNumber(s.getsNumber()-orderDetail.getoNum());
            flag = snackinfoMapper.updateByPrimaryKeySelective(s);
        }
        order.seteId(eId);
        adminOrderMapper.updateByPrimaryKeySelective(order);
        return flag;
    }

    public List<OrderDetail> getAllSnackNum(int id) {
        return adminOrderMapper.selectPushSnackNum(id);
    }
}
