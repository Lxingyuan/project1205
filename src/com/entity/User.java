package com.entity;

import java.sql.Timestamp;

/**
 * @author Win10
 */
public class User {
    private Integer userId;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String userName;
    private String userPassword;
    private String telephone;
    private String qq;
    private String email;
    private String sex;
    private Timestamp registerTime;
    private String headPic;

    public User() {
    }

    public User(Timestamp createTime, Timestamp updateTime, String userName, String userPassword, String telephone, String qq, String email, String sex, Timestamp registerTime, String headPic) {
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

    public Timestamp getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Timestamp registerTime) {
        this.registerTime = registerTime;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }
}
