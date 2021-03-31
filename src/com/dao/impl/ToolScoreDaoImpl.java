package com.dao.impl;

import com.dao.BaseDao;
import com.dao.ToolScoreDao;
import com.entity.ToolScore;

import java.util.List;

/**
 * 作者：林星源
 * 日期: 2021/3/18 16:34
 * 描述:
 */
public class ToolScoreDaoImpl extends BaseDao implements ToolScoreDao {


    @Override
    public List<ToolScore> queryToolScore(String userName) {
        String sql = "select * from toolScore where userName = ?";
        return queryForList(ToolScore.class, sql, userName);
    }

    @Override
    public int insertScore(ToolScore toolScore) {
        String sql = "insert into toolScore (toolId,score,userName)values(?,?,?)";
        return update(sql, toolScore.getToolId(), toolScore.getScore(), toolScore.getUserName());
    }

    @Override
    public ToolScore repeatJudge(String userName, String toolId) {
        String sql = "select * from toolScore where userName = ? and toolId = ?";
        return queryForOne(ToolScore.class, sql, userName, toolId);
    }

    @Override
    public Object toolScore(String toolId) {
        String sql = "SELECT (SELECT SUM(score) as sumscore from (SELECT * from toolscore where toolid=?) ts)/(select count(1) from toolscore where toolId=?) score;";
        return queryForSingleValue(sql, toolId,toolId);
    }
}
