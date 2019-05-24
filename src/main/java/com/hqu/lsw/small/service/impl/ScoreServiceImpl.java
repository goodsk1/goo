package com.hqu.lsw.small.service.impl;

import com.hqu.lsw.pojo.vo.RandomScoreVO;
import com.hqu.lsw.small.service.ScoreService;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @Description: Service:  有关积分的service
 * @Author: shengwei.liu@luckincoffee.com
 * @Date:2019/4/19 18:12
 */
@Service
public class ScoreServiceImpl implements ScoreService {

    /*
     * redis操作资源
     * */
    @Resource(name="redisTemplate")
    private RedisTemplate redisTemplate;

    /**
     * 获取随机积分范围
     *
     * @return RandomScoreVO 随机积分范围
     */
    @Override
    public RandomScoreVO getScore(){
        RandomScoreVO randomScoreVO =new RandomScoreVO();
        if(redisTemplate.opsForValue().get("maxscore")==null){
            redisTemplate.opsForValue().set("maxscore",5+"");
        }
        if(redisTemplate.opsForValue().get("minscore")==null){
            redisTemplate.opsForValue().set("minscore",0+"");
        }
        randomScoreVO.setMaxScore(Integer.parseInt(redisTemplate.opsForValue().get("maxscore").toString()));
        randomScoreVO.setMinScore(Integer.parseInt(redisTemplate.opsForValue().get("minscore").toString()));

        return randomScoreVO;
    }

    /**
     * 设置购买随机获得的积分范围
     *
     * @param randomScoreVO 积分范围
     */
    @Override
    public void setScore(RandomScoreVO randomScoreVO){
        redisTemplate.opsForValue().set("maxscore",randomScoreVO.getMaxScore()+"");
        redisTemplate.opsForValue().set("minscore",randomScoreVO.getMinScore()+"");
    }

    /**
     * 根据购买商品数量随机获得积分
     *
     * @param productNum
     * @return receiveScore 收到积分
     */
    @Override
    public Integer receiveScore(Integer productNum){
        int max=Integer.parseInt(redisTemplate.opsForValue().get("maxscore").toString());
        int min=Integer.parseInt(redisTemplate.opsForValue().get("minscore").toString());
        Integer receiveScore=0;
        for (int i = 0; i < productNum; i++) {
            receiveScore+=(int) Math.round(Math.random()*(max-min)+min);
        }
        return receiveScore;
    }
}
