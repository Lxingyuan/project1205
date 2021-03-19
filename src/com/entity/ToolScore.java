package com.entity;

/**
 * 作者：林星源
 * 日期: 2021/3/18 16:26
 * 描述:
 */
public class ToolScore {

    private Integer scoreId;
    private Integer toolId;
    private Integer score;
    private String userName;

    @Override
    public String toString() {
        return "ToolScoreService{" +
                "scoreId=" + scoreId +
                ", toolId=" + toolId +
                ", score=" + score +
                ", userName='" + userName + '\'' +
                '}';
    }

    public ToolScore() {
    }

    public ToolScore(Integer toolId, Integer score, String userName) {
        this.toolId = toolId;
        this.score = score;
        this.userName = userName;
    }

    public Integer getScoreId() {
        return scoreId;
    }

    public void setScoreId(Integer scoreId) {
        this.scoreId = scoreId;
    }

    public Integer getToolId() {
        return toolId;
    }

    public void setToolId(Integer toolId) {
        this.toolId = toolId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
