package com.service.impl;

import com.dao.NoticeDao;
import com.dao.impl.NoticeDaoImpl;
import com.entity.Notice;
import com.service.NoticeService;
import com.utils.Page;
import com.utils.Page2;

import java.util.List;

/**
 * 作者：林星源
 * 日期: 2020/12/14 20:34
 * 描述:
 */
public class NoticeServiceImpl implements NoticeService {

    NoticeDao noticeDao = new NoticeDaoImpl();

    @Override
    public int insertNotice(Notice notice) {
        return noticeDao.insertNotice(notice);
    }

    @Override
    public int updateNotice(Notice notice) {
        return noticeDao.updateNotice(notice);
    }

    @Override
    public int deleteNotice(Integer noticeId) {
        return noticeDao.deleteNotice(noticeId);
    }

    @Override
    public Notice queryNoticeById(Integer noticeId) {
        return noticeDao.queryNoticeById(noticeId);
    }

    @Override
    public Notice queryNoticeByHead(String noticeHead) {
        return noticeDao.queryNoticeByHead(noticeHead);
    }

    @Override
    public Notice queryNoticeByUser(String noticeUser) {
        return noticeDao.queryNoticeByUser(noticeUser);
    }

    @Override
    public Page<Notice> queryNoticeByPage(int pageNo, int pageSize) {
        Page<Notice> page = new Page<>();
        //设置当前页码
        page.setPageNo(pageNo);
        //设置页面大小
        page.setPageSize(pageSize);
        //求总记录数
        Integer pageTotalCount = noticeDao.queryPageTotalCounts();
        //设置总记录数
        page.setPageTotalCount(pageTotalCount);
        //求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal += 1;
        }
        //设置总页码
        page.setPageTotal(pageTotal);
        //求开始页码
        int begin = (page.getPageNo() - 1) * pageSize;
        //获取开始页码的分页数据
        List<Notice> items = noticeDao.queryNoticeByPage(begin, pageSize);
        //设置数据
        page.setItems(items);
        return page;
    }

    public Page2<Notice> queryNoticeByPage2() {
        Page2<Notice> page = new Page2<>();
        page.setCode(0);
        page.setMsg("");
        //求总记录数
        Integer pageTotalCount = noticeDao.queryPageTotalCounts();
        page.setCount(pageTotalCount);
        page.setData(noticeDao.queryAllNotice());
        return page;
    }

    @Override
    public Page2<Notice> queryNoticeByPage2(String noticeHead,String noticeContent,String noticeUser) {
        Page2<Notice> page = new Page2<>();
        page.setCode(0);
        page.setMsg("");
        System.out.println("2");
        List<Notice> list = noticeDao.queryAllNotice(noticeHead, noticeContent, noticeUser);
        page.setData(list);
        page.setCount(list.size());
        return page;
    }

    @Override
    public int updateNoticeColumnValue(Integer noticeId, String columnName, String columnValue) {
        return noticeDao.updateNoticeColumnValue(noticeId, columnName, columnValue);
    }
}
