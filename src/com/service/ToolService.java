package com.service;

import com.entity.Tool;
import com.utils.Page;
import com.utils.Page2;

import java.util.List;

/**
 * 作者：林星源
 * 日期: 2020/12/10 14:41
 * 描述:
 */
public interface ToolService {
    //添加电影信息
    int insertTool(Tool tool);

    //修改电影信息
    int updateTool(Tool tool);

    //删除电影信息
    int deleteTool(Integer toolId);

    //按名字查询电影
    Tool queryToolByName(String toolName);

    //查询所有分类
    List<Tool> queryAllType();

    //按类别查询电影
    Page<Tool> queryToolByType(String toolType, int pageNo, int pageSize);

    //按导演查询电影
    Tool queryToolByCharacteristic(String characteristic);

    //按id查询电影
    Tool queryToolById(Integer id);

    //按主演查询电影
    List<Tool> queryToolByUploader(String uploader);

    //查询所有用户上传资源
    Page<Tool> queryToolByUploaders(int pageNo, int pageSize);

    //按上映年份查询电影
    Tool queryToolByShowTime(String showTime);

    //按浏览次数查询电影
    List<Tool> queryToolByHits();

    List<Tool> queryToolByVoteNum();

    //电影分页
    Page<Tool> queryToolByPage(int pageNo, int pageSize);

    //电影分页2
    Page2<Tool> queryToolByPage2();

    /**
     * 按条件查询
     *
     * @param toolName
     * @param type
     * @param uploader
     * @param uploadTime
     * @return
     */
    Page2<Tool> queryToolByPage2(String toolName, String type, String uploader, String uploadTime);

    //修改某个字段的电影信息
    int updateToolColumnValue(Integer toolId, String columnName, String columnValue);

    int addToolHits(Integer toolId);

    Integer addToolVote(Integer toolId);
    List<Tool> searchTool(String searchMessage);
}
