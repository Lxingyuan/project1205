package com.service.impl;

import com.dao.FavouriteMovieDao;
import com.dao.impl.FavouriteMovieImpl;
import com.entity.FavouriteMovie;
import com.service.FavouriteMovieService;

import java.util.List;

/**
 * @author ：liuyuntao
 * @date ：Created in 2020/12/23 14:55
 */
public class FavouriteMovieServiceImpl implements FavouriteMovieService {
    FavouriteMovieDao favouriteMovieDao=new FavouriteMovieImpl();
    @Override
    public List<FavouriteMovie> queryFavouriteMovie(String userName) {
        return favouriteMovieDao.queryFavouriteMovie(userName);
    }
}
