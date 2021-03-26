package com.entity;

import java.util.Date;

/**
 * 作者：林星源
 * 日期: 2021/3/22 22:44
 * 描述:留言板
 */
public class Discussion {

    private Integer discussionId;
    private String headPic;
    private String discussionHead;
    private String discussionUser;
    private String discussionContent;
    private Date createTime;
    private Date updateTime;

    @Override
    public String toString() {
        return "Discussion{" +
                "discussionId=" + discussionId +
                ", headPic='" + headPic + '\'' +
                ", discussionHead='" + discussionHead + '\'' +
                ", discussionUser='" + discussionUser + '\'' +
                ", discussionContent='" + discussionContent + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public Discussion() {
    }

    public Discussion(Integer discussionId, String headPic, String discussionHead, String discussionUser, String discussionContent, Date createTime, Date updateTime) {
        this.discussionId = discussionId;
        this.headPic = headPic;
        this.discussionHead = discussionHead;
        this.discussionUser = discussionUser;
        this.discussionContent = discussionContent;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getDiscussionHead() {
        return discussionHead;
    }

    public void setDiscussionHead(String discussionHead) {
        this.discussionHead = discussionHead;
    }

    public Integer getDiscussionId() {
        return discussionId;
    }

    public void setDiscussionId(Integer discussionId) {
        this.discussionId = discussionId;
    }

    public String getDiscussionUser() {
        return discussionUser;
    }

    public void setDiscussionUser(String discussionUser) {
        this.discussionUser = discussionUser;
    }

    public String getDiscussionContent() {
        return discussionContent;
    }

    public void setDiscussionContent(String discussionContent) {
        this.discussionContent = discussionContent;
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
