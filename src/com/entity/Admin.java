package com.entity;

import java.util.Date;

/**
 * 作者：林星源
 * 日期: 2020/12/9 15:31
 * 描述:
 */
public class Admin {
    private Integer id;
    private Integer createUserId;
    private Integer updateUserId;
    private Date createTime;
    private Date updateTime;
    private String title;
    private String userName;
    private String password;
    private Date lastTime;
    private Integer logCount;
    private String headPic;

    public Admin() {
    }

    public Admin(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public Admin(Integer id, Integer createUserId, Integer updateUserId, Date createTime, Date updateTime, String title, String userName, String password, Date lastTime, Integer logCount, String headPic) {
        this.id = id;
        this.createUserId = createUserId;
        this.updateUserId = updateUserId;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.title = title;
        this.userName = userName;
        this.password = password;
        this.lastTime = lastTime;
        this.logCount = logCount;
        this.headPic = headPic;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", createUserId=" + createUserId +
                ", updateUserId=" + updateUserId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", title='" + title + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", lastTime=" + lastTime +
                ", logCount=" + logCount +
                ", headPic='" + headPic + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Integer getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        lastTime = lastTime;
    }

    public Integer getLogCount() {
        return logCount;
    }

    public void setLogCount(Integer logCount) {
        this.logCount = logCount;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }
}
