package com.servlet;

import com.entity.FavouriteTool;
import com.service.FavouriteToolService;
import com.service.impl.FavouriteToolServiceImpl;

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
@WebServlet("/favouriteTool.do")
public class FavouriteToolServlet extends BaseServlet {
    FavouriteToolService favouriteToolService =new FavouriteToolServiceImpl();


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
        String toolId = request.getParameter("toolId");
        String userName = request.getParameter("userName");
        Integer result= favouriteToolService.insert(new FavouriteTool(Integer.parseInt(toolId),userName));
        if (result > 0) {
            response.getWriter().write("true");
        } else {
            response.getWriter().write("false");
        }
    }
    public void deleteFavouriteTool(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String toolId = request.getParameter("toolId");
        String userName = request.getParameter("userName");
        Integer result= favouriteToolService.deleteFavouriteTool(Integer.parseInt(toolId),userName);
        if (result > 0) {
            response.getWriter().write("true");
        } else {
            response.getWriter().write("false");
        }
    }
}
