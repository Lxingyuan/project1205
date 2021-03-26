package com.entity;

import java.util.Date;

/**
 * 作者：林星源
 * 日期: 2020/12/9 10:39
 * 描述:
 */
public class Comment {
    private Integer commentId;
    private Integer commentTypeId;
    private Integer toolId;
    private String toolName;
    private String commentUser;
    private String headPic;
    private String commentContent;
    private Date createTime;
    private Date updateTime;

    public Comment() {
    }


    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", commentTypeId=" + commentTypeId +
                ", toolId=" + toolId +
                ", toolName='" + toolName + '\'' +
                ", commentUser='" + commentUser + '\'' +
                ", headPic='" + headPic + '\'' +
                ", commentContent='" + commentContent + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public Comment(Integer commentId, Integer commentTypeId, Integer toolId, String toolName, String commentUser, String userHead, String commentContent, Date createTime, Date updateTime) {
        this.commentId = commentId;
        this.commentTypeId = commentTypeId;
        this.toolId = toolId;
        this.toolName = toolName;
        this.commentUser = commentUser;

        this.commentContent = commentContent;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getToolName() {
        return toolName;
    }

    public void setToolName(String toolName) {
        this.toolName = toolName;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getCommentTypeId() {
        return commentTypeId;
    }

    public void setCommentTypeId(Integer commentTypeId) {
        this.commentTypeId = commentTypeId;
    }

    public Integer getToolId() {
        return toolId;
    }

    public void setToolId(Integer toolId) {
        this.toolId = toolId;
    }

    public String getCommentUser() {
        return commentUser;
    }

    public void setCommentUser(String commentUser) {
        this.commentUser = commentUser;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
