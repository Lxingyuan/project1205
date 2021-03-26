package com.service;

import com.entity.Discussion;
import com.utils.Page;
import com.utils.Page2;

import java.util.List;

/**
 * 作者：林星源
 * 日期: 2021/3/24 12:54
 * 描述:
 */
public interface DiscussionService {

    int insertDiscussion(Discussion discussion);

    //修改公告
    int updateDiscussion(Discussion discussion);

    List<Discussion> queryDiscussion();

    int deleteDiscussion(Integer discussionId);

    int deleteDiscussion(String discussionUser,String discussionContent);

    //根据id搜索公告
    Discussion queryDiscussionById(Integer id);

    //根据标题搜索公告
    Discussion queryDiscussionByHead(String discussionHead);

    //根据用户user搜索公告
    Discussion queryDiscussionByUser(String discussionUser);

    Discussion queryDiscussionByTime();

    Page<Discussion> queryDiscussionByPage(int pageNo, int pageSize);

    Page2<Discussion> queryDiscussionByPage2();

    Page2<Discussion> queryDiscussionByPage2(String discussionHead,String discussionContent,String discussionUser);

    int updateDiscussionColumnValue(Integer discussionId,String columnName,String columnValue);

}
