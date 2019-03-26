package com.hqu.lsw.admin.controller;

import com.hqu.lsw.admin.service.AdminSnackinfoService;
import com.hqu.lsw.pojo.DataTables;
import com.hqu.lsw.pojo.PageHelp;
import com.hqu.lsw.pojo.entity.Snackinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 零食管理
 * @Author 刘圣伟 shengwei.liu@luckincoffee.com
 * @Date 2019/3/26 14:46
 */
@Controller
@RequestMapping("/snackinfo")
public class AdminSnackinfoController {


    /**
     *零食管理service
     */
    @Autowired
    AdminSnackinfoService adminSnackinfoService;

    /**
     * 跳转零食管理页面
     * @return
     */
    @RequestMapping("toSnackManage")
    public String toSnackManage() {
        return "admin/snackManage";
    }

    /**
     * 显示零食列表
     * @param start
     * @param length
     * @param sName
     * @param sType
     * @param startDate
     * @param endDate
     * @return
     */
    @RequestMapping("listSnackinfos")
    @ResponseBody
    public DataTables listSnackinfos(int start, int length,
                                     String sName, String sType, String startDate, String endDate) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("pageStart", start);
        map.put("pageSize", length);
        map.put("sType", sType);
        map.put("sName", sName);
        map.put("startDate", startDate);
        map.put("endDate", endDate);
        PageHelp<Snackinfo> pageHelp = adminSnackinfoService.listSnackinfoByPage(map);
        DataTables datatable = new DataTables();
        datatable.setData(pageHelp.getList());
        datatable.setRecordsFiltered(pageHelp.getRecord());
        datatable.setRecordsTotal(pageHelp.getRecord());
        return datatable;
    }
}
