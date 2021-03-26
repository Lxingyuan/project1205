package com.servlet;

import com.entity.Discussion;
import com.google.gson.Gson;
import com.service.DiscussionService;
import com.service.impl.DiscussionServiceImpl;
import com.utils.Page;
import com.utils.Page2;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 作者：林星源
 * 日期: 2020/12/16 10:19
 * 描述:
 */
@WebServlet("/discussion.do")
public class DiscussionServlet extends BaseServlet {
    DiscussionService discussionService=new DiscussionServiceImpl();

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
    public void queryDiscussionList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Integer pageNo = Integer.valueOf(request.getParameter("pageNo"));
        Page2<Discussion> page = discussionService.queryDiscussionByPage2();
        System.out.println("page:"+page);
        Gson gson = new Gson();
        //转成字符串
        String jsonStr = gson.toJson(page);
        //写入返回信息
        response.getWriter().write(jsonStr);
    }
    public void deleteDiscussion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] idNum=request.getParameterValues("idNum[]");
        boolean flag=true;
        Integer result;
        //String idNum2 = request.getParameter("idNum");
        //System.out.println("idNum:"+idNum2);
        for (int i = 0; i <idNum.length ; i++) {
            //System.out.print(idNum[i]+" ");
            result=discussionService.deleteDiscussion(Integer.parseInt(idNum[i]));
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
    public void updateDiscussion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String discussionId=request.getParameter("discussionId");
        //要更新的字段名
        String columnName=request.getParameter("columnName");
        //要更新的字段值
        String columnValue=request.getParameter("columnValue");
        columnValue=columnValue.replace("'", "\\'");
        columnValue=columnValue.replace("\"", "\\\"");
        columnValue=columnValue.replace("\\", "\\\\");
        System.out.println(discussionId+" "+columnName+" "+columnValue);
        Integer result=discussionService.updateDiscussionColumnValue(Integer.parseInt(discussionId),columnName,columnValue);
        if(result<0){
            response.getWriter().write("false");
        }else {
            response.getWriter().write("true");
        }
    }

    /**
     * 限定条件查询
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void queryDiscussionListLimit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //公告标题
        String discussionHead=request.getParameter("discussionHead");
        //公告内容
        String discussionContent=request.getParameter("discussionContent");
        //公告创建人
        String discussionUser=request.getParameter("discussionUser");

        //System.out.println("|toolName:"+toolName+"|type:"+type+"|protagonist:"+protagonist+"|showTime:"+showTime+"|");
        Page2<Discussion> page = discussionService.queryDiscussionByPage2(discussionHead,discussionContent,discussionUser);
        System.out.println("page2:"+page);
        Gson gson = new Gson();
        //转成字符串
        String jsonStr = gson.toJson(page);
        //写入返回信息
        response.getWriter().write(jsonStr);
    }

    public void addDiscussion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Discussion discussion=new Discussion();
        if (ServletFileUpload.isMultipartContent(request)) {
            // 创建FileItemFactory 工厂实现类
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            //创建用于解析上传数据的工具类
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            try {
                //解析上传的数据 得到每一个表单项FileItem
                List<FileItem> list = servletFileUpload.parseRequest(request);
                //循环判断，每一个表单项 是普通类型 还是上传的文件
                for (FileItem fileItem :
                        list) {
                    if (fileItem.isFormField()) {
                        //普通表单项
                        System.out.println("普通项 name:" + fileItem.getFieldName());
                        //参数UTF-8解决乱码
                        System.out.println("value = " + fileItem.getString("UTF-8"));
                        if("discussionContent".equals(fileItem.getFieldName())){
                            discussion.setDiscussionContent(fileItem.getString("UTF-8"));
                        }else if ("discussionHead".equals(fileItem.getFieldName())){
                            discussion.setDiscussionHead(fileItem.getString("UTF-8"));
                        }
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Cookie[] cookies=request.getCookies();
        for (Cookie cookie: cookies) {
            if (cookie.getName().equals("userName")) {
                discussion.setDiscussionUser(cookie.getValue());
            }
        }
        System.out.println(discussion.getDiscussionUser());
        Integer result=discussionService.insertDiscussion(discussion);
        System.out.println("result:"+result);
        if(result>0){
            response.getWriter().write("true");
        }else {
            response.getWriter().write("false");
        }
    }
    //根据公告创建时间查询
    public void queryDiscussionByTime(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Discussion discussion =discussionService.queryDiscussionByTime();
        System.out.println(discussion);
        Gson gson = new Gson();
        //转成字符串
        String jsonStr = gson.toJson(discussion);
        //写入返回信息
        response.getWriter().write(jsonStr);
    }

    public void addToolDiscussion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String discussionHead = request.getParameter("discussionHead");
        String username = request.getParameter("username");
        String discussionContent = request.getParameter("discussionContent");
        System.out.println("discussionHead=" + discussionHead + " username=" + username + "discussion=" + discussionContent);

        Discussion discussion = new Discussion();
        discussion.setDiscussionHead(discussionHead);
        discussion.setDiscussionUser(username);
        discussion.setDiscussionContent(discussionContent);
        if ("".equals(username)) {
            response.getWriter().write("false");
        } else {
            Integer result = discussionService.insertDiscussion(discussion);
            if (result < 0) {
                response.getWriter().write("false");
            } else {
                response.getWriter().write("true");
            }
        }
    }

    public void queryDiscussion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Discussion> discussion = discussionService.queryDiscussion();
        System.out.println(discussion.toString());
        Page2<Discussion> page = new Page2<>();
        page.setCode(0);
        page.setMsg("");
        page.setCount(discussion.size());
        page.setData(discussion);
        System.out.println(page);
        Gson gson = new Gson();
        String jsonStr = gson.toJson(page);
        response.getWriter().write(jsonStr);
    }

    public void queryDiscussionPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Integer pageNo = Integer.valueOf(request.getParameter("pageNo"));
        Page<Discussion> page = discussionService.queryDiscussionByPage(pageNo, Page.PAGE_SIZE);
        Gson gson = new Gson();
        String jsonStr = gson.toJson(page);
        response.getWriter().write(jsonStr);
    }

    //管理员删除评论
    public void deleteDiscussion2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String discussionUser = request.getParameter("discussionUser");
        String discussionContent = request.getParameter("discussionContent");
        System.out.println("discussionUser:"+discussionUser+" discussionContent:"+discussionContent);
        Integer result=discussionService.deleteDiscussion(discussionUser,discussionContent);
        if (result < 0) {
            response.getWriter().write("false");
        } else {
            response.getWriter().write("true");
        }
    }
}
