package com.dao.impl;

import com.dao.BaseDao;
import com.dao.CommentDao;
import com.entity.Comment;

import java.util.List;

/**
 * 作者：林星源
 * 日期: 2020/12/10 14:35
 * 描述:
 */
public class CommentDaoImpl extends BaseDao implements CommentDao {
    @Override
    public int insertComment(Comment comment) {
        String sql = "insert into comment (CommentTypeId,MovieId,CommentUser,CommentContent)values(?,?,?,?,?)";
        return update(sql, comment.getCommentTypeId(), comment.getMovieId(), comment.getCommentUser(), comment.getCommentContent());
    }

    @Override
    public int updateComment(Comment comment) {
        String sql = "update comment set UpdateTime = ?,CommentTypeId = ?,MovieId = ?,CommentUser = ?,CommentContent = ? where CommentId = ?";
        return update(sql, comment.getUpdateTime(), comment.getCommentTypeId(), comment.getMovieId(), comment.getCommentUser(), comment.getCommentContent(), comment.getCommentId());

    }

    @Override
    public int deleteComment(Integer commentId) {
        String sql = "delete from comment where CommentId = ?";
        return update(sql, commentId);
    }

    @Override
    public Integer queryPageTotalCounts() {
        String sql = "select count(1) from comment";
        return Math.toIntExact((Long) queryForSingleValue(sql));
    }

    @Override
    public List<Comment> queryCommentByPage(Integer begin, Integer pageSize) {
        String sql = "select * from user limit ?, ?";
        return queryForList(Comment.class, sql, begin, pageSize);
    }

    public List<Comment> queryAllComment() {
        String sql = "select c.* , m.MovieName from `comment` c,`movie` m WHERE c.MovieId=m.MovieId";
        return queryForList(Comment.class, sql);
    }

}
