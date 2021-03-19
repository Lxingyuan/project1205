package com.dao;

import com.entity.ToolScore;

import java.util.List;

/**
 * 作者：林星源
 * 日期: 2021/3/18 16:30
 * 描述:
 */
public interface ToolScoreDao {
    //根据用户查询工具评分列表
    List<ToolScore> queryToolScore(String userName);

    //插入评分
    int insertScore(ToolScore toolScore);

    //重复判定
    ToolScore repeatJudge(String userName,String toolId);

}
