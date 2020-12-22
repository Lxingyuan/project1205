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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 作者：林星源
 * 日期: 2020/12/1 16:08
 * 描述:用户执行操作
 * Win10
 */
@WebServlet("/admin.do")
public class AdminServlet extends BaseServlet {
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
        String adminName = request.getParameter("adminName");
        String password = request.getParameter("password");
        Admin admin = adminService.login(new Admin(adminName, password));
        if(admin!=null){
            //把对象保存到session中
            request.getSession().setAttribute("admin", admin);
            response.getWriter().write("true");
            //cookie不支持中文，如果往Cookie中添加了中文内容，则系统会抛出异常内容：如果确实需要写入中文，则需要进行BASE64转码才行。在读取Cookie的时候又需要进行反转码。
            Cookie cookie = new Cookie("adminName",adminName);
            //如果没有设置有效期，则默认为-1（或者说小于0的值），表示在浏览器关闭时就删除Cookie内容，如果有效期设置为0，则表示通知浏览器立即删除这个Cookie。
            cookie.setMaxAge(60*60);
            //指定Cookie在哪个网页才有效:cookie.setPath("/")，如果值为“／”表示作用范围为整个网站，默认是这个值。
            response.addCookie(cookie);
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
        // 获取Cookies数组
        Cookie[] cookies = request.getCookies();
        // 迭代查找并清除Cookie
        for (Cookie cookie: cookies) {
            if (cookie.getName().equals("adminName")) {
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
        response.getWriter().write("true");
    }

    /**
     * 查找admin头像
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findAdminHeadPic(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adminName = request.getParameter("adminName");
        Admin admin=adminService.queryAdminByName(adminName);
        String HeadPic=admin.getHeadPic();
        Integer id=admin.getId();
        response.getWriter().write(HeadPic+"&"+id);
    }

    /**
     * 查找admin密码
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findAdminPassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adminName = request.getParameter("adminName");
        Admin admin=adminService.queryAdminByName(adminName);
        String password=admin.getPassword();
        Integer id=admin.getId();
        response.getWriter().write(password+"&"+id);
    }
    public void updatePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String columnName = request.getParameter("columnName");
        String columnValue = request.getParameter("columnValue");
        Integer result = adminService.updateUserColumnValue(Integer.parseInt(id), columnName,columnValue);
        if (result > 0) {
            response.getWriter().write("true");
        } else {
            response.getWriter().write("false");
        }
    }

    /**
     * 查找一个admin
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findAdminByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adminName = request.getParameter("adminName");
        Admin admin=adminService.queryAdminByName(adminName);
        Gson gson = new Gson();
        String jsonStr = gson.toJson(admin);
        response.getWriter().write(jsonStr);
    }
}
