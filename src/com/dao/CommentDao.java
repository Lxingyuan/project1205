package com.dao;

import com.entity.Comment;
import com.entity.Notice;

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

    int updateCommentColumnValue(Integer commentId,String columnName,String columnValue);


    List<Comment> queryCommentByTime();
    //删除评论信息
    int deleteComment(Integer commentId);
    //删除评论信息
    int deleteComment(Integer toolId,String commentUser);
    Integer queryPageTotalCounts();

    List<Comment> queryCommentByPage(Integer pageNo, Integer pageSize);

    List<Comment> queryAllComment();

    List<Comment> queryAllComment(String toolName,String commentUser,String commentContent);

    Integer queryTotalCommentByToolId(Integer toolId);

    List<Comment> queryCommentByToolId(Integer toolId);

    int addToolComment(Comment comment);
}
