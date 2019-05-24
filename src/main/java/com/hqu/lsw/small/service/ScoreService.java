package com.hqu.lsw.small.service;

import com.hqu.lsw.pojo.vo.RandomScoreVO;

/**
 * @Description: 积分service
 * @Author: shengwei.liu@luckincoffee.com
 * @Date:2019/11/19 18:12
 */
public interface ScoreService {

    /**
     * 获取随机积分范围
     *
     * @return RandomScoreVO 随机积分范围
     */
    RandomScoreVO getScore();

    /**
     * 设置购买随机获得的积分范围
     *
     * @param randomScoreVO 积分范围
     */
    void setScore(RandomScoreVO randomScoreVO);

    /**
     * 根据购买商品数量随机获得积分
     *
     * @param productNum
     * @return receiveScore 收到积分
     */
    Integer receiveScore(Integer productNum);
}
