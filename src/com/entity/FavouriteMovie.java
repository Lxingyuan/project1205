package com.entity;

/**
 * @author ：liuyuntao
 * @date ：Created in 2020/12/23 14:18
 */
public class FavouriteMovie {
    /**
     * 主键
     */
    private Integer favouriteMovieId;
    private Integer movieId;
    private String userName;

    @Override
    public String toString() {
        return "FavouriteMovie{" +
                "favouriteMovieId=" + favouriteMovieId +
                ", movieId=" + movieId +
                ", userName='" + userName + '\'' +
                '}';
    }

    public FavouriteMovie(Integer movieId, String userName) {
        this.movieId = movieId;
        this.userName = userName;
    }

    public FavouriteMovie() {
    }

    public Integer getFavouriteMovieId() {
        return favouriteMovieId;
    }

    public void setFavouriteMovieId(Integer favouriteMovieId) {
        this.favouriteMovieId = favouriteMovieId;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
