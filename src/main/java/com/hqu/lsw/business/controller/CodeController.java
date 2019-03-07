package com.hqu.lsw.business.controller;

import com.hqu.lsw.pojo.JsonResult;
import com.hqu.lsw.util.ZXingCodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author shengwei.liu@luckincoffee.com
 * @Date 2019/3/7
 */
@Controller
public class CodeController {

    /**
     * url链接或者文本生成二维码
     * @param request
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping("urlQRCode")
    @ResponseBody
    public JsonResult UrlQRCode(HttpServletRequest request, ModelMap model,
                                @RequestParam(value="file",required=false) CommonsMultipartFile logoFile,
                                @RequestParam(value="urltxt",required=false) String urltxt) throws IOException {



        StringBuffer url = request.getRequestURL();
        String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append(request.getContextPath()).append("/").toString();


        String path = request.getSession().getServletContext().getRealPath("upload");
        String fileName = new Date().getTime() + "url.png";
        File createFile = new File(path+"/"+fileName);
        //生成二维码
        String imageBase64QRCode = "";
        if(logoFile != null){
            String logoFileName = logoFile.getOriginalFilename();
            File targetFile = new File(path, logoFileName);
            if(!targetFile.exists()){
                targetFile.mkdirs();
            }
            logoFile.transferTo(targetFile);
            imageBase64QRCode = ZXingCodeUtil.getLogoQRCode(urltxt, request, "", targetFile, createFile);
            //删除上传的logo
            targetFile.delete();
        }else{
            imageBase64QRCode = ZXingCodeUtil.getQRCode(urltxt, request, "", createFile);
        }

        //二维码地址
        String qrcode_path = tempContextUrl+"upload/"+fileName;

        JsonResult jsonResult = new JsonResult();
        Map data = new HashMap<String, String>();
        data.put("qrcode_path", qrcode_path);
        data.put("qrcode", imageBase64QRCode);
        jsonResult.setData(data);
        jsonResult.setMeg("生成成功");
        jsonResult.setRes(1);

        return jsonResult;
    }
}
