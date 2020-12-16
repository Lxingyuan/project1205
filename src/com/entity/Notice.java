package com.entity;

import java.util.Date;

/**
 * 作者：林星源
 * 日期: 2020/12/14 19:43
 * 描述:
 */
public class Notice {
    private Integer noticeId;
    private String noticeHead;
    private String noticeContent;
    private String noticeUser;
    private Date createTime;
    private Date updateTime;


    @Override
    public String toString() {
        return "Notice{" +
                "noticeId=" + noticeId +
                ", noticeHead='" + noticeHead + '\'' +
                ", noticeContent='" + noticeContent + '\'' +
                ", noticeUser='" + noticeUser + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public Notice() {
    }

    public Notice(Integer noticeId, String noticeHead, String noticeContent, String noticeUser, Date createTime, Date updateTime) {
        this.noticeId = noticeId;
        this.noticeHead = noticeHead;
        this.noticeContent = noticeContent;
        this.noticeUser = noticeUser;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeHead() {
        return noticeHead;
    }

    public void setNoticeHead(String noticeHead) {
        this.noticeHead = noticeHead;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public String getNoticeUser() {
        return noticeUser;
    }

    public void setNoticeUser(String noticeUser) {
        this.noticeUser = noticeUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
