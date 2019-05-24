package com.hqu.lsw.pojo.vo;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * 从前端获取的的随机积分范围信息vo
 */
public class RandomScoreVO {

    /*
     * 随机积分最大范围
     * */
    @NotNull(message = "积分最大范围不能为空")
    @Max(value = 0,message = "积分最大范围必须大于0")
    private Integer maxScore;

    /*
     * 随机积分最小范围
     * */
    @NotNull(message = "积分最小范围不能为空")
    @Max(value = 0,message = "积分最小范围必须大于0")
    private Integer minScore;

    public Integer getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(Integer maxScore) {
        this.maxScore = maxScore;
    }

    public Integer getMinScore() {
        return minScore;
    }

    public void setMinScore(Integer minScore) {
        this.minScore = minScore;
    }
}
