package com.dao;

import com.entity.FavouriteTool;

import java.util.List;


public interface FavouriteToolDao {

    List<FavouriteTool> queryFavouriteTool(String userName);

    Integer insert(FavouriteTool favouriteTool);

    int deleteFavouriteTool(Integer toolId, String userName);
}
