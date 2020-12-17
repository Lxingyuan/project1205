package com.entity;

import java.util.Date;

/**
 * 作者：林星源
 * 日期: 2020/12/14 19:43
 * 描述:
 */
public class Notice {
    private Integer NoticeId;
    private String NoticeHead;
    private String NoticeContent;
    private String NoticeUser;
    private Date createTime;

    @Override
    public String toString() {
        return "Notice{" +
                "NoticeId=" + NoticeId +
                ", NoticeHead='" + NoticeHead + '\'' +
                ", NoticeContent='" + NoticeContent + '\'' +
                ", NoticeUser='" + NoticeUser + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public Notice() {
    }

    public Notice(Integer noticeId, String noticeHead, String noticeContent, String noticeUser, Date createTime) {
        NoticeId = noticeId;
        NoticeHead = noticeHead;
        NoticeContent = noticeContent;
        NoticeUser = noticeUser;
        this.createTime = createTime;
    }

    public Integer getNoticeId() {
        return NoticeId;
    }

    public void setNoticeId(Integer noticeId) {
        NoticeId = noticeId;
    }

    public String getNoticeHead() {
        return NoticeHead;
    }

    public void setNoticeHead(String noticeHead) {
        NoticeHead = noticeHead;
    }

    public String getNoticeContent() {
        return NoticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        NoticeContent = noticeContent;
    }

    public String getNoticeUser() {
        return NoticeUser;
    }

    public void setNoticeUser(String noticeUser) {
        NoticeUser = noticeUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
