package com.service;

import com.entity.Movie;
import com.utils.Page;
import com.utils.Page2;

import java.util.List;

/**
 * 作者：林星源
 * 日期: 2020/12/10 14:41
 * 描述:
 */
public interface MovieService {
    //添加电影信息
    int insertMovie(Movie movie);

    //修改电影信息
    int updateMovie(Movie movie);

    //删除电影信息
    int deleteMovie(Integer movieId);

    //按名字查询电影
    Movie queryMovieByName(String movieName);

    //按类别查询电影
    Movie queryMovieByType(String movieType);

    //按导演查询电影
    Movie queryMovieByDirector(String director);

    //按id查询电影
    Movie queryMovieById(Integer id);

    //按主演查询电影
    Movie queryMovieByProtagonist(String protagonist);

    //按上映年份查询电影
    Movie queryMovieByShowTime(String showTime);

    //按浏览次数查询电影
    List<Movie> queryMovieByHits();

    //电影分页
    Page<Movie> queryMovieByPage(int pageNo, int pageSize);

    //电影分页2
    Page2<Movie> queryMovieByPage2();

    /**
     * 按条件查询
     *
     * @param movieName
     * @param type
     * @param protagonist
     * @param showTime
     * @return
     */
    Page2<Movie> queryMovieByPage2(String movieName, String type, String protagonist, String showTime);

    //修改某个字段的电影信息
    int updateMovieColumnValue(Integer movieId, String columnName, String columnValue);

    int addMovieHits(Integer movieId);

    List<Movie> searchMovie(String searchMessage);
}
