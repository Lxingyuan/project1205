package com.service.impl;

import com.dao.FavouriteToolDao;
import com.dao.impl.FavouriteToolImpl;
import com.entity.FavouriteTool;
import com.service.FavouriteToolService;

import java.util.List;

/**
 * @author ：liuyuntao
 * @date ：Created in 2020/12/23 14:55
 */
public class FavouriteToolServiceImpl implements FavouriteToolService {
    FavouriteToolDao favouriteToolDao =new FavouriteToolImpl();
    @Override
    public List<FavouriteTool> queryFavouriteTool(String userName) {
        return favouriteToolDao.queryFavouriteTool(userName);
    }

    @Override
    public Integer insert(FavouriteTool favouriteTool) {
        return favouriteToolDao.insert(favouriteTool);
    }

    @Override
    public int deleteFavouriteTool(Integer toolId, String userName) {
        return favouriteToolDao.deleteFavouriteTool(toolId,userName);
    }
}
