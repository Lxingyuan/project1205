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
        SmsUtil.sendSms("18805026635","1234");
    }
}
