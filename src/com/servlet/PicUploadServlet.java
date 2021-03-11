package com.servlet;

import com.service.AdminService;
import com.service.ToolService;
import com.service.UserService;
import com.service.impl.AdminServiceImpl;
import com.service.impl.ToolServiceImpl;
import com.service.impl.UserServiceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet("/picUpload")
public class PicUploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        //要更新的表名
        String tableName = "";
        //列名
        String columnName = "";
        //id
        String id = "";
        //文件名
        String fileName = "";
        //1 先判断上传的数据是否多段数据 （只有是多段的数据，才是文件上传的）
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
                        System.out.println("普通表单项 name:" + fileItem.getFieldName());
                        //参数UTF-8解决乱码
                        System.out.println("value = " + fileItem.getString("UTF-8"));
                        if ("id".equals(fileItem.getFieldName())) {
                            id = fileItem.getString("UTF-8");
                        } else if ("tableName".equals(fileItem.getFieldName())) {
                            tableName = fileItem.getString("UTF-8");
                        } else if ("columnName".equals(fileItem.getFieldName())) {
                            columnName = fileItem.getString("UTF-8");
                        }
                    } else {
                        //上传的文件
                        //System.out.println("表单项的name:" + fileItem.getFieldName());
                        System.out.println("上传的文件名:" + fileItem.getName());
                        Long time=System.currentTimeMillis();
                        fileItem.write(new File("D:\\project1205\\images\\" + time + fileItem.getName()));
                        //要保存时到数据库的文件名
                        fileName = "http://localhost:8765/images\\\\" + time + fileItem.getName();

                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //要更新的是tool表
        if ("tool".equals(tableName)) {
            ToolService toolService = new ToolServiceImpl();
            Integer result = toolService.updateToolColumnValue(Integer.parseInt(id), columnName, fileName);
            if (result > 0) {
                response.getWriter().write("true");
            } else {
                response.getWriter().write("false");
            }
        }
        if ("user".equals(tableName)) {
            UserService userService = new UserServiceImpl();
            Integer result = userService.updateUserColumnValue(Integer.parseInt(id), columnName, fileName);
            if (result > 0) {
                response.getWriter().write("true");
            } else {
                response.getWriter().write("false");
            }
        }
        if ("admin".equals(tableName)) {
            AdminService adminService=new AdminServiceImpl();
            Integer result = adminService.updateUserColumnValue(Integer.parseInt(id), columnName, fileName);
            if (result > 0) {
                response.getWriter().write("true");
            } else {
                response.getWriter().write("false");
            }
        }
    }

}
