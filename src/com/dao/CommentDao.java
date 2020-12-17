package com.dao;

import com.entity.Comment;

import java.util.List;

/**
 * 作者：林星源
 * 日期: 2020/12/9 11:14
 * 描述:
 */
public interface CommentDao {

    //添加评论信息
    int insertComment(Comment comment);

    //修改评论信息
    int updateComment(Comment comment);

    //删除评论信息
    int deleteComment(Integer commentId);

    Integer queryPageTotalCounts();

    List<Comment> queryCommentByPage(Integer pageNo, Integer pageSize);
}
