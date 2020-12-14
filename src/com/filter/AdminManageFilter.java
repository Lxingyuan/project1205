package com.filter;

import com.entity.Admin;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author ：liuyuntao
 * @date ：Created in 2020/12/14 14:46
 */
@WebFilter("/adminManage.html")//后缀名匹配
public class AdminManageFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("admin");
        //没登录
        if (admin == null) {
            response.sendRedirect("/adminLogin.html");
        } else {
            System.out.println("管理员已登入，用户名" + admin.getUserName());
            //让程序继续往下访问用户的目标资源
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
