package com.servlet;

import com.entity.Admin;
import com.google.gson.Gson;
import com.entity.User;
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

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * 作者：林星源
 * 日期: 2020/12/1 16:08
 * 描述:用户执行操作
 * Win10
 */
@WebServlet("/user.do")
public class UserServlet extends BaseServlet {
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

    public void queryPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer pageNo = Integer.valueOf(request.getParameter("pageNo"));
        Page<User> page = userService.queryByPage(pageNo, Page.PAGE_SIZE);
        Gson gson = new Gson();
        String jsonStr = gson.toJson(page);
        response.getWriter().write(jsonStr);
    }

    /**
     * 通过用户名查询(注册时用户名唯一性判断）
     *
     * @param request
     * @param response
     * @throws IOException
     */
    public void queryUserByUsername(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        User user = userService.queryUserByUsername(username);
        Admin admin = adminService.queryUserByUsername(username);
        String message = ((user == null) && (admin == null)) ? "true" : "false";
        response.getWriter().write(message);
    }

    /**
     * 通过手机号查询(注册时手机号唯一性判断）
     * @param request
     * @param response
     * @throws IOException
     */
    public void queryUserByTelephone(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String telephone = request.getParameter("telephone");
        User user = userService.queryUserByTelephone(telephone);
        String message = (user == null) ? "true" : "false";
        response.getWriter().write(message);
    }

    //登录
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, InterruptedException {
        //防止中文乱码的金句
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        //获取验证码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:" + username);
        System.out.println("password:" + password);
        User user = userService.login(new User(username, password));
        System.out.println(user);
        if (user != null) {
            //登录成功
            response.getWriter().write("false");
        } else {
            response.getWriter().write("true");
            request.getSession().setAttribute("user,", user);
        }
    }
}
