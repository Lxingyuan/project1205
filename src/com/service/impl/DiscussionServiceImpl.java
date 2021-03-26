package com.service.impl;

import com.dao.DiscussionDao;
import com.dao.impl.DiscussionDaoImpl;
import com.entity.Discussion;
import com.service.DiscussionService;
import com.utils.Page;
import com.utils.Page2;

import java.util.List;

/**
 * 作者：林星源
 * 日期: 2021/3/24 12:55
 * 描述:
 */
public class DiscussionServiceImpl implements DiscussionService {
    DiscussionDao discussionDao = new DiscussionDaoImpl();

    @Override
    public int insertDiscussion(Discussion discussion) {
        return discussionDao.insertDiscussion(discussion);
    }

    @Override
    public int updateDiscussion(Discussion discussion) {
        return discussionDao.updateDiscussion(discussion);
    }

    public List<Discussion> queryDiscussion(){
        return discussionDao.queryDiscussion();
    }

    @Override
    public int deleteDiscussion(Integer discussionId) {
        return discussionDao.deleteDiscussion(discussionId);
    }

    public int deleteDiscussion(String discussionUser,String discussionContent){
        return discussionDao.deleteDiscussion(discussionUser,discussionContent);
    }

    @Override
    public Discussion queryDiscussionById(Integer discussionId) {
        return discussionDao.queryDiscussionById(discussionId);
    }

    @Override
    public Discussion queryDiscussionByHead(String discussionHead) {
        return discussionDao.queryDiscussionByHead(discussionHead);
    }

    @Override
    public Discussion queryDiscussionByUser(String discussionUser) {
        return discussionDao.queryDiscussionByUser(discussionUser);
    }

    @Override
    public Discussion queryDiscussionByTime() {
        return discussionDao.queryDiscussionByTime();
    }

    @Override
    public Page<Discussion> queryDiscussionByPage(int pageNo, int pageSize) {
        Page<Discussion> page = new Page<>();
        //设置当前页码
        page.setPageNo(pageNo);
        //设置页面大小
        page.setPageSize(pageSize);
        //求总记录数
        Integer pageTotalCount = discussionDao.queryPageTotalCounts();
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
        List<Discussion> items = discussionDao.queryDiscussionByPage(begin, pageSize);
        //设置数据
        page.setItems(items);
        return page;
    }

    public Page2<Discussion> queryDiscussionByPage2() {
        Page2<Discussion> page = new Page2<>();
        page.setCode(0);
        page.setMsg("");
        //求总记录数
        Integer pageTotalCount = discussionDao.queryPageTotalCounts();
        page.setCount(pageTotalCount);
        page.setData(discussionDao.queryAllDiscussion());
        return page;
    }

    @Override
    public Page2<Discussion> queryDiscussionByPage2(String discussionHead,String discussionContent,String discussionUser) {
        Page2<Discussion> page = new Page2<>();
        page.setCode(0);
        page.setMsg("");
        System.out.println("2");
        List<Discussion> list = discussionDao.queryAllDiscussion(discussionHead, discussionContent, discussionUser);
        page.setData(list);
        page.setCount(list.size());
        return page;
    }

    @Override
    public int updateDiscussionColumnValue(Integer discussionId, String columnName, String columnValue) {
        return discussionDao.updateDiscussionColumnValue(discussionId, columnName, columnValue);
    }

}
