package com.dao;

import com.entity.Notice;

import java.util.List;

/**
 * 作者：林星源
 * 日期: 2020/12/14 19:43
 * 描述:公告
 */
public interface NoticeDao {
    //新增公告
    int insertNotice(Notice notice);

    //修改公告
    int updateNotice(Notice notice);

    int deleteNotice(Integer noticeId);

    //根据id搜索公告
    Notice queryNoticeById(Integer noticeId);

    //根据标题搜索公告
    Notice queryNoticeByHead(String noticeHead);

    //根据用户user搜索公告
    Notice queryNoticeByUser(String noticeUser);

    //分页专用
    Integer queryPageTotalCounts();

    List<Notice> queryNoticeByPage(Integer pageNo, Integer pageSize);

    List<Notice> queryAllNotice();

}
