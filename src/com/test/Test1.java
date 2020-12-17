package com.test;

import com.aliyuncs.exceptions.ClientException;
import com.utils.SmsUtil;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

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
        String sql = "SELECT * FROM movie WHERE movieName LIKE '%' AND type LIKE '%' AND protagonist LIKE '%' AND showTime LIKE '%'";
        String movieName = "";
        String type = "";
        String protagonist = "葛优";
        String showTime = "";
        if(StringUtils.isNotEmpty(movieName)){
            String string="movieName LIKE '%"+movieName+"%'";
            sql=sql.replace("movieName LIKE '%'",string);
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
}
