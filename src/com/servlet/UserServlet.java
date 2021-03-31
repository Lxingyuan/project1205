package com.servlet;

import com.aliyuncs.exceptions.ClientException;
import com.entity.Admin;
import com.entity.Tool;
import com.google.gson.Gson;
import com.entity.User;
import com.service.AdminService;
import com.service.UserService;
import com.service.impl.AdminServiceImpl;
import com.service.impl.UserServiceImpl;
import com.utils.Page;
import com.utils.Page2;
import com.utils.SmsUtil;
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
import java.io.File;
import java.io.IOException;
import java.util.List;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * 作者：林星源
 * 日期: 2020/12/1 16:08
 * 描述:用户执行操作
 * Win10
 */
@WebServlet("/user.do")
public class UserServlet extends BaseServlet {
    UserService userService = new UserServiceImpl();
    AdminService adminService = new AdminServiceImpl();
    /**
     * 验证码
     */
    private String code = "";

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

    public void queryPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer pageNo = Integer.valueOf(request.getParameter("pageNo"));
        Page<User> page = userService.queryUserByPage(pageNo, Page.PAGE_SIZE);
        Gson gson = new Gson();
        String jsonStr = gson.toJson(page);
        response.getWriter().write(jsonStr);
    }

    public void queryUserByToolId(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String toolId = request.getParameter("toolId");

        Gson gson = new Gson();
        String jsonStr = gson.toJson(userService.queryUserByToolId(toolId));
        System.out.println("1");
        System.out.println(jsonStr);
        response.getWriter().write(jsonStr);
    }

    /**
     * 通过用户名查询(注册时用户名唯一性判断）
     *
     * @param request
     * @param response
     * @throws IOException
     */
    public void queryUserByUsername(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        User user = userService.queryUserByUsername(username);
        Admin admin = adminService.queryUserByUsername(username);
        String message = ((user == null) && (admin == null)) ? "true" : "false";
        response.getWriter().write(message);
    }

    /**
     * 通过手机号查询(注册时手机号唯一性判断）
     *
     * @param request
     * @param response
     * @throws IOException
     */
    public void queryUserByTelephone(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String telephone = request.getParameter("telephone");
        User user = userService.queryUserByTelephone(telephone);
        String message = (user == null) ? "true" : "false";
        response.getWriter().write(message);
    }

    /**
     * 发送验证码
     *
     * @param request
     * @param response
     * @throws IOException
     * @throws ClientException
     */
    public void sendCode(HttpServletRequest request, HttpServletResponse response) throws IOException, ClientException {
        //String telephone = request.getParameter("telephone");
        //math.random()范围[0.0, 1.0)，那么math.random()*9+1一定是小于10的，*100000一定是<1000000的一个数
        code = Integer.toString((int) ((Math.random() * 9 + 1) * 100000));
        System.out.println("code:" + code);
        //SmsUtil.sendSms(telephone,code);
        response.getWriter().write(code);
    }

    /**
     * 用户注册
     *
     * @param request
     * @param response
     * @throws IOException
     * @throws ClientException
     */
    public void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ClientException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String telephone = request.getParameter("telephone");
        User user = new User(username, password, telephone);
        Integer result = userService.register(user);
        if (result > 0) {
            response.getWriter().write("true");
        } else {
            response.getWriter().write("false");
        }
    }

    /**
     * 用户登录
     *
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     * @throws InterruptedException
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, InterruptedException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.login(new User(username, password));
        Admin admin = adminService.login(new Admin(username, password));
        //System.out.println("UserServlet:user:" + user);
        //System.out.println("UserServlet:admin:" + admin);
        if (user != null) {
            //登录成功
            response.getWriter().write("true");
            request.getSession().setAttribute("user", user);
            //保存cookie
            Cookie cookie = new Cookie("userName",user.getUserName());
            cookie.setMaxAge(60*60);
            response.addCookie(cookie);
        } else if(admin!=null){
            response.getWriter().write("true");
            request.getSession().setAttribute("admin", admin);
            //保存cookie
            Cookie cookie = new Cookie("adminName",admin.getUserName());
            cookie.setMaxAge(60*60);
            response.addCookie(cookie);
        }
        else {
            response.getWriter().write("false");
        }
    }

    /**
     * 用户退出登录
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void userLogOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().removeAttribute("user");
        // 获取Cookies数组
        Cookie[] cookies = request.getCookies();
        // 迭代查找并清除Cookie
        for (Cookie cookie: cookies) {
            if (cookie.getName().equals("userName")) {
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
        response.getWriter().write("true");
    }

    public void queryUserList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Page2<User> page = userService.queryUserByPage2();
        System.out.println("page:"+page);
        Gson gson = new Gson();
        //转成字符串
        String jsonStr = gson.toJson(page);
        //写入返回信息
        response.getWriter().write(jsonStr);
    }


    public void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] idNum=request.getParameterValues("idNum[]");
        boolean flag=true;
        Integer result;
        //String idNum2 = request.getParameter("idNum");
        //System.out.println("idNum:"+idNum2);
        for (int i = 0; i <idNum.length ; i++) {
            //System.out.print(idNum[i]+" ");
            result=userService.deleteUser(Integer.parseInt(idNum[i]));
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

    public void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId=request.getParameter("userId");
        //要更新的字段名
        String columnName=request.getParameter("columnName");
        //要更新的字段值
        String columnValue=request.getParameter("columnValue");
        columnValue=columnValue.replace("'", "\\'");
        columnValue=columnValue.replace("\"", "\\\"");
        columnValue=columnValue.replace("\\", "\\\\");
        System.out.println(userId+" "+columnName+" "+columnValue);
        Integer result=userService.updateUserColumnValue(Integer.parseInt(userId),columnName,columnValue);
        if(result<0){
            response.getWriter().write("false");
        }else {
            response.getWriter().write("true");
        }
    }

    public void updateUserByScore(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId=request.getParameter("userId");
        Integer level= Integer.valueOf(request.getParameter("level"));
        //要更新的字段名
        String columnName=request.getParameter("columnName");
        //要更新的字段值
        String columnValue=request.getParameter("columnValue");
        columnValue=columnValue.replace("'", "\\'");
        columnValue=columnValue.replace("\"", "\\\"");
        columnValue=columnValue.replace("\\", "\\\\");
        System.out.println(userId+" "+level+" "+columnName+" "+columnValue);
        Integer score = Integer.valueOf(columnValue)+1;
        Integer result=userService.scoreUp(Integer.parseInt(userId), score);
        //System.out.println(result);
        Integer result2=userService.levelUp(Integer.parseInt(userId), level, score);
        System.out.println(result2);
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
    public void queryUserListLimit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //用户名
        String userName=request.getParameter("userName");
        //电话号码
        String telephone=request.getParameter("telephone");
        //QQ号
        String qq=request.getParameter("qq");
        //电子邮箱
        String email=request.getParameter("email");
        System.out.println("成功获取信息");
        //System.out.println("|toolName:"+toolName+"|type:"+type+"|protagonist:"+protagonist+"|showTime:"+showTime+"|");
        Page2<User> page = userService.queryUserByPage2(userName,telephone,qq,email);
        System.out.println("page2:"+page);
        Gson gson = new Gson();
        //转成字符串
        String jsonStr = gson.toJson(page);
        //写入返回信息
        response.getWriter().write(jsonStr);
    }

    public void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user=new User();
        if (ServletFileUpload.isMultipartContent(request)) {
            System.out.println("111");
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
                        if("userName".equals(fileItem.getFieldName())){
                            user.setUserName(fileItem.getString("UTF-8"));
                        }else if("userPassword".equals(fileItem.getFieldName())){
                            user.setUserPassword(fileItem.getString("UTF-8"));
                        }else if("sex".equals(fileItem.getFieldName())){
                            user.setSex(fileItem.getString("UTF-8"));
                        }else if("telephone".equals(fileItem.getFieldName())){
                            user.setTelephone(fileItem.getString("UTF-8"));
                        }else if("qq".equals(fileItem.getFieldName())){
                            user.setQq(fileItem.getString("UTF-8"));
                        }else if("email".equals(fileItem.getFieldName())){
                            user.setEmail(fileItem.getString("UTF-8"));
                        }
                    } else {
                        //上传的文件
                        System.out.println("文件项的name:" + fileItem.getFieldName());
                        System.out.println("上传的文件名:" + fileItem.getName());
                        Long time=System.currentTimeMillis();
                        fileItem.write(new File("D:\\project1205\\images\\" + time + fileItem.getName()));
                        //要保存时到数据库的文件名
                        String fileName = "http://localhost:8765/images\\" + time + fileItem.getName();
                        user.setHeadPic(fileName);
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Integer result=userService.insertUser(user);
        System.out.println("result:"+result);
        if(result>0){
            response.getWriter().write("true");
        }else {
            response.getWriter().write("false");
        }
    }

    public void findUserByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName=request.getParameter("userName");
        User user=userService.queryUserByName(userName);
        Gson gson = new Gson();
        String jsonStr = gson.toJson(user);
        response.getWriter().write(jsonStr);
    }

    public void findUserByTelephone(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String telephone=request.getParameter("telephone");
        String userName=request.getParameter("userName");
        User user=userService.queryUserByTelephone(telephone);
        if(user!=null&&(user.getUserName().equals(userName)==false)){
            //与其它用户手机号冲突
            response.getWriter().write("false");
        }else {
            response.getWriter().write("true");
        }
    }
    public void findUserByQQ(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String qq=request.getParameter("qq");
//        System.out.println(qq);
        String userName=request.getParameter("userName");
        User user=userService.queryUserByQQ(Integer.parseInt(qq));
        if(user!=null&&(user.getUserName().equals(userName)==false)){
            //与其它用户冲突
            response.getWriter().write("false");
        }else {
            response.getWriter().write("true");
        }
    }
    public void findUserByEmail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email=request.getParameter("email");
        String userName=request.getParameter("userName");
        User user=userService.queryUserByEmail(email);
        if(user!=null&&(user.getUserName().equals(userName)==false)){
            //与其它用户冲突
            response.getWriter().write("false");
        }else {
            response.getWriter().write("true");
        }
    }

    /**
     * 用户前台修改自己信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void updateUser2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user=new User();
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
                        System.out.println("普通表单项name = " + fileItem.getFieldName());
                        //参数UTF-8解决乱码
                        System.out.println("value = " + fileItem.getString("UTF-8"));
                        if("telephone".equals(fileItem.getFieldName())){
                            user.setTelephone(fileItem.getString("UTF-8"));
                        }else if("QQ".equals(fileItem.getFieldName())){
                            user.setQq(fileItem.getString("UTF-8"));
                        }else if("email".equals(fileItem.getFieldName())){
                            user.setEmail(fileItem.getString("UTF-8"));
                        }else if("sex".equals(fileItem.getFieldName())){
                            user.setSex(fileItem.getString("UTF-8"));
                        }else if("userName".equals(fileItem.getFieldName())){
                            user.setUserName(fileItem.getString("UTF-8"));
                        }
                    } else {
                        //上传的文件
                        System.out.println("文件项的 name:" + fileItem.getFieldName());
                        System.out.println("上传的文件名:" + fileItem.getName());
                        Long time = System.currentTimeMillis();
                        fileItem.write(new File("D:\\project1205\\images\\" + time + fileItem.getName()));
                        //要保存时到数据库的文件名
                        String fileName = "http://localhost:8765/images\\" + time + fileItem.getName();
                        user.setHeadPic(fileName);
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Integer result = userService.updateUser2(user);
        System.out.println("updateUser2result:" + result);
        if (result > 0) {
            response.getWriter().write("true");
        } else {
            response.getWriter().write("false");
        }
    }

    public void updatePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String columnName = request.getParameter("columnName");
        String columnValue = request.getParameter("columnValue");
        Integer result = userService.updateUserColumnValue(Integer.parseInt(id), columnName,columnValue);
        if (result > 0) {
            response.getWriter().write("true");
        } else {
            response.getWriter().write("false");
        }
    }

    public void findUserVoteOrNot(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName=request.getParameter("userName");
        User user=userService.findUserVoteOrNot(userName);
        if(user==null){
            //未投票
            response.getWriter().write("false");
        }else {
            response.getWriter().write("true");
        }
    }

}
