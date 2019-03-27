package com.hqu.lsw.admin.controller;

import com.hqu.lsw.admin.service.AdminSnackinfoService;
import com.hqu.lsw.pojo.DataTables;
import com.hqu.lsw.pojo.Msg;
import com.hqu.lsw.pojo.PageHelp;
import com.hqu.lsw.pojo.entity.Snackinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    /**
     * 删除零食
     * @param sId
     * @return
     */
    @RequestMapping("deleteSnackinfo")
    @ResponseBody
    public Msg deleteSnackinfo(int sId) {
        int a = adminSnackinfoService.removeSnackinfo(sId);
        if (a <= 0) {
            return Msg.fail();
        }
        return Msg.success();
    }

    /**
     * 更新零食信息
     * @param request
     * @param file
     * @param fileName
     * @param snackinfo
     * @return
     * @throws Exception
     */
    @RequestMapping("modifySnackinfo")
    @ResponseBody
    public Msg modifySnackinfo(HttpServletRequest request, MultipartFile file, String fileName, Snackinfo snackinfo) throws Exception {
        if (file != null){
            snackinfo.setsPictureurl(fileName);
            adminSnackinfoService.modifySnackinfo(snackinfo);

            String path = request.getSession().getServletContext().getRealPath("/static/fore/image/");
            String f = fileName;
            File filePath = new File(path,f);
            filePath.delete();
            if (!filePath.getParentFile().exists()){
                filePath.getParentFile().mkdirs();
            }
            file.transferTo(new File(path+File.separator+fileName));
            return Msg.success();
        }
        else {
            adminSnackinfoService.modifySnackinfo(snackinfo);
            return Msg.success();
        }
    }


    /**
     * modal拉取需要修改的零食信息
     */
    @RequestMapping("getSnackinfoById")
    @ResponseBody
    public Msg getSnackinfoById(int sId) {
        Msg msg = new Msg();
        Snackinfo snackinfo = adminSnackinfoService.getSnackinfoById(sId);
        if (snackinfo != null) {
            msg.setTag(snackinfo);
            msg.setMsg("成功");
            return msg;
        }
        return Msg.fail();
    }

    /**
     * 添加零食种类
     * @param request
     * @param file
     * @param fileName
     * @param snackinfo
     * @return
     * @throws Exception
     */
    @RequestMapping("addSnackinfo")
    @ResponseBody
    public Msg upload(HttpServletRequest request,
                      @RequestParam("file") MultipartFile file, String fileName, Snackinfo snackinfo) throws Exception {
        Date day = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        String sBatch = df.format(day).toString() + String.valueOf((int) (Math.random() * 9000 + 1000));
        snackinfo.setsCreatedate(df.format(day));
        snackinfo.setState(1);
        snackinfo.setsPictureurl(fileName);
        snackinfo.setsBatch(sBatch);
        adminSnackinfoService.addSnackinfo(snackinfo);
        //如果文件不为空，写入上传路径
        if (!file.isEmpty()) {
            //上传文件路径
            String path = request.getSession().getServletContext().getRealPath("/static/fore/image/");
            //上传文件名
            String filename = fileName;
            File filepath = new File(path, filename);
            //判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件当中
            file.transferTo(new File(path + File.separator + filename));
            return Msg.success();
        } else {
            return Msg.fail();
        }

    }
}
