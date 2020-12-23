package com.servlet;

import com.entity.Admin;
import com.entity.FavouriteMovie;
import com.google.gson.Gson;
import com.service.AdminService;
import com.service.FavouriteMovieService;
import com.service.impl.AdminServiceImpl;
import com.service.impl.FavouriteMovieServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 作者：林星源
 * 日期: 2020/12/1 16:08
 * 描述:用户执行操作
 * Win10
 */
@WebServlet("/favouriteMovie.do")
public class FavouriteMovieServlet extends BaseServlet {
    FavouriteMovieService favouriteMovieService=new FavouriteMovieServiceImpl();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        super.doGet(request, response);
    }

    public void insert(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String movieId = request.getParameter("movieId");
        String userName = request.getParameter("userName");
        Integer result=favouriteMovieService.insert(new FavouriteMovie(Integer.parseInt(movieId),userName));
        if (result > 0) {
            response.getWriter().write("true");
        } else {
            response.getWriter().write("false");
        }
    }
    public void deleteFavouriteMovie(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String movieId = request.getParameter("movieId");
        String userName = request.getParameter("userName");
        Integer result=favouriteMovieService.deleteFavouriteMovie(Integer.parseInt(movieId),userName);
        if (result > 0) {
            response.getWriter().write("true");
        } else {
            response.getWriter().write("false");
        }
    }
}
