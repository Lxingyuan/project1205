package com.service.impl;

import com.dao.CommentDao;
import com.dao.impl.CommentDaoImpl;
import com.entity.Comment;
import com.service.CommentService;
import com.utils.Page;

import java.util.List;

/**
 * 作者：林星源
 * 日期: 2020/12/10 14:42
 * 描述:
 */
public class CommentServiceImpl implements CommentService {
    CommentDao commentDao = new CommentDaoImpl();

    @Override
    public int insertComment(Comment comment) {
        return commentDao.insertComment(comment);
    }

    @Override
    public int updateComment(Comment comment) {
        return commentDao.updateComment(comment);
    }

    @Override
    public int deleteComment(Integer commentId) {
        return commentDao.deleteComment(commentId);
    }

    @Override
    public Page<Comment> queryCommentByPage(int pageNo, int pageSize) {
        Page<Comment> page = new Page<>();
        //设置当前页码
        page.setPageNo(pageNo);
        //设置页面大小
        page.setPageSize(pageSize);
        //求总记录数
        Integer pageTotalCount = commentDao.queryPageTotalCounts();
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
        List<Comment> items = commentDao.queryCommentByPage(begin, pageSize);
        //设置数据
        page.setItems(items);
        return page;
    }
}