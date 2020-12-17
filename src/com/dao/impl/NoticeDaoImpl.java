package com.dao.impl;

import com.dao.BaseDao;
import com.dao.NoticeDao;
import com.entity.Notice;
import com.utils.Page2;

import java.util.List;

/**
 * 作者：林星源
 * 日期: 2020/12/14 20:11
 * 描述:
 */
public class NoticeDaoImpl extends BaseDao implements NoticeDao {
    @Override
    public int insertNotice(Notice notice) {
        String sql = "insert into notice (NoticeId,NoticeHead,NoticeContent,NoticeUser)values(?,?,?,?)";
        return update(sql, notice.getNoticeId(), notice.getNoticeHead(), notice.getNoticeContent(), notice.getNoticeUser());
    }

    @Override
    public int updateNotice(Notice notice) {
        String sql = "update notice set NoticeHead=?,NoticeContent=?,NoticeUser=? where NoticeId = ?";
        return update(sql, notice.getNoticeHead(), notice.getNoticeContent(), notice.getNoticeUser(), notice.getNoticeId());
    }

    @Override
    public int deleteNotice(Integer noticeId) {
        String sql = "delete from notice where NoticeId = ?";
        return update(sql, noticeId);
    }

    @Override
    public Notice queryNoticeById(Integer noticeId) {
        String sql = "select * from notice where NoticeId=?";
        return queryForOne(Notice.class, sql, noticeId);
    }

    @Override
    public Notice queryNoticeByHead(String noticeHead) {
        String sql = "select * from notice where NoticeHead=?";
        return queryForOne(Notice.class, sql, noticeHead);
    }

    @Override
    public Notice queryNoticeByUser(String noticeUser) {
        String sql = "select * from notice where NoticeUser=?";
        return queryForOne(Notice.class, sql, noticeUser);
    }

    @Override
    public Integer queryPageTotalCounts() {
        String sql = "select count(1) from notice";
        return Math.toIntExact((Long) queryForSingleValue(sql));
    }

    @Override
    public List<Notice> queryNoticeByPage(Integer begin, Integer pageSize) {
        String sql = "select * from notice limit ?, ?";
        return queryForList(Notice.class, sql, begin, pageSize);
    }
    public List<Notice> queryAllNotice() {
        String sql = "select * from notice";
        return queryForList(Notice.class, sql);
    }
}
