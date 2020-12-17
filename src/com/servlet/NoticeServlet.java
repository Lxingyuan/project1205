package com.servlet;

import com.entity.Notice;
import com.google.gson.Gson;
import com.service.NoticeService;
import com.service.impl.NoticeServiceImpl;
import com.utils.Page2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 作者：林星源
 * 日期: 2020/12/16 16:03
 * 描述:
 */
@WebServlet("/notice.do")
public class NoticeServlet extends BaseServlet {
    NoticeService noticeService=new NoticeServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        super.doGet(request, response);
    }
    public void queryNoticeList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Integer pageNo = Integer.valueOf(request.getParameter("pageNo"));
        Page2<Notice> page = noticeService.queryNoticeByPage2();
        System.out.println("page:"+page);
        Gson gson = new Gson();
        //转成字符串
        String jsonStr = gson.toJson(page);
        //写入返回信息
        response.getWriter().write(jsonStr);
    }
    public void deleteNotice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] idNum=request.getParameterValues("idNum[]");
        boolean flag=true;
        Integer result;
        //String idNum2 = request.getParameter("idNum");
        //System.out.println("idNum:"+idNum2);
        for (int i = 0; i <idNum.length ; i++) {
            //System.out.print(idNum[i]+" ");
            result=noticeService.deleteNotice(Integer.parseInt(idNum[i]));
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
