package com.dao.impl;

import com.dao.BaseDao;
import com.dao.FavouriteMovieDao;
import com.entity.FavouriteMovie;

import java.util.List;

/**
 * @author ：liuyuntao
 * @date ：Created in 2020/12/23 14:49
 */
public class FavouriteMovieImpl extends BaseDao implements FavouriteMovieDao {

    @Override
    public List<FavouriteMovie> queryFavouriteMovie(String userName) {
        String sql = "select * from favouriteMovie where userName = ?";
        return queryForList(FavouriteMovie.class, sql,userName);
    }
}
