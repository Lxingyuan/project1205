package com.entity;

import java.util.Date;

/**
 * 作者：林星源
 * 日期: 2020/12/9 10:39
 * 描述:
 */
public class Tool {
    private Integer toolId;
    private String toolName;
    private String type;
    private String characteristic;
    private String uploader;
    private String uploadTime;
    private String picAddress;
    private String downloadAddr;
    private String teachingAddress;
    private String content;
    private Integer hits;
    private Date createTime;
    private Date updateTime;
    private Integer voteNum;
    private Integer state;

    public Integer getVoteNum() {
        return voteNum;
    }

    public void setVoteNum(Integer voteNum) {
        this.voteNum = voteNum;
    }

    @Override
    public String toString() {
        return "Tool{" +
                "toolId=" + toolId +
                ", toolName='" + toolName + '\'' +
                ", type='" + type + '\'' +
                ", characteristic='" + characteristic + '\'' +
                ", uploader='" + uploader + '\'' +
                ", uploadTime='" + uploadTime + '\'' +
                ", picAddress='" + picAddress + '\'' +
                ", downloadAddr='" + downloadAddr + '\'' +
                ", teachingAddress='" + teachingAddress + '\'' +
                ", content='" + content + '\'' +
                ", hits=" + hits +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", voteNum=" + voteNum +
                ", state=" + state +
                '}';
    }

    public Tool() {
    }

    public Tool(String toolName, String type, String characteristic, String uploader, String uploadTime, String picAddress, String downloadAddr, String teachingAddress, String content, Integer hits, Date createTime, Date updateTime, Integer voteNum, Integer state) {
        this.toolName = toolName;
        this.type = type;
        this.characteristic = characteristic;
        this.uploader = uploader;
        this.uploadTime = uploadTime;
        this.picAddress = picAddress;
        this.downloadAddr = downloadAddr;
        this.teachingAddress = teachingAddress;
        this.content = content;
        this.hits = hits;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.voteNum = voteNum;
        this.state = state;
    }

    public String getDownloadAddr() {
        return downloadAddr;
    }

    public void setDownloadAddr(String downloadAddr) {
        this.downloadAddr = downloadAddr;
    }

    public String getTeachingAddress() {
        return teachingAddress;
    }

    public void setTeachingAddress(String teachingAddress) {
        this.teachingAddress = teachingAddress;
    }

    public Integer getToolId() {
        return toolId;
    }

    public void setToolId(Integer toolId) {
        this.toolId = toolId;
    }

    public String getToolName() {
        return toolName;
    }

    public void setToolName(String toolName) {
        this.toolName = toolName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getPicAddress() {
        return picAddress;
    }

    public void setPicAddress(String picAddress) {
        this.picAddress = picAddress;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
