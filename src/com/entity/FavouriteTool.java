package com.entity;

/**
 * @author ：liuyuntao
 * @date ：Created in 2020/12/23 14:18
 */
public class FavouriteTool {
    /**
     * 主键
     */
    private Integer favouriteToolId;
    private Integer toolId;
    private String userName;

    @Override
    public String toString() {
        return "FavouriteTool{" +
                "favouriteToolId=" + favouriteToolId +
                ", toolId=" + toolId +
                ", userName='" + userName + '\'' +
                '}';
    }

    public FavouriteTool(Integer toolId, String userName) {
        this.toolId = toolId;
        this.userName = userName;
    }

    public FavouriteTool() {
    }

    public Integer getFavouriteToolId() {
        return favouriteToolId;
    }

    public void setFavouriteToolId(Integer favouriteToolId) {
        this.favouriteToolId = favouriteToolId;
    }

    public Integer getToolId() {
        return toolId;
    }

    public void setToolId(Integer toolId) {
        this.toolId = toolId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
