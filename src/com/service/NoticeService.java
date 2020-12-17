package com.service;

import com.entity.Notice;
import com.utils.Page;

import java.util.List;

/**
 * 作者：林星源
 * 日期: 2020/12/14 20:33
 * 描述:
 */
public interface NoticeService {
    int insertNotice(Notice notice);

    //修改公告
    int updateNotice(Notice notice);

    //根据id搜索公告
    Notice queryNoticeById(Integer id);

    //根据标题搜索公告
    Notice queryNoticeByHead(String noticeHead);

    //根据用户user搜索公告
    Notice queryNoticeByUser(String noticeUser);

    Page<Notice> queryNoticeByPage(int pageNo, int pageSize);
}
