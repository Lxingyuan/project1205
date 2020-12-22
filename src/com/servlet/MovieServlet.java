package com.servlet;

import com.entity.Movie;
import com.google.gson.Gson;
import com.service.MovieService;
import com.service.impl.MovieServiceImpl;
import com.utils.Page;
import com.utils.Page2;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * 作者：林星源
 * 日期: 2020/12/1 16:08
 * 描述:用户执行操作
 * Win10
 */
@WebServlet("/movie.do")
public class MovieServlet extends BaseServlet {
    MovieService movieService = new MovieServiceImpl();

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
        System.out.println("page:" + page);
        Gson gson = new Gson();
        //转成字符串
        String jsonStr = gson.toJson(page);
        //写入返回信息
        response.getWriter().write(jsonStr);
    }
    public void deleteMovieById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String movieId = request.getParameter("movieId");
        Integer result = movieService.deleteMovie(Integer.parseInt(movieId));
        if (result < 0) {
            response.getWriter().write("false");
        } else {
            response.getWriter().write("true");
        }
    }
    public void deleteMovie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] idNum = request.getParameterValues("idNum[]");
        boolean flag = true;
        Integer result;
        //String idNum2 = request.getParameter("idNum");
        //System.out.println("idNum:"+idNum2);
        for (int i = 0; i < idNum.length; i++) {
            //System.out.print(idNum[i]+" ");
            result = movieService.deleteMovie(Integer.parseInt(idNum[i]));
            //删除失败
            if (result < 0) {
                flag = false;
                break;
            }
        }
        if (flag == true) {
            response.getWriter().write("true");
        } else {
            response.getWriter().write("false");
        }
    }

    public void updateMovie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String movieId = request.getParameter("movieId");
        //要更新的字段名
        String columnName = request.getParameter("columnName");
        //要更新的字段值
        String columnValue = request.getParameter("columnValue");
        //System.out.println("columnValue替换前:"+columnValue);
        //columnValue=columnValue.replace("'", "\\'");
        //columnValue=columnValue.replace("\"", "\\\"");
        columnValue = columnValue.replace("\\", "\\\\");
        //System.out.println("columnValue替换后:"+columnValue);
        System.out.println(movieId + " " + columnName + " " + columnValue);
        Integer result = movieService.updateMovieColumnValue(Integer.parseInt(movieId), columnName, columnValue);
        if (result < 0) {
            response.getWriter().write("false");
        } else {
            response.getWriter().write("true");
        }
    }

    /**
     * 限定条件查询
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void queryMovieListLimit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //电影名称
        String movieName = request.getParameter("movieName");
        //电影类型
        String type = request.getParameter("type");
        //主演
        String protagonist = request.getParameter("protagonist");
        //上映年份
        String showTime = request.getParameter("showTime");
        //System.out.println("|movieName:"+movieName+"|type:"+type+"|protagonist:"+protagonist+"|showTime:"+showTime+"|");
        Page2<Movie> page = movieService.queryMovieByPage2(movieName, type, protagonist, showTime);
        System.out.println("page2:" + page);
        Gson gson = new Gson();
        //转成字符串
        String jsonStr = gson.toJson(page);
        //写入返回信息
        response.getWriter().write(jsonStr);
    }

    public void queryMoviePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Integer pageNo = Integer.valueOf(request.getParameter("pageNo"));
        Page<Movie> page = movieService.queryMovieByPage(pageNo, Page.PAGE_SIZE);
        Gson gson = new Gson();
        String jsonStr = gson.toJson(page);
        response.getWriter().write(jsonStr);
    }

    public void addMovie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Movie movie = new Movie();
        movie.setHits(0);
        movie.setPostAddress("/static/images/2.jpg");
        if (ServletFileUpload.isMultipartContent(request)) {
            // 创建FileItemFactory 工厂实现类
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            //创建用于解析上传数据的工具类
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            try {
                //解析上传的数据 得到每一个表单项FileItem
                List<FileItem> list = servletFileUpload.parseRequest(request);
                //循环判断，每一个表单项 是普通类型 还是上传的文件
                for (FileItem fileItem :
                        list) {
                    if (fileItem.isFormField()) {
                        //普通表单项
                        System.out.println("普通项 name:" + fileItem.getFieldName());
                        //参数UTF-8解决乱码
                        System.out.println("value = " + fileItem.getString("UTF-8"));
                        if ("movieName".equals(fileItem.getFieldName())) {
                            movie.setMovieName(fileItem.getString("UTF-8"));
                        } else if ("type".equals(fileItem.getFieldName())) {
                            movie.setType(fileItem.getString("UTF-8"));
                        } else if ("director".equals(fileItem.getFieldName())) {
                            movie.setDirector(fileItem.getString("UTF-8"));
                        } else if ("protagonist".equals(fileItem.getFieldName())) {
                            movie.setProtagonist(fileItem.getString("UTF-8"));
                        } else if ("showTime".equals(fileItem.getFieldName())) {
                            movie.setShowTime(fileItem.getString("UTF-8"));
                        } else if ("content".equals(fileItem.getFieldName())) {
                            movie.setContent(fileItem.getString("UTF-8"));
                        }
                    } else {
                        //上传的文件
                        System.out.println("文件项的name:" + fileItem.getFieldName());
                        System.out.println("上传的文件名:" + fileItem.getName());
                        Long time = System.currentTimeMillis();
                        fileItem.write(new File("D:\\project1205\\images\\" + time + fileItem.getName()));
                        //要保存时到数据库的文件名
                        String fileName = "http://localhost:8765/images\\" + time + fileItem.getName();
                        movie.setPicAddress(fileName);
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Integer result = movieService.insertMovie(movie);
        //System.out.println("result:" + result);
        if (result > 0) {
            response.getWriter().write("true");
        } else {
            response.getWriter().write("false");
        }
    }

    public void queryMovieById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String movieId = request.getParameter("movieId");
        Movie movie = movieService.queryMovieById(Integer.parseInt(movieId));
        if (movie == null) {
            response.getWriter().write("false");
        } else {
            response.getWriter().write("true");
        }
    }

    public void queryMovieByHits(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        List<Movie> list = movieService.queryMovieByHits();
        Page2<Movie> page = new Page2<>();
        page.setCode(0);
        page.setMsg("");
        page.setCount(list.size());
        page.setData(list);
        Gson gson = new Gson();
        String jsonStr = gson.toJson(page);
        response.getWriter().write(jsonStr);
//        System.out.println("jsonStr:"+jsonStr);
    }

    public void queryMovieByMovieId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Integer movieId = Integer.valueOf(request.getParameter("movieId"));
        System.out.println(movieId);
        Movie movieObj = movieService.queryMovieById(movieId);
        System.out.println(movieObj);
        Gson gson = new Gson();
        String jsonStr = gson.toJson(movieObj);
        response.getWriter().write(jsonStr);
    }

}
