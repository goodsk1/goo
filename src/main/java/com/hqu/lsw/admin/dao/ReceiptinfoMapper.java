package com.hqu.lsw.admin.dao;

import com.hqu.lsw.pojo.entity.Receiptinfo;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author 刘圣伟 shengwei.liu@luckincoffee.com
 * @Date 2019/4/1 10:18
 */
public interface ReceiptinfoMapper {


    /**
     * 查询收货信息
     * @param rId
     * @return
     */
    Receiptinfo selectByPrimaryKey(Integer rId);

    /**
     * 更新收货信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Receiptinfo record);
}
