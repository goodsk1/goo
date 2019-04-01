package com.hqu.lsw.business.service;


import com.hqu.lsw.pojo.entity.QRCode;

/**
 * @Description 二维码生成service接口
 * @Author 刘圣伟 shengwei.liu@luckincoffee.com
 * @Date 2019/4/1 16:11
 */
public interface IQRCodeService {

    /**
     * 通过id获取二维码
     * @param key_id
     * @return
     */
    QRCode getQRCodeById(String key_id);

    /**
     * 插入一个二维码
     * @param qRCode
     * @return
     */
    int insert(QRCode qRCode);
}
