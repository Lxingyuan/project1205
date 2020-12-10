package com.service.impl;

import com.dao.MessageDao;
import com.dao.impl.MessageImpl;
import com.entity.Message;
import com.service.MessageSerive;

import java.util.List;

/**
 * 作者：林星源
 * 日期: 2020/12/9 15:31
 * 描述:
 */
public class MessageSeriveImpl implements MessageSerive {
    MessageDao messageDao = new MessageImpl();

    public List<Message> queryMessageByToUid(Integer id) {
        return messageDao.queryMessageByToUid(id);
    }

    public Message queryMessageById(Integer id) {
        return messageDao.queryMessageById(id);
    }

    public int delete(Integer id) {
        return messageDao.delete(id);
    }

    public int insert(Message message) {
        return messageDao.insert(message);
    }

    public int update(Message message) {
        return messageDao.update(message);
    }
}
