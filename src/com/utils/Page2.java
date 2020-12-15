package com.utils;

import java.util.List;

/**
 * @author ：liuyuntao
 * @date ：Created in 2020/12/14 19:41
 */
public class Page2<T> {
    public static final Integer PAGE_SIZE = 5;
    private Integer code;
    private String msg;
    private Integer count;
    private List<T> data;

    @Override
    public String toString() {
        return "{" +
                "code:" + code +
                ", msg:'" + msg + '\'' +
                ", count:" + count +
                ", data:" + data +
                '}';
    }

    public Page2() {
    }

    public Page2(Integer code, String msg, Integer count, List<T> data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public static Integer getPageSize() {
        return PAGE_SIZE;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
