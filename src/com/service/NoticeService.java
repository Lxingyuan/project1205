package com.service;

import com.entity.Notice;
import com.utils.Page;
import com.utils.Page2;

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

    int deleteNotice(Integer noticeId);

    //根据id搜索公告
    Notice queryNoticeById(Integer id);

    //根据标题搜索公告
    Notice queryNoticeByHead(String noticeHead);

    //根据用户user搜索公告
    Notice queryNoticeByUser(String noticeUser);

    Notice queryNoticeByTime();

    Page<Notice> queryNoticeByPage(int pageNo, int pageSize);

    Page2<Notice> queryNoticeByPage2();

    Page2<Notice> queryNoticeByPage2(String noticeHead,String noticeContent,String noticeUser);

    int updateNoticeColumnValue(Integer noticeId,String columnName,String columnValue);
}
