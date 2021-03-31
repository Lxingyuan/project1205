package com.service;

import com.entity.ToolScore;

import java.util.List;

/**
 * 作者：林星源
 * 日期: 2021/3/18 16:56
 * 描述:
 */
public interface ToolScoreService {
    //根据用户查询工具评分列表
    List<ToolScore> queryToolScore(String userName);

    //插入评分
    Integer insertScore(ToolScore toolScore);

    //重复性判断
    ToolScore repeatJudge(String userName, String toolId);

    //获取工具平均分数
    Object toolScore(String toolId);
}
