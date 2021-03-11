package com.filter;

/**
 * @author ：liuyuntao
 * @date ：Created in 2020/12/21 15:11
 */
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Error404Filter implements Filter {

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse rep,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) rep;
        Error404ResponseWrapper responseWrapper = new Error404ResponseWrapper(response);
        chain.doFilter(request, responseWrapper);
        if (responseWrapper.isFound()) {
            return;
        }
        //String uri = request.getRequestURI();
        //System.out.println(uri);
        Cookie[] cookies = request.getCookies();
        boolean flag=false;
        for (Cookie cookie: cookies) {
            if (cookie.getName().equals("adminName")) {
                //response.sendRedirect("/views/ToolNoFound.html");
                flag=true;
                break;
            }
        }
        if(flag==true){
            response.sendRedirect("/views/ToolNoFound.html");
        }else {
            response.sendRedirect("/views/ToolNoFound2.html");
        }

    }
}
