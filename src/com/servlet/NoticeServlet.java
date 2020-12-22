package com.servlet;

import com.entity.Notice;
import com.google.gson.Gson;
import com.service.NoticeService;
import com.service.impl.NoticeServiceImpl;
import com.utils.Page2;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

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
    public void updateNotice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String noticeId=request.getParameter("noticeId");
        //要更新的字段名
        String columnName=request.getParameter("columnName");
        //要更新的字段值
        String columnValue=request.getParameter("columnValue");
        columnValue=columnValue.replace("'", "\\'");
        columnValue=columnValue.replace("\"", "\\\"");
        columnValue=columnValue.replace("\\", "\\\\");
        System.out.println(noticeId+" "+columnName+" "+columnValue);
        Integer result=noticeService.updateNoticeColumnValue(Integer.parseInt(noticeId),columnName,columnValue);
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
    public void queryNoticeListLimit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //公告标题
        String noticeHead=request.getParameter("noticeHead");
        //公告内容
        String noticeContent=request.getParameter("noticeContent");
        //公告创建人
        String noticeUser=request.getParameter("noticeUser");

        //System.out.println("|movieName:"+movieName+"|type:"+type+"|protagonist:"+protagonist+"|showTime:"+showTime+"|");
        Page2<Notice> page = noticeService.queryNoticeByPage2(noticeHead,noticeContent,noticeUser);
        System.out.println("page2:"+page);
        Gson gson = new Gson();
        //转成字符串
        String jsonStr = gson.toJson(page);
        //写入返回信息
        response.getWriter().write(jsonStr);
    }

    public void addNotice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Notice notice=new Notice();
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
                        if("noticeHead".equals(fileItem.getFieldName())){
                            notice.setNoticeHead(fileItem.getString("UTF-8"));
                        }else if("noticeContent".equals(fileItem.getFieldName())) {
                            notice.setNoticeContent(fileItem.getString("UTF-8"));
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
            if (cookie.getName().equals("adminName")) {
                notice.setNoticeUser(cookie.getValue());
            }
        }
        System.out.println(notice.getNoticeUser());
        Integer result=noticeService.insertNotice(notice);
        System.out.println("result:"+result);
        if(result>0){
            response.getWriter().write("true");
        }else {
            response.getWriter().write("false");
        }
    }
}
