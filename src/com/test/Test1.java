package com.test;

import com.aliyuncs.exceptions.ClientException;
import com.utils.SmsUtil;
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
}
