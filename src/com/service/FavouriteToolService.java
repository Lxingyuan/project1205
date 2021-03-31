package com.service;

import com.entity.FavouriteTool;

import java.util.List;

/**
 * @author ：liuyuntao
 * @date ：Created in 2020/12/23 14:55
 */
public interface FavouriteToolService {
    List<FavouriteTool> queryFavouriteTool(String userName);
    Integer insert(FavouriteTool favouriteTool);
    int deleteFavouriteTool(Integer toolId, String userName);
}
