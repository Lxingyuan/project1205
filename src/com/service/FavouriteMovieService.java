package com.service;

import com.entity.FavouriteMovie;

import java.util.List;

/**
 * @author ：liuyuntao
 * @date ：Created in 2020/12/23 14:55
 */
public interface FavouriteMovieService {
    List<FavouriteMovie> queryFavouriteMovie(String userName);
}
