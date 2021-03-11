package com.dao;

import com.entity.Tool;

import java.util.List;

/**
 * 作者：林星源
 * 日期: 2020/12/9 11:13
 * 描述:电影
 */
public interface ToolDao {
    //添加电影信息
    int insertTool(Tool tool);

    //修改电影信息
    int updateTool(Tool tool);

    //修改某个字段的电影信息
    int updateToolColumnValue(Integer toolId, String columnName, String columnValue);

    //删除电影信息
    int deleteTool(Integer toolId);

    //按名字查询电影
    Tool queryToolByName(String toolName);

    //按类别查询电影
    Tool queryToolByType(String toolType);

    //按导演查询电影
    Tool queryToolByDirector(String director);

    //按主演查询电影
    Tool queryToolByProtagonist(String protagonist);

    //按上映年份查询电影
    Tool queryToolByShowTime(String showTime);

    //按id查询电影
    Tool queryToolById(Integer id);

    //按浏览次数查询电影
    List<Tool> queryToolByHits();

    List<Tool> queryToolByVoteNum();

    Integer queryPageTotalCounts();

    List<Tool> queryToolByPage(Integer pageNo, Integer pageSize);

    List<Tool> queryAllTool();

    /**
     * 按条件查询
     *
     * @param toolName
     * @param type
     * @param protagonist
     * @param showTime
     * @return
     */
    List<Tool> queryAllTool(String toolName, String type, String protagonist, String showTime);

    int addToolHits(Integer toolId);

    Integer addToolVote(Integer toolId);

    List<Tool> searchTool(String searchMessage);


}
