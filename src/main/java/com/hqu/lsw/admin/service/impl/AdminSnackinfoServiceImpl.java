package com.hqu.lsw.admin.service.impl;

import com.hqu.lsw.admin.dao.SnackinfoMapper;
import com.hqu.lsw.admin.service.AdminSnackinfoService;
import com.hqu.lsw.pojo.PageHelp;
import com.hqu.lsw.pojo.entity.Snackinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Description 零食信息管理service
 * @Author 刘圣伟 shengwei.liu@luckincoffee.com
 * @Date 2019/3/26 15:03
 */
@Service
public class AdminSnackinfoServiceImpl implements AdminSnackinfoService {
    /**
     * 零食信息接口
     */
    @Autowired
    SnackinfoMapper snackinfoMapper;

    @Override
    public PageHelp<Snackinfo> listSnackinfoByPage(Map<Object, Object> map) {
        PageHelp<Snackinfo> pageUtil=new PageHelp<Snackinfo>();
        List<Snackinfo> snackList = snackinfoMapper.selectSnackinfoByPage(map);
        int count = snackinfoMapper.selectSnackinfoNumber(map);
        pageUtil.setList(snackList);
        pageUtil.setRecord(count);
        return pageUtil;
    }

    @Override
    public int removeSnackinfo(int sId) {
        return snackinfoMapper.deleteByPrimaryKey(sId);
    }
}
