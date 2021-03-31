package com.service.impl;

import com.dao.ToolScoreDao;
import com.dao.impl.ToolScoreDaoImpl;
import com.entity.ToolScore;
import com.service.ToolScoreService;

import java.util.List;

/**
 * 作者：林星源
 * 日期: 2021/3/18 16:57
 * 描述:
 */
public class ToolScoreServiceImpl implements ToolScoreService {
    ToolScoreDao toolScoreDao=new ToolScoreDaoImpl();

    @Override
    public List<ToolScore> queryToolScore(String userName) {
        return toolScoreDao.queryToolScore(userName);
    }

    @Override
    public Integer insertScore(ToolScore toolScore) {
        return toolScoreDao.insertScore(toolScore);
    }

    @Override
    public ToolScore repeatJudge(String userName, String toolId) {
        return toolScoreDao.repeatJudge(userName,toolId);
    }

    public Object toolScore(String toolId){
        return toolScoreDao.toolScore(toolId);
    }
}
