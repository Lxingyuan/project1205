package com.entity;

import java.util.Date;

/**
 * 作者：林星源
 * 日期: 2020/12/9 10:39
 * 描述:
 */
public class Movie {
    private Integer movieId;
    private String movieName;
    private String type;
    private String director;
    private String protagonist;
    private String showTime;
    private String picAddress;
    private String postAddress;
    private String videoAddress;
    private String content;
    private Integer hits;
    private Date createTime;
    private Date updateTime;

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", movieName='" + movieName + '\'' +
                ", type='" + type + '\'' +
                ", director='" + director + '\'' +
                ", protagonist='" + protagonist + '\'' +
                ", showTime='" + showTime + '\'' +
                ", picAddress='" + picAddress + '\'' +
                ", postAddress='" + postAddress + '\'' +
                ", videoAddress='" + videoAddress + '\'' +
                ", content='" + content + '\'' +
                ", hits=" + hits +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public Movie() {
    }

    public Movie(Integer movieId, String movieName, String type, String director, String protagonist, String showTime, String picAddress, String postAddress, String videoAddress, String content, Integer hits, Date createTime, Date updateTime) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.type = type;
        this.director = director;
        this.protagonist = protagonist;
        this.showTime = showTime;
        this.picAddress = picAddress;
        this.postAddress = postAddress;
        this.videoAddress = videoAddress;
        this.content = content;
        this.hits = hits;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public String getPostAddress() {
        return postAddress;
    }

    public void setPostAddress(String postAddress) {
        this.postAddress = postAddress;
    }

    public String getVideoAddress() {
        return videoAddress;
    }

    public void setVideoAddress(String videoAddress) {
        this.videoAddress = videoAddress;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProtagonist() {
        return protagonist;
    }

    public void setProtagonist(String protagonist) {
        this.protagonist = protagonist;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
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
}
