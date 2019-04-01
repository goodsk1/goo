package com.hqu.lsw.business.controller;

import com.hqu.lsw.business.service.IQRCodeService;
import com.hqu.lsw.pojo.JsonResult;
import com.hqu.lsw.pojo.entity.QRCode;
import com.hqu.lsw.util.UuidUtil;
import com.hqu.lsw.util.ZXingCodeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @Author 刘圣伟 shengwei.liu@luckincoffee.com
 * @Date 2019/4/1 16:09
 */
@Controller
public class UploadController {

    final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IQRCodeService qRCodeService;

    /**
     * APP 合成二维码生成
     *
     * @param request
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping("synthesisQRCode")
    @ResponseBody
    public JsonResult SynthesisQRCode(HttpServletRequest request,
                                      @RequestParam(value = "file", required = false) CommonsMultipartFile logoFile,
                                      @RequestParam(value = "ios_url", required = true) String ios_url,
                                      @RequestParam(value = "android_url", required = true) String android_url,
                                      ModelMap model) throws IOException {

        logger.info("SynthesisQRCode - {}", "开始了");
        logger.info("path - {}", request.getSession().getServletContext().getRealPath("/"));

        StringBuffer url = request.getRequestURL();
        String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append(request.getContextPath()).append("/").toString();
        logger.info("tempContextUrl - {}", tempContextUrl);

        String key_id = UuidUtil.generateShortUuid();
        QRCode qRCode = new QRCode();
        qRCode.setAndroid_url(android_url);
        qRCode.setIos_url(ios_url);
        qRCode.setKey_id(key_id);
        int intInsert = qRCodeService.insert(qRCode);

        String path = request.getSession().getServletContext().getRealPath("upload");
        String fileName = new Date().getTime() + "qrcode.png";
        File createFile = new File(path + "/" + fileName);

        //访问路径 服务器地址+ findAppUrl + key_id
        String urltxt = tempContextUrl + "findAppUrl/" + key_id;
        logger.info("urltxt - {}", urltxt);

        //生成二维码
        String imageBase64QRCode = "";
        if (logoFile != null) {
            String logoFileName = logoFile.getOriginalFilename();
            File targetFile = new File(path, logoFileName);
            if (!targetFile.exists()) {
                targetFile.mkdirs();
            }
            logoFile.transferTo(targetFile);
            imageBase64QRCode = ZXingCodeUtil.getLogoQRCode(urltxt, request, "", targetFile, createFile);
            //删除上传的logo
            targetFile.delete();
        } else {
            imageBase64QRCode = ZXingCodeUtil.getQRCode(urltxt, request, "", createFile);
        }

        //二维码地址
        String qrcode_path = tempContextUrl + "upload/" + fileName;

        JsonResult jsonResult = new JsonResult();
        Map data = new HashMap<String, String>();
        data.put("recreateFlag", "0");
        data.put("qrcode_path", qrcode_path);
        data.put("accessKey", "13598992");
        data.put("shortUrl", urltxt);
        jsonResult.setData(data);
        jsonResult.setMeg("生成成功");
        jsonResult.setRes(1);

        return jsonResult;
    }
}
