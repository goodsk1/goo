package com.hqu.lsw.business.dao;


import com.hqu.lsw.pojo.entity.QRCode;

/**
 * @Description
 * @Author 刘圣伟 shengwei.liu@luckincoffee.com
 * @Date 2019/4/1 16:12
 */
public interface IQRCodeMapper {

    QRCode selectByPrimaryKey(String key_id);

    int insert(QRCode qRCode);
}
