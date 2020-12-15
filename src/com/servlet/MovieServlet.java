package com.servlet;

import com.entity.Admin;
import com.entity.Movie;
import com.google.gson.Gson;
import com.service.AdminService;
import com.service.MovieService;
import com.service.UserService;
import com.service.impl.AdminServiceImpl;
import com.service.impl.MovieServiceImpl;
import com.service.impl.UserServiceImpl;
import com.utils.Page;
import com.utils.Page2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;

/**
 * 作者：林星源
 * 日期: 2020/12/1 16:08
 * 描述:用户执行操作
 * Win10
 */
@WebServlet("/movie.do")
public class MovieServlet extends BaseServlet {
    MovieService movieService=new MovieServiceImpl();

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


    public void queryMovieList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Integer pageNo = Integer.valueOf(request.getParameter("pageNo"));
        Page2<Movie> page = movieService.queryMovieByPage2();
        System.out.println("page:"+page);
        Gson gson = new Gson();
        //转成字符串
        String jsonStr = gson.toJson(page);
        //写入返回信息
        response.getWriter().write(jsonStr);
    }

    public void deleteMovie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] idNum=request.getParameterValues("idNum[]");
        boolean flag=true;
        Integer result;
        //String idNum2 = request.getParameter("idNum");
        //System.out.println("idNum:"+idNum2);
        for (int i = 0; i <idNum.length ; i++) {
            //System.out.print(idNum[i]+" ");
            result=movieService.deleteMovie(Integer.parseInt(idNum[i]));
            //删除失败
            if(result<0){
                flag=false;
                break;
            }
        }
        if(flag==true){
            response.getWriter().write("true");
        }else {
            response.getWriter().write("false");
        }
    }

}
