package com.dao.impl;

import com.dao.BaseDao;
import com.dao.FavouriteToolDao;
import com.entity.FavouriteTool;

import java.util.List;

/**
 * @author ：liuyuntao
 * @date ：Created in 2020/12/23 14:49
 */
public class FavouriteToolImpl extends BaseDao implements FavouriteToolDao {

    @Override
    public List<FavouriteTool> queryFavouriteTool(String userName) {
        String sql = "select * from favouriteTool where userName = ?";
        return queryForList(FavouriteTool.class, sql,userName);
    }

    @Override
    public Integer insert(FavouriteTool favouriteTool) {
        String sql = "insert into favouriteTool (toolId,userName)values(?,?)";
        return update(sql, favouriteTool.getToolId(),favouriteTool.getUserName());
    }

    @Override
    public int deleteFavouriteTool(Integer toolId,String userName) {
        String sql = "delete from favouriteTool where toolId = ? and userName = ?";
        return update(sql, toolId,userName);
    }
}
