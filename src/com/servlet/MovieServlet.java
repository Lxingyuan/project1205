package com.servlet;

import com.entity.Movie;
import com.google.gson.Gson;
import com.service.MovieService;
import com.service.impl.MovieServiceImpl;
import com.utils.Page2;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


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
    public void updateMovie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String movieId=request.getParameter("movieId");
        //要更新的字段名
        String columnName=request.getParameter("columnName");
        //要更新的字段值
        String columnValue=request.getParameter("columnValue");
        columnValue=columnValue.replace("'", "\\'");
        columnValue=columnValue.replace("\"", "\\\"");
        columnValue=columnValue.replace("\\", "\\\\");
        System.out.println(movieId+" "+columnName+" "+columnValue);
        Integer result=movieService.updateMovieColumnValue(Integer.parseInt(movieId),columnName,columnValue);
        if(result<0){
            response.getWriter().write("false");
        }else {
            response.getWriter().write("true");
        }
    }

    /**
     * 限定条件查询
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void queryMovieListLimit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //电影名称
        String movieName=request.getParameter("movieName");
        //电影类型
        String type=request.getParameter("type");
        //主演
        String protagonist=request.getParameter("protagonist");
        //上映年份
        String showTime=request.getParameter("showTime");
        //System.out.println("|movieName:"+movieName+"|type:"+type+"|protagonist:"+protagonist+"|showTime:"+showTime+"|");
        Page2<Movie> page = movieService.queryMovieByPage2(movieName,type,protagonist,showTime);
        System.out.println("page2:"+page);
        Gson gson = new Gson();
        //转成字符串
        String jsonStr = gson.toJson(page);
        //写入返回信息
        response.getWriter().write(jsonStr);
    }

}
