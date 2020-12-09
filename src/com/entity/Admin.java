package com.entity;

import java.sql.Timestamp;

/**
 * @author Win10
 */
public class Admin {
    private Integer id;
    private Integer createUserId;
    private Integer updateUserId;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String title;
    private String userName;
    private String password;
    private Timestamp LastTime;
    private Integer logCount;
    private String headPic;

    public Admin() {
    }

    public Admin(Integer createUserId, Integer updateUserId, Timestamp createTime, Timestamp updateTime, String title, String userName, String password, Timestamp lastTime, Integer logCount, String headPic) {
        this.createUserId = createUserId;
        this.updateUserId = updateUserId;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.title = title;
        this.userName = userName;
        this.password = password;
        LastTime = lastTime;
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
                ", LastTime=" + LastTime +
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

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
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

    public Timestamp getLastTime() {
        return LastTime;
    }

    public void setLastTime(Timestamp lastTime) {
        LastTime = lastTime;
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
