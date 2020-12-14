package com.servlet;

import com.aliyuncs.exceptions.ClientException;
import com.entity.Admin;
import com.entity.User;
import com.google.gson.Gson;
import com.service.AdminService;
import com.service.UserService;
import com.service.impl.AdminServiceImpl;
import com.service.impl.UserServiceImpl;
import com.utils.Page;

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
@WebServlet("/admin.do")
public class AdminServlet extends BaseServlet {
    UserService userService = new UserServiceImpl();
    AdminService adminService = new AdminServiceImpl();


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

    /**
     * 后台管理员登入
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void adminLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Admin admin = adminService.login(new Admin(username, password));
        System.out.println("admin:" + admin);
        if(admin!=null){
            response.getWriter().write("true");
            request.getSession().setAttribute("admin", admin);
        }
        else {
            response.getWriter().write("false");
        }
    }
    /**
     * 管理员登出
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void adminLogOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().removeAttribute("admin");
        response.getWriter().write("true");
    }
}
