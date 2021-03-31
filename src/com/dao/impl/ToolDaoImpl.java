package com.dao.impl;

import com.dao.BaseDao;
import com.dao.ToolDao;
import com.entity.Tool;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * 作者：林星源
 * 日期: 2020/12/10 11:34
 * 描述:
 */
public class ToolDaoImpl extends BaseDao implements ToolDao {
    @Override
    public int insertTool(Tool tool) {
        String sql = "insert into tool (ToolName,Type,Characteristic,Uploader,UploadTime,PicAddress,DownloadAddr,TeachingAddress,Content,Hits,state)values(?,?,?,?,?,?,?,?,?,?,?)";
        return update(sql, tool.getToolName(), tool.getType(), tool.getCharacteristic(), tool.getUploader(), tool.getUploadTime(), tool.getPicAddress(), tool.getDownloadAddr(), tool.getTeachingAddress(), tool.getContent(), tool.getHits(), tool.getState());
    }

    @Override
    public int updateTool(Tool tool) {
        String sql = "update tool set UpdateTime=?,ToolName=?,Type=?,Characteristic=?,Uploader=?,UploadTime=?,PicAddress=?,DownloadAddr=?,TeachingAddress=?,Content=?,Hits=? where ToolId = ?";
        return update(sql, tool.getUpdateTime(), tool.getToolName(), tool.getType(), tool.getCharacteristic(), tool.getUploader(), tool.getUploadTime(), tool.getPicAddress(), tool.getDownloadAddr(), tool.getTeachingAddress(), tool.getContent(), tool.getHits(),  tool.getToolId());
    }

    @Override
    public int updateToolColumnValue(Integer toolId, String columnName, String columnValue) {
        //System.out.println("dao中:"+toolId+" "+columnName+" "+columnValue);
        String sql = "update tool set " + columnName + " = '" + columnValue + "' where toolId = " + toolId;
        //System.out.println("sql:"+sql);
        return update(sql);
    }

    @Override
    public int deleteTool(Integer toolId) {
        String sql = "delete from tool where ToolId = ?";
        return update(sql, toolId);
    }

    @Override
    public Tool queryToolByName(String toolName) {
        String sql = "select * from tool where ToolName=?";
        return queryForOne(Tool.class, sql, toolName);
    }

    @Override
    public Tool queryToolByCharacteristic(String characteristic) {
        String sql = "select * from tool where Characteristic=?";
        return queryForOne(Tool.class, sql, characteristic);
    }

    @Override
    public List<Tool> queryToolByUploader(String uploader) {
        String sql = "select * from tool where uploader=?";
        return queryForList(Tool.class, sql, uploader);
    }

    @Override
    public List<Tool> queryToolByUploaders(Integer begin, Integer pageSize) {
        String sql = "select * from tool where uploader!=\'admin\' limit ?, ?";
        return queryForList(Tool.class, sql, begin, pageSize);
    }

    @Override
    public Tool queryToolByUploadTime(String uploadTime) {
        String sql = "select * from tool where UploadTime=?";
        return queryForOne(Tool.class, sql, uploadTime);
    }

    @Override
    public Tool queryToolById(Integer id) {
        String sql = "select * from tool where toolId=?";
        return queryForOne(Tool.class, sql, id);
    }

    @Override
    public List<Tool> queryToolByHits() {
        String sql = "select * from tool ORDER BY Hits DESC";
        return queryForList(Tool.class, sql);
    }

    @Override
    public List<Tool> queryToolByVoteNum() {
        String sql = "select * from tool ORDER BY voteNum DESC";
        return queryForList(Tool.class, sql);
    }

    //查询当前表的总记录条数
    @Override
    public Integer queryPageTotalCounts() {
        String sql = "select count(1) from tool where state=1";
        return Math.toIntExact((Long) queryForSingleValue(sql));
    }

    @Override
    public Integer queryPageTotalCountsByType(String toolTpye) {
        String sql = "select count(1) from tool where type=?";
        return Math.toIntExact((Long) queryForSingleValue(sql,toolTpye));
    }

    @Override
    public Integer queryPageTotalCountsByUploader(String uploader) {
        String sql = "select count(1) from tool where uploader=?";
        return Math.toIntExact((Long) queryForSingleValue(sql,uploader));
    }

    @Override
    public Integer queryPageTotalCountsByUploaders() {
        String sql = "select count(1) from tool where uploader!=1";
        return Math.toIntExact((Long) queryForSingleValue(sql));
    }

    @Override
    public List<Tool> queryToolByPage(Integer begin, Integer pageSize) {
        String sql = "select * from tool where state=1 limit ?, ?";
        return queryForList(Tool.class, sql, begin, pageSize);
    }

    @Override
    public List<Tool> queryToolByType(String toolType, Integer begin, Integer pageSize) {
        String sql = "select * from tool where state=1 and type=? limit ?, ?";
        return queryForList(Tool.class, sql, toolType, begin, pageSize);
    }

    @Override
    public List<Tool> queryAllTool() {
        String sql = "select * from tool";
        return queryForList(Tool.class, sql);
    }

    @Override
    public List<Tool> queryAllTool(String toolName, String type, String protagonist, String uploadTime) {
        String sql = "SELECT * FROM tool WHERE toolName LIKE '%' AND type LIKE '%' AND uploader LIKE '%' AND uploadTime LIKE '%'";
        if(StringUtils.isNotEmpty(toolName)){
            String string="toolName LIKE '%"+toolName+"%'";
            sql=sql.replace("toolName LIKE '%'",string);
        }
        if(StringUtils.isNotEmpty(type)){
            String string="type LIKE '%"+type+"%'";
            sql=sql.replace("type LIKE '%'",string);
        }
        if(StringUtils.isNotEmpty(protagonist)){
            String string="uploader LIKE '%"+protagonist+"%'";
            sql=sql.replace("uploader LIKE '%'",string);
        }
        if(StringUtils.isNotEmpty(uploadTime)){
            String string="uploadTime LIKE '"+uploadTime+"'";
            sql=sql.replace("uploadTime LIKE '%'",string);
        }
        return queryForList(Tool.class, sql);
    }

    @Override
    public int addToolHits(Integer toolId) {
        String sql="UPDATE tool SET hits=hits+1 where toolId ='"+toolId+"'";
        return update(sql);
    }

    @Override
    public List<Tool> searchTool(String searchMessage) {
        String sql = "SELECT * FROM tool WHERE toolName LIKE '%"+searchMessage+"%' or type LIKE '%"+searchMessage+"%' or uploader LIKE '%"+searchMessage+"%' or uploadTime LIKE '%"+searchMessage+"%'or characteristic LIKE '%"+searchMessage+"%'";
        return queryForList(Tool.class, sql);
    }

    @Override
    public Integer addToolVote(Integer toolId) {
        String sql="UPDATE tool SET voteNum=voteNum+1 where toolId = ? ";
        return update(sql,toolId);
    }

    @Override
    public List<Tool> queryAllType() {
        String sql="SELECT DISTINCT type FROM tool where state=1";
        return queryForList(Tool.class, sql);
    }
}
