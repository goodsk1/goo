package com.hqu.lsw.small.service.impl;

import com.hqu.lsw.admin.dao.SnackinfoMapper;
import com.hqu.lsw.pojo.PageHelp;
import com.hqu.lsw.pojo.entity.DoSnack;
import com.hqu.lsw.small.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author 刘圣伟 shengwei.liu@luckincoffee.com
 * @Date 2019/4/1 10:01
 */
@Service
public class ShopServiceImpl implements ShopService {

    /**
     * 零食信息接口
     */
    @Autowired
    SnackinfoMapper snackinfoMapper;

    @Override
    public PageHelp<DoSnack> getOrderDetail(Map<Object, Object> map) {
        PageHelp<DoSnack> pageUtil = new PageHelp<DoSnack>();
        List<DoSnack> orderDetailList = snackinfoMapper.selectOrderDetail(map);
        pageUtil.setList(orderDetailList);
        pageUtil.setRecord(orderDetailList.size());
        return pageUtil;
    }

}
