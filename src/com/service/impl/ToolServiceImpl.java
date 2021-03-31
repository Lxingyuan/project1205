package com.service.impl;

import com.dao.FavouriteToolDao;
import com.dao.ToolDao;
import com.dao.impl.FavouriteToolImpl;
import com.dao.impl.ToolDaoImpl;
import com.entity.Tool;
import com.service.ToolService;
import com.utils.Page;
import com.utils.Page2;

import java.util.List;

/**
 * 作者：林星源
 * 日期: 2020/12/10 14:42
 * 描述:
 */
public class ToolServiceImpl implements ToolService {
    ToolDao toolDao = new ToolDaoImpl();
    FavouriteToolDao favouriteToolDao =new FavouriteToolImpl();
    @Override
    public int insertTool(Tool tool) {
        return toolDao.insertTool(tool);
    }

    @Override
    public int updateTool(Tool tool) {
        return toolDao.updateTool(tool);
    }

    @Override
    public int deleteTool(Integer toolId) {
        return toolDao.deleteTool(toolId);
    }

    @Override
    public Tool queryToolByName(String toolName) {
        return toolDao.queryToolByName(toolName);
    }

    @Override
    public List<Tool> queryAllType() {
        return toolDao.queryAllType();
    }

    @Override
    public Page<Tool> queryToolByType(String toolType, int pageNo, int pageSize) {
        Page<Tool> page = new Page<>();
        //设置当前页码
        page.setPageNo(pageNo);
        //设置页面大小
        page.setPageSize(pageSize);
        //求总记录数
        Integer pageTotalCount = toolDao.queryPageTotalCountsByType(toolType);
        //设置总记录数
        page.setPageTotalCount(pageTotalCount);
        //求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal += 1;
        }
        //设置总页码
        page.setPageTotal(pageTotal);
        //求开始页码
        int begin = (page.getPageNo() - 1) * pageSize;
        //获取开始页码的分页数据
        List<Tool> items = toolDao.queryToolByType(toolType,begin, pageSize);
        //设置数据
        page.setItems(items);
        return page;
    }

    @Override
    public Tool queryToolByCharacteristic(String characteristic) {
        return toolDao.queryToolByCharacteristic(characteristic);
    }

    @Override
    public Tool queryToolById(Integer id) {
        return toolDao.queryToolById(id);
    }

    @Override
    public List<Tool> queryToolByUploader(String uploader) {
        return toolDao.queryToolByUploader(uploader);
    }

    @Override
    public Page<Tool> queryToolByUploaders(int pageNo, int pageSize) {
        Page<Tool> page = new Page<>();
        //设置当前页码
        page.setPageNo(pageNo);
        //设置页面大小
        page.setPageSize(pageSize);
        //求总记录数
        Integer pageTotalCount = toolDao.queryPageTotalCountsByUploaders();
        //设置总记录数
        page.setPageTotalCount(pageTotalCount);
        //求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal += 1;
        }
        //设置总页码
        page.setPageTotal(pageTotal);
        //求开始页码
        int begin = (page.getPageNo() - 1) * pageSize;
        //获取开始页码的分页数据
        List<Tool> items = toolDao.queryToolByUploaders(begin, pageSize);
        //设置数据
        page.setItems(items);
        return page;
    }

    @Override
    public Tool queryToolByShowTime(String showTime) {
        return toolDao.queryToolByUploadTime(showTime);
    }

    @Override
    public List<Tool> queryToolByHits() {
        return toolDao.queryToolByHits();
    }

    @Override
    public List<Tool> queryToolByVoteNum() {
        return toolDao.queryToolByVoteNum();
    }

    @Override
    public Page<Tool> queryToolByPage(int pageNo, int pageSize) {
        Page<Tool> page = new Page<>();
        //设置当前页码
        page.setPageNo(pageNo);
        //设置页面大小
        page.setPageSize(pageSize);
        //求总记录数
        Integer pageTotalCount = toolDao.queryPageTotalCounts();
        //设置总记录数
        page.setPageTotalCount(pageTotalCount);
        //求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal += 1;
        }
        //设置总页码
        page.setPageTotal(pageTotal);
        //求开始页码
        int begin = (page.getPageNo() - 1) * pageSize;
        //获取开始页码的分页数据
        List<Tool> items = toolDao.queryToolByPage(begin, pageSize);
        //设置数据
        page.setItems(items);
        return page;
    }

    @Override
    public Page2<Tool> queryToolByPage2() {
        Page2<Tool> page = new Page2<>();
        page.setCode(0);
        page.setMsg("");
        List<Tool> list = toolDao.queryAllTool();
        page.setData(list);
        page.setCount(list.size());
        return page;
    }

    @Override
    public Page2<Tool> queryToolByPage2(String toolName, String type, String uploader, String uploadTime) {
        Page2<Tool> page = new Page2<>();
        page.setCode(0);
        page.setMsg("");
        List<Tool> list = toolDao.queryAllTool(toolName, type, uploader, uploadTime);
        page.setData(list);
        page.setCount(list.size());
        return page;
    }

    @Override
    public int updateToolColumnValue(Integer toolId, String columnName, String columnValue) {
        return toolDao.updateToolColumnValue(toolId, columnName, columnValue);
    }

    @Override
    public int addToolHits(Integer toolId) {
        return toolDao.addToolHits(toolId);
    }

    @Override
    public Integer addToolVote(Integer toolId) {
        return toolDao.addToolVote(toolId);
    }

    @Override
    public List<Tool> searchTool(String searchMessage) {
        return toolDao.searchTool(searchMessage);
    }
}
