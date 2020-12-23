package com.dao;

import com.entity.FavouriteMovie;

import java.util.List;

/**
 * @author ：liuyuntao
 * @date ：Created in 2020/12/23 14:25
 */
public interface FavouriteMovieDao {
    List<FavouriteMovie> queryFavouriteMovie(String userName);
}
