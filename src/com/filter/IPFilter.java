package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

@WebFilter("/ip.jsp")
public class IPFilter implements Filter {
    private ServletContext servletContext;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //1.强转
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        //2.获取IP地址
        String ip = request.getRemoteAddr();
        Map<String, Integer> map = (Map<String, Integer>) servletContext.getAttribute("ipCountMap");
        Integer count = map.get(ip);
        if (count == null) {
            count = 1;
        } else {
            count += 1;
        }
        map.put(ip, count);
        servletContext.setAttribute("ipCountMap", map);
        //放行
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        //对servletContext进行初始化
        servletContext = config.getServletContext();
        //键：IP地址  值：次数
        Map<String, Integer> ipCountMap = new LinkedHashMap<String, Integer>();
        servletContext.setAttribute("ipCountMap", ipCountMap);
    }

}
