package com.hqu.lsw.business.service.impl;

import com.hqu.lsw.business.dao.IQRCodeMapper;
import com.hqu.lsw.business.service.IQRCodeService;
import com.hqu.lsw.pojo.entity.QRCode;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description
 * @Author 刘圣伟 shengwei.liu@luckincoffee.com
 * @Date 2019/4/1 16:11
 */
@Service
public class QRCodeServiceImpl implements IQRCodeService {
    @Resource
    private IQRCodeMapper iqrCodeMapper;

    public QRCode getQRCodeById(String key_id) {
        // TODO Auto-generated method stub
        QRCode qRCode = iqrCodeMapper.selectByPrimaryKey(key_id);
        return qRCode;
    }

    public int insert(QRCode qRCode) {
        // TODO Auto-generated method stub
        int key_id = iqrCodeMapper.insert(qRCode);
        return key_id;
    }

}
