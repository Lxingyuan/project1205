package com.service.impl;

import com.dao.FavouriteMovieDao;
import com.dao.MovieDao;
import com.dao.impl.FavouriteMovieImpl;
import com.dao.impl.MovieDaoImpl;
import com.entity.FavouriteMovie;
import com.entity.Movie;
import com.service.MovieService;
import com.utils.Page;
import com.utils.Page2;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：林星源
 * 日期: 2020/12/10 14:42
 * 描述:
 */
public class MovieServiceImpl implements MovieService {
    MovieDao movieDao = new MovieDaoImpl();
    FavouriteMovieDao favouriteMovieDao=new FavouriteMovieImpl();
    @Override
    public int insertMovie(Movie movie) {
        return movieDao.insertMovie(movie);
    }

    @Override
    public int updateMovie(Movie movie) {
        return movieDao.updateMovie(movie);
    }

    @Override
    public int deleteMovie(Integer movieId) {
        return movieDao.deleteMovie(movieId);
    }

    @Override
    public Movie queryMovieByName(String movieName) {
        return movieDao.queryMovieByName(movieName);
    }

    @Override
    public Movie queryMovieByType(String movieType) {
        return movieDao.queryMovieByType(movieType);
    }

    @Override
    public Movie queryMovieByDirector(String director) {
        return movieDao.queryMovieByDirector(director);
    }

    @Override
    public Movie queryMovieById(Integer id) {
        return movieDao.queryMovieById(id);
    }

    @Override
    public Movie queryMovieByProtagonist(String protagonist) {
        return movieDao.queryMovieByProtagonist(protagonist);
    }

    @Override
    public Movie queryMovieByShowTime(String showTime) {
        return movieDao.queryMovieByShowTime(showTime);
    }

    @Override
    public List<Movie> queryMovieByHits() {
        return movieDao.queryMovieByHits();
    }

    @Override
    public List<Movie> queryMovieByVoteNum() {
        return movieDao.queryMovieByVoteNum();
    }

    @Override
    public Page<Movie> queryMovieByPage(int pageNo, int pageSize) {
        Page<Movie> page = new Page<>();
        //设置当前页码
        page.setPageNo(pageNo);
        //设置页面大小
        page.setPageSize(pageSize);
        //求总记录数
        Integer pageTotalCount = movieDao.queryPageTotalCounts();
        //设置总记录数
        page.setPageTotalCount(pageTotalCount);
        //求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal += 1;
        }
        //设置总页码
        page.setPageTotal(pageTotal);
        //求开始页码
        int begin = (page.getPageNo() - 1) * pageSize;
        //获取开始页码的分页数据
        List<Movie> items = movieDao.queryMovieByPage(begin, pageSize);
        //设置数据
        page.setItems(items);
        return page;
    }

    @Override
    public Page2<Movie> queryMovieByPage2() {
        Page2<Movie> page = new Page2<>();
        page.setCode(0);
        page.setMsg("");
        List<Movie> list = movieDao.queryAllMovie();
        page.setData(list);
        page.setCount(list.size());
        return page;
    }

    @Override
    public Page2<Movie> queryMovieByPage2(String movieName, String type, String protagonist, String showTime) {
        Page2<Movie> page = new Page2<>();
        page.setCode(0);
        page.setMsg("");
        List<Movie> list = movieDao.queryAllMovie(movieName, type, protagonist, showTime);
        page.setData(list);
        page.setCount(list.size());
        return page;
    }

    @Override
    public int updateMovieColumnValue(Integer movieId, String columnName, String columnValue) {
        return movieDao.updateMovieColumnValue(movieId, columnName, columnValue);
    }

    @Override
    public int addMovieHits(Integer movieId) {
        return movieDao.addMovieHits(movieId);
    }

    @Override
    public Integer addMovieVote(Integer movieId) {
        return movieDao.addMovieVote(movieId);
    }

    @Override
    public List<Movie> searchMovie(String searchMessage) {
        return movieDao.searchMovie(searchMessage);
    }
}
