package com.hqu.lsw.admin.controller;

import com.hqu.lsw.admin.service.AdminUserService;
import com.hqu.lsw.pojo.DataTables;
import com.hqu.lsw.pojo.Msg;
import com.hqu.lsw.pojo.PageHelp;
import com.hqu.lsw.pojo.entity.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author shengwei.liu@luckincoffee.com
 * @Date 2019/3/4
 */
@RequestMapping("/auser/")
@Controller
public class AdminUserController {



    /**
     * 会员管理service
     */
    @Autowired
    AdminUserService adminUserService;

    /**
     * 跳转会员列表
     * @return
     */
    @RequestMapping("toUserList")
    public String toUserList() {
        return "admin/userInfo";
    }


    /**
     *加载会员信息
     * @param start
     * @param length
     * @param user
     * @return
     */
    @RequestMapping("listUsers")
    @ResponseBody
    public DataTables listUsers(Integer start, Integer length, UserDO user) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("pageStart", start);
        map.put("pageSize", length);
        PageHelp<UserDO> pageHelp = adminUserService.listUsers(map, user);
        DataTables datatable = new DataTables();
        datatable.setData(pageHelp.getList());
        datatable.setRecordsFiltered(pageHelp.getRecord());
        datatable.setRecordsTotal(pageHelp.getRecord());
        return datatable;
    }

    /**
     * 删除会员
     * @param uId
     * @return
     */
    @RequestMapping("deleteUser")
    @ResponseBody
    public Msg deleteUser(int uId) {
        int a = adminUserService.deleteUser(uId);
        if (a <= 0) {
            return Msg.success().fail();
        }
        return Msg.success();
    }

    /**
     * 展示更新会员模态框
     * @param uId
     * @return
     */
    @RequestMapping("showUpdateUserinfoModal")
    @ResponseBody
    public Msg getUserinfo(int uId) {
        Msg msg = new Msg();
        UserDO u = adminUserService.getUserinfo(uId);
        if (u != null) {
            msg.setTag(u);
            msg.setMsg("成功");
        }
        return msg;
    }

    /**
     * 更新会员信息
     * @param user
     * @return
     */
    @RequestMapping("modifyUserinfo")
    @ResponseBody
    public Msg modifyUserinfo(UserDO user){
        int a = adminUserService.modifyUserinfo(user);
        if (a <= 0){
            return Msg.fail();
        }
        return Msg.success();
    }
}
