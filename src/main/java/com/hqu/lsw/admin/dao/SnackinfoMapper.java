package com.hqu.lsw.admin.dao;

import com.hqu.lsw.pojo.entity.Snackinfo;

import java.util.List;
import java.util.Map;

/**
 * @Description 零食信息 dao层
 * @Author 刘圣伟 shengwei.liu@luckincoffee.com
 * @Date 2019/3/26 15:04
 */
public interface SnackinfoMapper {

    /**
     * 分页查询零食信息
     * @param map
     * @return
     */
    List<Snackinfo> selectSnackinfoByPage(Map<Object, Object> map);

    /**
     * 查询零食数量
     * @param map
     * @return
     */
    int selectSnackinfoNumber(Map<Object, Object> map);

    /**
     *删除零食信息
     * @param sId
     * @return
     */
    int deleteByPrimaryKey(Integer sId);
}
