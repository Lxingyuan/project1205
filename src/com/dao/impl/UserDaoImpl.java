package com.dao.impl;

import com.dao.BaseDao;
import com.dao.BaseDao;
import com.dao.UserDao;
import com.entity.User;

import java.util.List;

/**
 * 作者：林星源
 * 日期: 15:47 2020/11/26
 * 描述：
 */
public class UserDaoImpl extends BaseDao implements UserDao {

    //增加用户
    @Override
    public int insertUser(User user) {
        String sql = "insert into user (UserName,UserPassword,Telephone)values(?,?,?)";
        return update(sql, user.getUserName(), user.getUserPassword(), user.getTelephone());
    }

    //更新用户
    @Override
    public int updateUser(User user) {
        String sql = "update user set UpdateTime = ?,UserName = ?,UserPassword = ?,Telephone = ?,QQ = ?,Email = ?,Sex = ?,RegisterTime = ?,HeadPic = ? where UserId = ?";
        return update(sql, user.getUpdateTime(), user.getUserName(), user.getUserPassword(), user.getTelephone(), user.getQq(), user.getEmail(), user.getSex(), user.getRegisterTime(), user.getHeadPic(), user.getUserId());
    }

    //根据用户id查询
    @Override
    public User queryUserById(Integer userId) {
        String sql = "select * from user where UserId=?";
        return queryForOne(User.class, sql, userId);
    }

    @Override
    public User queryUserByNameAndPassword(User user) {
        String sql = "select * from user where UserName = ? and UserPassword = ?";
        return queryForOne(User.class, sql, user.getUserName(), user.getUserPassword());
    }

    //查询当前表的总记录条数
    @Override
    public Integer queryPageTotalCounts() {
        String sql = "select count(1) from user";
        return Math.toIntExact((Long) queryForSingleValue(sql));
    }

    @Override
    public List<User> queryUserByPage(Integer begin, Integer pageSize) {
        String sql = "select * from user limit ?, ?";
        return queryForList(User.class, sql, begin, pageSize);
    }

}
