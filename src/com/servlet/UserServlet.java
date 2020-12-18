package com.servlet;

import com.aliyuncs.exceptions.ClientException;
import com.entity.Admin;
import com.google.gson.Gson;
import com.entity.User;
import com.service.AdminService;
import com.service.UserService;
import com.service.impl.AdminServiceImpl;
import com.service.impl.UserServiceImpl;
import com.utils.Page;
import com.utils.Page2;
import com.utils.SmsUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        System.out.println("UserServlet:user:" + user);
        System.out.println("UserServlet:admin:" + admin);
        if (user != null) {
            //登录成功
            response.getWriter().write("true");
            request.getSession().setAttribute("user", user);
        } else if(admin!=null){
            response.getWriter().write("true");
            request.getSession().setAttribute("admin", admin);
        }
        else {
            response.getWriter().write("false");
        }
    }
    public void queryUserList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Integer pageNo = Integer.valueOf(request.getParameter("pageNo"));
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
        //System.out.println("|movieName:"+movieName+"|type:"+type+"|protagonist:"+protagonist+"|showTime:"+showTime+"|");
        Page2<User> page = userService.queryUserByPage2(userName,telephone,qq,email);
        System.out.println("page2:"+page);
        Gson gson = new Gson();
        //转成字符串
        String jsonStr = gson.toJson(page);
        //写入返回信息
        response.getWriter().write(jsonStr);
    }
}
