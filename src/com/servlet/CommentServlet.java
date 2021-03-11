package com.servlet;

import com.entity.Comment;
import com.google.gson.Gson;
import com.service.CommentService;
import com.service.impl.CommentServiceImpl;
import com.utils.Page2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 作者：林星源
 * 日期: 2020/12/16 10:19
 * 描述:
 */
@WebServlet("/comment.do")
public class CommentServlet extends BaseServlet {
    CommentService commentService = new CommentServiceImpl();

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

    public void queryCommentList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Integer pageNo = Integer.valueOf(request.getParameter("pageNo"));
        Page2<Comment> page = commentService.queryCommentByPage2();
        System.out.println("page:" + page);
        Gson gson = new Gson();
        //转成字符串
        String jsonStr = gson.toJson(page);
        //写入返回信息
        response.getWriter().write(jsonStr);
    }

    public void deleteComment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] idNum = request.getParameterValues("idNum[]");
        boolean flag = true;
        Integer result;
        //String idNum2 = request.getParameter("idNum");
        //System.out.println("idNum:"+idNum2);
        for (int i = 0; i < idNum.length; i++) {
            //System.out.print(idNum[i]+" ");
            result = commentService.deleteComment(Integer.parseInt(idNum[i]));
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

    public void updateComment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String commentId = request.getParameter("commentId");
        //要更新的字段名
        String columnName = request.getParameter("columnName");
        //要更新的字段值
        String columnValue = request.getParameter("columnValue");
        columnValue = columnValue.replace("'", "\\'");
        columnValue = columnValue.replace("\"", "\\\"");
        columnValue = columnValue.replace("\\", "\\\\");
        System.out.println(commentId + " " + columnName + " " + columnValue);
        Integer result = commentService.updateCommentColumnValue(Integer.parseInt(commentId), columnName, columnValue);
        if (result < 0) {
            response.getWriter().write("false");
        } else {
            response.getWriter().write("true");
        }
    }

    public void queryCommentListLimit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //公告标题
        String toolName = request.getParameter("toolName");
        //公告内容
        String commentUser = request.getParameter("commentUser");
        //公告创建人
        String commentContent = request.getParameter("commentContent");

        //System.out.println("|toolName:"+toolName+"|type:"+type+"|protagonist:"+protagonist+"|showTime:"+showTime+"|");
        Page2<Comment> page = commentService.queryCommentByPage2(toolName, commentUser, commentContent);
        System.out.println("page2:" + page);
        Gson gson = new Gson();
        //转成字符串
        String jsonStr = gson.toJson(page);
        //写入返回信息
        response.getWriter().write(jsonStr);
    }

    //根据影评创建时间查询
    public void queryCommentByTime(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Comment> list = commentService.queryCommentByTime();
        System.out.println(list);
        Page2<Comment> page = new Page2<>();
        page.setCode(0);
        page.setMsg("");
        page.setCount(list.size());
        page.setData(list);
        Gson gson = new Gson();
        String jsonStr = gson.toJson(page);
        response.getWriter().write(jsonStr);
    }

    public void queryTotalCommentByToolId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer toolId = Integer.valueOf(request.getParameter("toolId"));
        int totalNum = commentService.queryTotalCommentByToolId(toolId);
        Gson gson = new Gson();
        String jsonStr = gson.toJson(totalNum);
        response.getWriter().write(jsonStr);

    }

    public void queryCommentByToolId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer toolId = Integer.valueOf(request.getParameter("toolId"));
        List<Comment> comments = commentService.queryCommentByToolId(toolId);
        Page2<Comment> page = new Page2<>();
        page.setCode(0);
        page.setMsg("");
        page.setCount(comments.size());
        page.setData(comments);
        System.out.println(page);
        Gson gson = new Gson();
        String jsonStr = gson.toJson(page);
        response.getWriter().write(jsonStr);
    }

    public void addToolComment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer toolId = Integer.valueOf(request.getParameter("toolId"));
        String username = request.getParameter("username");
        String commentContent = request.getParameter("commentContent");
        System.out.println("toolId=" + toolId + " username=" + username + "comment=" + commentContent);

        Comment comment1 = new Comment();
        comment1.setToolId(toolId);
        comment1.setCommentUser(username);
        comment1.setCommentContent(commentContent);
        if ("".equals(username)) {
            response.getWriter().write("false");
        } else {
            Integer result = commentService.addToolComment(comment1);
            if (result < 0) {
                response.getWriter().write("false");
            } else {
                response.getWriter().write("true");
            }
        }
    }
    public void deleteComment2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String toolId = request.getParameter("toolId");
        String commentUser = request.getParameter("commentUser");
        Integer result=commentService.deleteComment(Integer.parseInt(toolId),commentUser);
        if (result < 0) {
            response.getWriter().write("false");
        } else {
            response.getWriter().write("true");
        }
    }
}
