package com.dao;

import com.entity.Message;

import java.util.List;

/**
 * 作者：林星源
 * 日期: 2020/12/9 11:29
 * 描述:
 */
public interface MessageDao {
    int insert(Message message);

    int update(Message message);

    int delete(Integer id);

    List<Message> queryAll();

    //根据id查询邮件详情
    Message queryMessageById(Integer id);

    //根据收信人id查询邮件
    List<Message> queryMessageByToUid(Integer id);


}
