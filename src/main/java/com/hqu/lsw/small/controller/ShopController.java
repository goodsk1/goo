package com.hqu.lsw.small.controller;

import com.hqu.lsw.pojo.DataTables;
import com.hqu.lsw.pojo.PageHelp;
import com.hqu.lsw.pojo.entity.DoSnack;
import com.hqu.lsw.small.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author 刘圣伟 shengwei.liu@luckincoffee.com
 * @Date 2019/4/1 09:59
 */
@Controller
@RequestMapping("/shop/")
public class ShopController {


    /**
     * 商店service
     */
    @Autowired
    ShopService shopService;

    /**
     * 查询订单
     *
     * @param oId
     * @param start
     * @param length
     * @return
     */
    @RequestMapping("selectOrderSnack")
    @ResponseBody
    public DataTables selectOrderSnack(String oId, int start, int length) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("oId", oId);
        map.put("pageStart", start);
        map.put("pageSize", length);
        PageHelp<DoSnack> pageHelp = shopService.getOrderDetail(map);
        DataTables datatable = new DataTables();
        datatable.setData(pageHelp.getList());
        datatable.setRecordsFiltered(pageHelp.getRecord());
        datatable.setRecordsTotal(pageHelp.getRecord());
        return datatable;
    }
}
