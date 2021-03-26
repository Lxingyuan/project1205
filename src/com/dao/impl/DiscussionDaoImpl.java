package com.dao.impl;

import com.dao.BaseDao;
import com.dao.DiscussionDao;
import com.entity.Discussion;
import com.entity.Discussion;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * 作者：林星源
 * 日期: 2021/3/23 21:05
 * 描述:
 */
public class DiscussionDaoImpl extends BaseDao implements DiscussionDao {
    @Override
    public int insertDiscussion(Discussion discussion) {
        String sql = "insert into discussion (DiscussionHead,DiscussionContent,DiscussionUser)values(?,?,?)";
        return update(sql, discussion.getDiscussionHead(), discussion.getDiscussionContent(), discussion.getDiscussionUser());
    }

    @Override
    public int updateDiscussion(Discussion discussion) {
        String sql = "update discussion set DiscussionHead=?,DiscussionContent=?,DiscussionUser=? where DiscussionId = ?";
        return update(sql, discussion.getDiscussionHead(), discussion.getDiscussionContent(), discussion.getDiscussionUser(), discussion.getDiscussionId());
    }

    @Override
    public int deleteDiscussion(Integer discussionId) {
        String sql = "delete from discussion where DiscussionId = ?";
        return update(sql, discussionId);
    }

    public int deleteDiscussion(String discussionUser,String discussionContent){
        String sql = "delete from discussion where discussionUser = ? and discussionContent=?";
        return update(sql, discussionUser,discussionContent);
    }

    @Override
    public int updateDiscussionColumnValue(Integer discussionId, String columnName, String columnValue) {
        String sql = "update discussion set " + columnName + " = '" + columnValue + "' where discussionId = " + discussionId;
        //System.out.println(sql);
        return update(sql);
    }

    @Override
    public Discussion queryDiscussionById(Integer discussionId) {
        String sql = "select * from discussion where DiscussionId=?";
        return queryForOne(Discussion.class, sql, discussionId);
    }

    @Override
    public Discussion queryDiscussionByHead(String discussionHead) {
        String sql = "select * from discussion where DiscussionHead=?";
        return queryForOne(Discussion.class, sql, discussionHead);
    }

    @Override
    public Discussion queryDiscussionByUser(String discussionUser) {
        String sql = "select * from discussion where DiscussionUser=?";
        return queryForOne(Discussion.class, sql, discussionUser);
    }

    public Discussion queryDiscussionByTime(){
        String sql="SELECT * FROM discussion ORDER BY CreateTime DESC LIMIT 1";
        return  queryForOne(Discussion.class,sql);
    }

    @Override
    public Integer queryPageTotalCounts() {
        String sql = "select count(1) from discussion";
        return Math.toIntExact((Long) queryForSingleValue(sql));
    }

    @Override
    public List<Discussion> queryDiscussionByPage(Integer begin, Integer pageSize) {
        String sql = "select * from discussion c,user u  where c.discussionUser=u.userName ORDER BY c.CreateTime DESC limit ?, ? ";
        return queryForList(Discussion.class, sql, begin, pageSize);
    }

    public List<Discussion> queryAllDiscussion() {
        String sql = "select * from discussion";
        return queryForList(Discussion.class, sql);
    }

    @Override
    public List<Discussion> queryAllDiscussion(String discussionHead, String discussionContent, String discussionUser) {
        String sql = "SELECT * FROM discussion WHERE discussionHead LIKE '%' AND discussionContent LIKE '%' AND discussionUser LIKE '%'";
        if (StringUtils.isNotEmpty(discussionHead)) {
            String string = "discussionHead LIKE '%" + discussionHead + "%'";
            sql = sql.replace("discussionHead LIKE '%'", string);
        }
        if (StringUtils.isNotEmpty(discussionContent)) {
            String string = "discussionContent LIKE '%" + discussionContent + "%'";
            sql = sql.replace("discussionContent LIKE '%'", string);
        }
        if (StringUtils.isNotEmpty(discussionUser)) {
            String string = "discussionUser LIKE '%" + discussionUser + "%'";
            sql = sql.replace("discussionUser LIKE '%'", string);
        }
        return queryForList(Discussion.class, sql);
    }

    public List<Discussion> queryDiscussion() {
        String sql="SELECT * FROM discussion c,user u  where c.discussionUser=u.userName ORDER BY c.CreateTime DESC";
        return  queryForList(Discussion.class,sql);
    }
}
