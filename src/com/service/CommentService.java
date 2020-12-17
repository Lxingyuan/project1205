package com.service;

import com.entity.Comment;
import com.utils.Page;

import java.util.List;

/**
 * 作者：林星源
 * 日期: 2020/12/10 14:41
 * 描述:
 */
public interface CommentService {
    //添加评论信息
    int insertComment(Comment comment);

    //修改评论信息
    int updateComment(Comment comment);

    //删除评论信息
    int deleteComment(Integer commentId);
    //评论页面
    Page<Comment> queryCommentByPage(int pageNo, int pageSize);
}
