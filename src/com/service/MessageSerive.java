package com.service;

import com.entity.Message;

import java.util.List;

/**
 * 作者：林星源
 * 日期: 2020/12/9 15:31
 * 描述:
 */
public interface MessageSerive {
    //根据收信人id查询邮件
    List<Message> queryMessageByToUid(Integer id);

    //根据id查询邮件详情
    Message queryMessageById(Integer id);

    //根据id删除
    int delete(Integer id);

    int insert(Message message);


    int update(Message message);
}
