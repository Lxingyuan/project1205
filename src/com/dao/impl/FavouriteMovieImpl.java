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

    @Override
    public Integer insert(FavouriteMovie favouriteMovie) {
        String sql = "insert into favouriteMovie (movieId,userName)values(?,?)";
        return update(sql, favouriteMovie.getMovieId(),favouriteMovie.getUserName());
    }

    @Override
    public int deleteFavouriteMovie(Integer movieId,String userName) {
        String sql = "delete from favouriteMovie where movieId = ? and userName = ?";
        return update(sql, movieId,userName);
    }
}
