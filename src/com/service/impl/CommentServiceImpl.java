package com.service.impl;

import com.dao.CommentDao;
import com.dao.impl.CommentDaoImpl;
import com.entity.Comment;
import com.service.CommentService;
import com.utils.Page;
import com.utils.Page2;

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
    public List<Comment> queryCommentByTime() {
        return commentDao.queryCommentByTime();
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

    public Page2<Comment> queryCommentByPage2() {
        Page2<Comment> page = new Page2<>();
        page.setCode(0);
        page.setMsg("");
        //求总记录数
        Integer pageTotalCount = commentDao.queryPageTotalCounts();
        page.setCount(pageTotalCount);
        page.setData(commentDao.queryAllComment());
        return page;
    }

    @Override
    public Page2<Comment> queryCommentByPage2(String movieName, String commentUser, String commentContent) {
        Page2<Comment> page = new Page2<>();
        page.setCode(0);
        page.setMsg("");
        System.out.println("2");
        List<Comment> list = commentDao.queryAllComment(movieName, commentUser, commentContent);
        page.setData(list);
        page.setCount(list.size());
        return page;
    }

    @Override
    public int updateCommentColumnValue(Integer commentId, String columnName, String columnValue) {
        return commentDao.updateCommentColumnValue(commentId, columnName, columnValue);
    }

    @Override
    public Integer queryTotalCommentByMovieId(Integer movieId) {
        return commentDao.queryTotalCommentByMovieId(movieId);
    }

    @Override
    public List<Comment> queryCommentByMovieId(Integer movieId) {
        return commentDao.queryCommentByMovieId(movieId);
    }


}
