package com.dao;

import com.entity.Movie;
import com.entity.User;

import java.util.Date;
import java.util.List;

/**
 * 作者：林星源
 * 日期: 2020/12/9 11:13
 * 描述:电影
 */
public interface MovieDao {
    //添加电影信息
    int insertMovie(Movie movie);

    //修改电影信息
    int updateMovie(Movie movie);
    //修改某个字段的电影信息
    int updateMovieColumnValue(Integer movieId,String columnName,String columnValue);
    //删除电影信息
    int deleteMovie(Integer movieId);

    //按名字查询电影
    Movie queryMovieByName(String movieName);

    //按类别查询电影
    Movie queryMovieByType(String movieType);

    //按导演查询电影
    Movie queryMovieByDirector(String director);

    //按主演查询电影
    Movie queryMovieByProtagonist(String protagonist);

    //按上映年份查询电影
    Movie queryMovieByShowTime(String showTime);

    //按浏览次数查询电影
    Movie queryMovieByHits(Integer hits);

    Integer queryPageTotalCounts();

    List<Movie> queryMovieByPage(Integer pageNo, Integer pageSize);

    List<Movie> queryAllMovie();
}
