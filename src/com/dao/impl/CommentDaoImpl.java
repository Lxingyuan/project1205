package com.dao.impl;

import com.dao.BaseDao;
import com.dao.CommentDao;
import com.entity.Comment;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * 作者：林星源
 * 日期: 2020/12/10 14:35
 * 描述:
 */
public class CommentDaoImpl extends BaseDao implements CommentDao {
    @Override
    public int insertComment(Comment comment) {
        String sql = "insert into comment (CommentTypeId,ToolId,CommentUser,CommentContent)values(?,?,?,?,?)";
        return update(sql, comment.getCommentTypeId(), comment.getToolId(), comment.getCommentUser(), comment.getCommentContent());
    }

    @Override
    public int updateComment(Comment comment) {
        String sql = "update comment set UpdateTime = ?,CommentTypeId = ?,ToolId = ?,CommentUser = ?,CommentContent = ? where CommentId = ?";
        return update(sql, comment.getUpdateTime(), comment.getCommentTypeId(), comment.getToolId(), comment.getCommentUser(), comment.getCommentContent(), comment.getCommentId());

    }

    @Override
    public int updateCommentColumnValue(Integer commentId, String columnName, String columnValue) {
        String sql = "update comment set " + columnName + " = '" + columnValue + "' where commentId = " + commentId;
        //System.out.println(sql);
        return update(sql);
    }

    @Override
    public List<Comment> queryCommentByTime() {
        String sql="SELECT * FROM comment ORDER BY CreateTime DESC";
        return  queryForList(Comment.class,sql);
    }

    @Override
    public int deleteComment(Integer commentId) {
        String sql = "delete from comment where CommentId = ?";
        return update(sql, commentId);
    }

    @Override
    public int deleteComment(Integer toolId, String commentUser) {
        String sql = "delete from comment where toolId = ? and commentUser = ?";
        return update(sql, toolId,commentUser);
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
        String sql = "select c.* , m.* from `comment` c,`tool` m WHERE c.ToolId=m.ToolId";
        return queryForList(Comment.class, sql);
    }

    @Override
    public List<Comment> queryAllComment(String toolName, String commentUser, String commentContent) {
        String sql = "SELECT c.* , m.* FROM `comment` c,`tool` m WHERE m.toolName LIKE '%' AND c.commentUser LIKE '%' AND c.commentContent LIKE '%' AND c.ToolId=m.ToolId;";
        if (StringUtils.isNotEmpty(toolName)) {
            String string = "toolName LIKE '%" + toolName + "%'";
            sql = sql.replace("toolName LIKE '%'", string);
        }
        if (StringUtils.isNotEmpty(commentUser)) {
            String string = "commentUser LIKE '%" + commentUser + "%'";
            sql = sql.replace("commentUser LIKE '%'", string);
        }
        if (StringUtils.isNotEmpty(commentContent)) {
            String string = "commentContent LIKE '%" + commentContent + "%'";
            sql = sql.replace("commentContent LIKE '%'", string);
        }
        return queryForList(Comment.class, sql);
    }

    public Integer queryTotalCommentByToolId(Integer toolId) {
        String sql = "select count(1) from comment where toolId ='"+toolId+"'";
        return Math.toIntExact((Long) queryForSingleValue(sql));
    }

    public List<Comment> queryCommentByToolId(Integer toolId) {
        String sql="SELECT * FROM comment c,user u  where c.toolId = '"+toolId+"' and c.commentUser=u.userName ORDER BY c.CreateTime DESC";
        return  queryForList(Comment.class,sql);
    }

    @Override
    public int addToolComment(Comment comment) {
        String sql = "insert into comment (ToolId,CommentUser,CommentContent)values(?,?,?)";
        return update(sql,  comment.getToolId(), comment.getCommentUser(), comment.getCommentContent());
    }
}


