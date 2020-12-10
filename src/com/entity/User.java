package com.entity;

import java.util.Date;

/**
 * 作者：林星源
 * 日期: 2020/12/9 10:39
 * 描述:
 */
public class User {
    private Integer userId;
    private Date createTime;
    private Date updateTime;
    private String userName;
    private String userPassword;
    private String telephone;
    private String qq;
    private String email;
    private String sex;
    private Date registerTime;
    private String headPic;

    public User() {
    }

    public User(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public User(Date createTime, Date updateTime, String userName, String userPassword, String telephone, String qq, String email, String sex, Date registerTime, String headPic) {
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.userName = userName;
        this.userPassword = userPassword;
        this.telephone = telephone;
        this.qq = qq;
        this.email = email;
        this.sex = sex;
        this.registerTime = registerTime;
        this.headPic = headPic;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", telephone='" + telephone + '\'' +
                ", qq='" + qq + '\'' +
                ", email='" + email + '\'' +
                ", sex='" + sex + '\'' +
                ", registerTime=" + registerTime +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }
}
