package com.dao.impl;

import com.dao.BaseDao;
import com.dao.MovieDao;
import com.entity.Movie;
import com.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.sql.ResultSet;
import java.util.List;

/**
 * 作者：林星源
 * 日期: 2020/12/10 11:34
 * 描述:
 */
public class MovieDaoImpl extends BaseDao implements MovieDao {
    @Override
    public int insertMovie(Movie movie) {
        String sql = "insert into movie (MovieName,Type,Director,Protagonist,ShowTime,PicAddress,Content,Hits)values(?,?,?,?,?,?,?,?)";
        return update(sql, movie.getMovieName(), movie.getType(), movie.getDirector(), movie.getProtagonist(), movie.getShowTime(), movie.getPicAddress(), movie.getContent(), movie.getHits());
    }

    @Override
    public int updateMovie(Movie movie) {
        String sql = "update movie set UpdateTime=?,MovieName=?,Type=?,Director=?,Protagonist=?,ShowTime=?,PicAddress=?,Content=?,Hits=? where MovieId = ?";
        return update(sql, movie.getUpdateTime(), movie.getMovieName(), movie.getType(), movie.getDirector(), movie.getProtagonist(), movie.getShowTime(), movie.getPicAddress(), movie.getContent(), movie.getHits(), movie.getMovieId());
    }

    @Override
    public int updateMovieColumnValue(Integer movieId, String columnName, String columnValue) {
        //System.out.println("dao中:"+movieId+" "+columnName+" "+columnValue);
        String sql = "update movie set " + columnName + " = '" + columnValue + "' where movieId = " + movieId;
        //System.out.println("sql:"+sql);
        return update(sql);
    }

    @Override
    public int deleteMovie(Integer movieId) {
        String sql = "delete from movie where MovieId = ?";
        return update(sql, movieId);
    }

    @Override
    public Movie queryMovieByName(String movieName) {
        String sql = "select * from movie where MovieName=?";
        return queryForOne(Movie.class, sql, movieName);
    }

    @Override
    public Movie queryMovieByType(String movieType) {
        String sql = "select * from movie where MovieType=?";
        return queryForOne(Movie.class, sql, movieType);
    }

    @Override
    public Movie queryMovieByDirector(String director) {
        String sql = "select * from movie where Director=?";
        return queryForOne(Movie.class, sql, director);
    }

    @Override
    public Movie queryMovieByProtagonist(String protagonist) {
        String sql = "select * from movie where Protagonist=?";
        return queryForOne(Movie.class, sql, protagonist);
    }

    @Override
    public Movie queryMovieByShowTime(String showTime) {
        String sql = "select * from movie where ShowTime=?";
        return queryForOne(Movie.class, sql, showTime);
    }

    @Override
    public List<Movie> queryMovieByHits() {
        String sql = "select * from movie ORDER BY Hits DESC";
        return queryForList(Movie.class, sql);
    }

    //查询当前表的总记录条数
    @Override
    public Integer queryPageTotalCounts() {
        String sql = "select count(1) from movie";
        return Math.toIntExact((Long) queryForSingleValue(sql));
    }

    @Override
    public List<Movie> queryMovieByPage(Integer begin, Integer pageSize) {
        String sql = "select * from movie limit ?, ?";
        return queryForList(Movie.class, sql, begin, pageSize);
    }

    @Override
    public List<Movie> queryAllMovie() {
        String sql = "select * from movie";
        return queryForList(Movie.class, sql);
    }

    @Override
    public List<Movie> queryAllMovie(String movieName, String type, String protagonist, String showTime) {
        String sql = "SELECT * FROM movie WHERE movieName LIKE '%' AND type LIKE '%' AND protagonist LIKE '%' AND showTime LIKE '%'";
        if(StringUtils.isNotEmpty(movieName)){
            String string="movieName LIKE '%"+movieName+"%'";
            sql=sql.replace("movieName LIKE '%'",string);
        }
        if(StringUtils.isNotEmpty(type)){
            String string="type LIKE '%"+type+"%'";
            sql=sql.replace("type LIKE '%'",string);
        }
        if(StringUtils.isNotEmpty(protagonist)){
            String string="protagonist LIKE '%"+protagonist+"%'";
            sql=sql.replace("protagonist LIKE '%'",string);
        }
        if(StringUtils.isNotEmpty(showTime)){
            String string="showTime LIKE '"+showTime+"'";
            sql=sql.replace("showTime LIKE '%'",string);
        }
        return queryForList(Movie.class, sql);
    }


}
