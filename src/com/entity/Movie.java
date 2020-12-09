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
    private Integer typeId;
    private String director;
    private String protagonist;
    private String showTime;
    private String picAddress;
    private String content;
    private Integer hits;
    private Date createTime;
    private Date updateTime;

    public Movie() {
    }

    public Movie(Integer movieId, String movieName, Integer typeId, String director, String protagonist, String showTime, String picAddress, String content, Integer hits, Date createTime, Date updateTime) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.typeId = typeId;
        this.director = director;
        this.protagonist = protagonist;
        this.showTime = showTime;
        this.picAddress = picAddress;
        this.content = content;
        this.hits = hits;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", movieName='" + movieName + '\'' +
                ", typeId=" + typeId +
                ", director='" + director + '\'' +
                ", protagonist='" + protagonist + '\'' +
                ", showTime='" + showTime + '\'' +
                ", picAddress='" + picAddress + '\'' +
                ", content='" + content + '\'' +
                ", hits=" + hits +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
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

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
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
