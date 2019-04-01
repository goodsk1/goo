package com.hqu.lsw.business.service.impl;

import com.hqu.lsw.business.dao.IQRCodeMapper;
import com.hqu.lsw.business.service.IQRCodeService;
import com.hqu.lsw.pojo.entity.QRCode;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description 二维码生成service实现类
 * @Author 刘圣伟 shengwei.liu@luckincoffee.com
 * @Date 2019/4/1 16:11
 */
@Service
public class QRCodeServiceImpl implements IQRCodeService {
    /**
     * 二维码操作接口
     */
    @Resource
    private IQRCodeMapper iqrCodeMapper;

    /**
     * 通过id获取二维码
     * @param key_id
     * @return
     */
    public QRCode getQRCodeById(String key_id) {
        // TODO Auto-generated method stub
        QRCode qRCode = iqrCodeMapper.selectByPrimaryKey(key_id);
        return qRCode;
    }

    /**
     * 插入一个二维码
     * @param qRCode
     * @return
     */
    public int insert(QRCode qRCode) {
        // TODO Auto-generated method stub
        int key_id = iqrCodeMapper.insert(qRCode);
        return key_id;
    }

}
