package com.test;

import com.aliyuncs.exceptions.ClientException;
import com.dao.ToolDao;
import com.dao.ToolScoreDao;
import com.dao.UserDao;
import com.dao.impl.ToolDaoImpl;
import com.dao.impl.ToolScoreDaoImpl;
import com.dao.impl.UserDaoImpl;
import com.entity.Tool;
import com.entity.ToolScore;
import com.entity.User;
import com.service.ToolService;
import com.service.UserService;
import com.service.impl.ToolServiceImpl;
import com.service.impl.UserServiceImpl;
import com.utils.Page;
import com.utils.SmsUtil;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import javax.swing.*;

/**
 * @author ：liuyuntao
 * @date ：Created in 2020/12/9 19:55
 */

public class Test1 {
    @Test
    public void t1() throws ClientException {
        SmsUtil.sendSms("15277323599","1234");
    }
    @Test
    public void t2() throws ClientException {
       /* System.out.println("'text'".replaceAll("'","\\\\\'"));
        System.out.println("\"".replaceAll("\"","\\\\\""));*/
        String ss ="'test'";
        ss = ss.replace("'", "\\'");
        System.out.println(ss);

        String ss2 ="\"test\"";
        ss2 = ss2.replace("\"", "\\\"");
        System.out.println(ss2);

        String ss3 ="\\test\\";
        ss3 = ss3.replace("\\", "\\\\");
        System.out.println(ss3);
    }
    @Test
    public void test() {
        String sql = "SELECT * FROM tool WHERE toolName LIKE '%' AND type LIKE '%' AND protagonist LIKE '%' AND showTime LIKE '%'";
        String toolName = "";
        String type = "";
        String protagonist = "葛优";
        String showTime = "";
        if(StringUtils.isNotEmpty(toolName)){
            String string="toolName LIKE '%"+toolName+"%'";
            sql=sql.replace("toolName LIKE '%'",string);
        }
        if(StringUtils.isNotEmpty(type)){
            String string="type LIKE '%"+type+"%'";
            sql=sql.replace("type LIKE '%'",string);
        }
        if(StringUtils.isNotEmpty(protagonist)){
            String string="protagonist LIKE '%"+protagonist+"%'";
            sql=sql.replace("protagonist LIKE '%'",string);
        }
        if(StringUtils.isNotEmpty(showTime)){
            String string="showTime LIKE '"+showTime+"'";
            sql=sql.replace("showTime LIKE '%'",string);
        }
        System.out.println(sql);
    }

    ToolDao toolDao =new ToolDaoImpl();
    ToolService toolService = new ToolServiceImpl();
    UserDao userDao = new UserDaoImpl();
    UserService userService = new UserServiceImpl();
    ToolScoreDao toolScore=new ToolScoreDaoImpl();
    @Test
    public void test2(){
        Tool toolObj = toolService.queryToolById(1);
        System.out.println(toolObj.toString());
    }
    
    @Test
    public void test3(){
        Object f=toolScore.toolScore("1");
        System.out.println(f);

    }

}
