package com.servlet;

import com.entity.FavouriteTool;
import com.entity.ToolScore;
import com.service.ToolScoreService;
import com.service.impl.ToolScoreServiceImpl;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 作者：林星源
 * 日期: 2021/3/18 17:02
 * 描述:
 */

@WebServlet("/toolScore.do")
public class ToolScoreServlet extends BaseServlet{
    ToolScoreService toolScoreService=new ToolScoreServiceImpl();

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

    public void insertScore(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String toolId = request.getParameter("toolId");
        String score = request.getParameter("score");
        String userName = request.getParameter("userName");
        System.out.println(toolId+" "+score+" "+userName);

        //评分重复判定
        if ("".equals(userName)){
            System.out.println("empty");
            response.getWriter().write("empty");
        }else if (toolScoreService.repeatJudge(userName,toolId)==null&&!("".equals(userName))){
            System.out.println(toolScoreService.repeatJudge(userName,toolId));
            Integer result= toolScoreService.insertScore(new ToolScore(Integer.parseInt(toolId),Integer.parseInt(score),userName));
            if (result > 0) {
                System.out.println(result);
                response.getWriter().write("true");
            } else {
                System.out.println("false");
                response.getWriter().write("false");
            }
        }
    }

    public void queryToolScore(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String userName = request.getParameter("userName");
        List<ToolScore> toolScoreList = toolScoreService.queryToolScore(userName);
        System.out.println(toolScoreList.toString());
        if (toolScoreList!=null){
            response.getWriter().write("null");
        }else {
            response.getWriter().write("full");
        }

    }


}
