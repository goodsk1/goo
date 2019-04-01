package com.hqu.lsw.business.service;


import com.hqu.lsw.pojo.entity.QRCode;

/**
 * @Description
 * @Author 刘圣伟 shengwei.liu@luckincoffee.com
 * @Date 2019/4/1 16:11
 */
public interface IQRCodeService {

    QRCode getQRCodeById(String key_id);

    int insert(QRCode qRCode);
}
