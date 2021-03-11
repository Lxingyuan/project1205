package com.servlet;

import com.entity.FavouriteTool;
import com.entity.Tool;
import com.google.gson.Gson;
import com.service.FavouriteToolService;
import com.service.ToolService;
import com.service.UserService;
import com.service.impl.FavouriteToolServiceImpl;
import com.service.impl.ToolServiceImpl;
import com.service.impl.UserServiceImpl;
import com.utils.Page;
import com.utils.Page2;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * 作者：林星源
 * 日期: 2020/12/1 16:08
 * 描述:用户执行操作
 * Win10
 */
@WebServlet("/tool.do")
public class ToolServlet extends BaseServlet {
    ToolService toolService = new ToolServiceImpl();
    FavouriteToolService favouriteToolService =new FavouriteToolServiceImpl();
    UserService userService=new UserServiceImpl();
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


    public void queryToolList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Integer pageNo = Integer.valueOf(request.getParameter("pageNo"));
        Page2<Tool> page = toolService.queryToolByPage2();
        System.out.println("page:" + page);
        Gson gson = new Gson();
        //转成字符串
        String jsonStr = gson.toJson(page);
        //写入返回信息
        response.getWriter().write(jsonStr);
    }
    public void deleteToolById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String toolId = request.getParameter("toolId");
        Integer result = toolService.deleteTool(Integer.parseInt(toolId));
        if (result < 0) {
            response.getWriter().write("false");
        } else {
            response.getWriter().write("true");
        }
    }
    public void deleteTool(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] idNum = request.getParameterValues("idNum[]");
        boolean flag = true;
        Integer result;
        //String idNum2 = request.getParameter("idNum");
        //System.out.println("idNum:"+idNum2);
        for (int i = 0; i < idNum.length; i++) {
            //System.out.print(idNum[i]+" ");
            result = toolService.deleteTool(Integer.parseInt(idNum[i]));
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

    public void updateTool(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String toolId = request.getParameter("toolId");
        //要更新的字段名
        String columnName = request.getParameter("columnName");
        //要更新的字段值
        String columnValue = request.getParameter("columnValue");
        //System.out.println("columnValue替换前:"+columnValue);
        //columnValue=columnValue.replace("'", "\\'");
        //columnValue=columnValue.replace("\"", "\\\"");
        columnValue = columnValue.replace("\\", "\\\\");
        //System.out.println("columnValue替换后:"+columnValue);
        System.out.println(toolId + " " + columnName + " " + columnValue);
        Integer result = toolService.updateToolColumnValue(Integer.parseInt(toolId), columnName, columnValue);
        if (result < 0) {
            response.getWriter().write("false");
        } else {
            response.getWriter().write("true");
        }
    }

    /**
     * 限定条件查询
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void queryToolListLimit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //电影名称
        String toolName = request.getParameter("toolName");
        //电影类型
        String type = request.getParameter("type");
        //主演
        String protagonist = request.getParameter("protagonist");
        //上映年份
        String showTime = request.getParameter("showTime");
        //System.out.println("|toolName:"+toolName+"|type:"+type+"|protagonist:"+protagonist+"|showTime:"+showTime+"|");
        Page2<Tool> page = toolService.queryToolByPage2(toolName, type, protagonist, showTime);
        System.out.println("page2:" + page);
        Gson gson = new Gson();
        //转成字符串
        String jsonStr = gson.toJson(page);
        //写入返回信息
        response.getWriter().write(jsonStr);
    }

    public void queryToolPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Integer pageNo = Integer.valueOf(request.getParameter("pageNo"));
        Page<Tool> page = toolService.queryToolByPage(pageNo, Page.PAGE_SIZE);
        Gson gson = new Gson();
        String jsonStr = gson.toJson(page);
        response.getWriter().write(jsonStr);
    }

    public void addTool(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Tool tool = new Tool();
        tool.setHits(0);
        tool.setDownloadAddr("/static/images/2.jpg");
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
                        if ("toolName".equals(fileItem.getFieldName())) {
                            tool.setToolName(fileItem.getString("UTF-8"));
                        } else if ("type".equals(fileItem.getFieldName())) {
                            tool.setType(fileItem.getString("UTF-8"));
                        } else if ("director".equals(fileItem.getFieldName())) {
                            tool.setDirector(fileItem.getString("UTF-8"));
                        } else if ("protagonist".equals(fileItem.getFieldName())) {
                            tool.setProtagonist(fileItem.getString("UTF-8"));
                        } else if ("showTime".equals(fileItem.getFieldName())) {
                            tool.setShowTime(fileItem.getString("UTF-8"));
                        } else if ("content".equals(fileItem.getFieldName())) {
                            tool.setContent(fileItem.getString("UTF-8"));
                        }
                    } else {
                        //上传的文件
                        System.out.println("文件项的name:" + fileItem.getFieldName());
                        System.out.println("上传的文件名:" + fileItem.getName());
                        Long time = System.currentTimeMillis();
                        fileItem.write(new File("D:\\project1205\\images\\" + time + fileItem.getName()));
                        //要保存时到数据库的文件名
                        String fileName = "http://localhost:8765/images\\" + time + fileItem.getName();
                        tool.setPicAddress(fileName);
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Integer result = toolService.insertTool(tool);
        //System.out.println("result:" + result);
        if (result > 0) {
            response.getWriter().write("true");
        } else {
            response.getWriter().write("false");
        }
    }

    public void queryToolById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String toolId = request.getParameter("toolId");
        Tool tool = toolService.queryToolById(Integer.parseInt(toolId));
        if (tool == null) {
            response.getWriter().write("false");
        } else {
            response.getWriter().write("true");
        }
    }

    public void queryToolByHits(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        List<Tool> list = toolService.queryToolByHits();
        Page2<Tool> page = new Page2<>();
        page.setCode(0);
        page.setMsg("");
        page.setCount(list.size());
        page.setData(list);
        Gson gson = new Gson();
        String jsonStr = gson.toJson(page);
        response.getWriter().write(jsonStr);
//        System.out.println("jsonStr:"+jsonStr);
    }

    public void queryToolByVoteNum(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        List<Tool> list = toolService.queryToolByVoteNum();
        Page2<Tool> page = new Page2<>();
        page.setCode(0);
        page.setMsg("");
        page.setCount(list.size());
        page.setData(list);
        Gson gson = new Gson();
        String jsonStr = gson.toJson(page);
        response.getWriter().write(jsonStr);
//        System.out.println("jsonStr:"+jsonStr);
    }

    public void queryToolByToolId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Integer toolId = Integer.valueOf(request.getParameter("toolId"));
        System.out.println(toolId);
        Tool toolObj = toolService.queryToolById(toolId);
        System.out.println(toolObj);
        Gson gson = new Gson();
        String jsonStr = gson.toJson(toolObj);
        response.getWriter().write(jsonStr);
    }

    /**
     * 查找某个用户的喜欢列表
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void queryToolPageLimit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        //System.out.println(userName);
        List<FavouriteTool> list = favouriteToolService.queryFavouriteTool(userName);
        List<Tool> toolList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            //System.out.println(list.get(i).getToolId());
            toolList.add(toolService.queryToolById(list.get(i).getToolId()));
        }
        Page2<Tool> page = new Page2<>();
        page.setCode(0);
        page.setMsg("");
        page.setCount(toolList.size());
        page.setData(toolList);
        //System.out.println(toolList);
        Gson gson = new Gson();
        String jsonStr = gson.toJson(page);
        response.getWriter().write(jsonStr);
        //System.out.println(list);
    }

    public void addToolHits(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int toolId = Integer.parseInt(request.getParameter("toolId"));
        int hits= toolService.addToolHits(toolId);
        System.out.println("hits="+hits);
        Gson gson = new Gson();
        String jsonStr = gson.toJson(hits);
        response.getWriter().write(jsonStr);
    }



    public void addToolVote(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String string=request.getParameter("string");
        String userName=request.getParameter("userName");
        String [] strings=string.split(",");
        Integer result=0;
        for(int i = 0; i < strings.length; i++){
            //System.out.println(strings[i]);
            result= toolService.addToolVote(Integer.parseInt(strings[i]));
            if(result<0){
                break;
            }
        }
        if(result<0){
            response.getWriter().write("false");
        }else {
            Integer result2=userService.setUserVoteIsTrue(userName);
            if(result2<0){
                response.getWriter().write("false");
            }else {
                response.getWriter().write("true");
            }

        }
    }
    public void searchTool(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchMessage=request.getParameter("searchMessage");
        List<Tool> list = toolService.searchTool(searchMessage);
        Page2<Tool> page = new Page2<>();
        page.setCode(0);
        page.setMsg("");
        page.setCount(list.size());
        page.setData(list);
        //System.out.println(toolList);
        Gson gson = new Gson();
        String jsonStr = gson.toJson(page);
        response.getWriter().write(jsonStr);
    }

}
