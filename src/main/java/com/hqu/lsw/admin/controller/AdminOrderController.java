package com.hqu.lsw.admin.controller;

import com.hqu.lsw.admin.service.AdminOrderService;
import com.hqu.lsw.pojo.DataTables;
import com.hqu.lsw.pojo.Msg;
import com.hqu.lsw.pojo.PageHelp;
import com.hqu.lsw.pojo.entity.DoAdminOrder;
import com.hqu.lsw.pojo.entity.Receiptinfo;
import com.hqu.lsw.small.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description admin订单管理
 * @Author 刘圣伟 shengwei.liu@luckincoffee.com
 * @Date 2019/4/1 09:21
 */
@Controller
@RequestMapping("/admin/order")
public class AdminOrderController {


    /**
     *订单管理service
     */
    @Autowired
    AdminOrderService adminOrderService;

    /**
     *会员service
     */
    @Autowired
    UserService userService;


    /**
     * 跳转订单
     * @return
     */
    @RequestMapping("/toOrderPage")
    public String toOrderPage() {
        return "admin/orderManage";
    }


    /**
     * 返回订单列表
     * @param start
     * @param length
     * @param oId
     * @param oTimeStart
     * @param oTimeEnd
     * @return
     */
    @RequestMapping("/listOrders")
    @ResponseBody
    public DataTables listOrders(Integer start, Integer length,
                                 String oId, String oTimeStart, String oTimeEnd) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("pageStart", start);
        map.put("pageSize", length);
        map.put("oId", oId);
        map.put("oTimeStart", oTimeStart);
        map.put("oTimeEnd", oTimeEnd);
        PageHelp<DoAdminOrder> pageHelp = adminOrderService.listOrders(map);
        DataTables dataTable = new DataTables();
        dataTable.setData(pageHelp.getList());
        dataTable.setRecordsFiltered(pageHelp.getRecord());
        dataTable.setRecordsTotal(pageHelp.getRecord());
        return dataTable;
    }

    /**
     * modal对话框拉取订单信息
     * @param rId
     * @return
     */
    @RequestMapping("/getOrder")
    @ResponseBody
    public Msg getOrder(int rId) {
        Msg m = new Msg();
        Map<String, Object> extend = new HashMap<String, Object>();
        Receiptinfo i = adminOrderService.getOrder(rId);
        extend.put("rId", i.getrId());
        extend.put("oName", i.getoName());
        extend.put("oPhone", i.getoPhone());
        extend.put("oAddress", i.getoAddress());
        m.setExtend(extend);
        return m;

    }

    /**
     * 更改收货信息
     * @param receiptinfo
     * @return
     */
    @RequestMapping("modifyOrder")
    @ResponseBody
    public Msg updateAdminOrder(Receiptinfo receiptinfo) {
        int a = adminOrderService.updateAdminOrder(receiptinfo);
        if (a <= 0) {
            return Msg.fail();
        }
        return Msg.success();

    }

    //确认发货(逻辑还有问题，需要修改)
    @RequestMapping("sentOutGoods")
    @ResponseBody
    public Msg sentOutGoods(HttpServletRequest request, int id, int typeNum) {
        int eId = (int) request.getSession().getAttribute("adminId");
        int a = adminOrderService.modifyOrderinfo(id,typeNum,eId);
        if (a <= 0) {
            return Msg.fail();
        }else if (a ==100){
            Msg msg = new Msg();
            msg.setMsg("成功");
            msg.setCode(400);
            return msg;
        }
        return Msg.success();
    }
}
