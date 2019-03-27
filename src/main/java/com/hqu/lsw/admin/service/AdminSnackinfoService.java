package com.hqu.lsw.admin.service;

import com.hqu.lsw.pojo.PageHelp;
import com.hqu.lsw.pojo.entity.Snackinfo;

import java.util.Map;

/**
 * @Description 零食信息管理service
 * @Author 刘圣伟 shengwei.liu@luckincoffee.com
 * @Date 2019/3/26 15:02
 */
public interface AdminSnackinfoService {

    /**
     * 零食信息列表
     * @param map   查询零食信息的条件（使用map封装）
     * @return
     */
    PageHelp<Snackinfo> listSnackinfoByPage(Map<Object, Object> map);

    /**
     * 删除零食信息
     * @param sId   零食表主键id
     * @return
     */
    int removeSnackinfo(int sId);

    /**
     * 修改零食信息
     * @param snackinfo
     * @return
     */
    int modifySnackinfo(Snackinfo snackinfo);

    /**
     * 查询零食的详细信息
     * @param sId
     * @return
     */
    Snackinfo getSnackinfoById(int sId);

    /**
     * 添加零食信息
     * @param snackinfo
     * @return
     */
    int addSnackinfo(Snackinfo snackinfo);
}
