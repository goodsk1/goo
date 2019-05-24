package com.hqu.lsw.small.controller;

import com.hqu.lsw.pojo.Result;
import com.hqu.lsw.pojo.vo.RandomScoreVO;
import com.hqu.lsw.small.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description 积分Controller
 * @Author 刘圣伟 shengwei.liu@luckincoffee.com
 * @Date 2019/4/24 19:26
 */
@Controller
@RequestMapping("/score")
public class ScoreController {

    /*
     * 积分有关的Service
     * */
    @Autowired
    private ScoreService scoreService;

    /**
     * 获取购买后随机获得的积分范围
     *
     * @return Result 成功提示和随机积分范围randomScoreVO
     */
    @RequestMapping("/getMinAndMaxScore")
    @ResponseBody
    public Result getMinAndMaxScore(){
        //获取随机积分范围
        RandomScoreVO randomScoreVO =scoreService.getScore();
        return Result.success(200,"获得积分范围成功", randomScoreVO);
    }
}
