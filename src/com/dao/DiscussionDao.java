package com.dao;

import com.entity.Discussion;

import java.util.List;

/**
 * 作者：林星源
 * 日期: 2021/3/23 20:57
 * 描述:
 */
public interface DiscussionDao {

    //新增公告
    int insertDiscussion(Discussion discussion);

    //修改公告
    int updateDiscussion(Discussion discussion);

    int deleteDiscussion(Integer discussionId);

    int deleteDiscussion(String discussionUser, String discussionContent);

    int updateDiscussionColumnValue(Integer discussionId, String columnName, String columnValue);
    //根据id搜索公告
    Discussion queryDiscussionById(Integer discussionId);

    //根据标题搜索公告
    Discussion queryDiscussionByHead(String discussionHead);

    //根据用户user搜索公告
    Discussion queryDiscussionByUser(String discussionUser);

    Discussion queryDiscussionByTime();

    //分页专用
    Integer queryPageTotalCounts();

    List<Discussion> queryDiscussionByPage(Integer pageNo, Integer pageSize);

    List<Discussion> queryAllDiscussion();

    List<Discussion> queryAllDiscussion(String discussionHead, String discussionContent, String discussionUser);

    List<Discussion> queryDiscussion();

}
