package com.dao.impl;

import com.dao.BaseDao;
import com.dao.BaseDao;
import com.dao.UserDao;
import com.entity.User;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * 作者：林星源
 * 日期: 15:47 2020/11/26
 * 描述：
 */
public class UserDaoImpl extends BaseDao implements UserDao {

    //注册用户
    @Override
    public int registerUser(User user) {
        String sql = "insert into user (UserName,UserPassword,Telephone)values(?,?,?)";

        return update(sql, user.getUserName(), user.getUserPassword(), user.getTelephone());
    }

    @Override
    public int insertUser(User user) {
        String sql = "insert into user (UserName,UserPassword,HeadPic,Sex,Telephone,QQ,Email)values(?,?,?,?,?,?,?)";
        return update(sql, user.getUserName(), user.getUserPassword(), user.getHeadPic(), user.getSex(), user.getTelephone(), user.getQq(), user.getEmail());
    }


    //更新用户
    @Override
    public int updateUser(User user) {
        String sql = "update user set UserName = ?,UserPassword = ?,Telephone = ?,QQ = ?,Email = ?,Sex = ?,RegisterTime = ?,HeadPic = ? where UserId = ?";
        return update(sql, user.getUserName(), user.getUserPassword(), user.getTelephone(), user.getQq(), user.getEmail(), user.getSex(), user.getRegisterTime(), user.getHeadPic(), user.getUserId());
    }

    @Override
    public int updateUser2(User user) {
        String sql = "update user set Telephone = ?,QQ = ?,Email = ?,Sex = ?,HeadPic = ? where UserName = ?";
        return update(sql, user.getTelephone(),user.getQq(),user.getEmail(),user.getSex(),user.getHeadPic(),user.getUserName());
    }

    @Override
    public int updateUserColumnValue(Integer userId, String columnName, String columnValue) {
        //System.out.println("dao中:"+movieId+" "+columnName+" "+columnValue);
        String sql = "update user set " + columnName + " = '" + columnValue + "' where userId = " + userId;
        //System.out.println(sql);
        return update(sql);
    }

    @Override
    public int deleteUser(Integer userId) {
        String sql = "delete from user where UserId = ?";
        return update(sql, userId);
    }

    //根据用户id查询
    @Override
    public User queryUserById(Integer userId) {
        String sql = "select * from user where UserId=?";
        return queryForOne(User.class, sql, userId);
    }

    @Override
    public User queryUserByName(String username) {
        String sql = "select * from user where UserName=?";
        return queryForOne(User.class, sql, username);
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

    @Override
    public User queryUserByUsername(String username) {
        String sql = "select * from user where username=?";
        return queryForOne(User.class, sql, username);
    }

    @Override
    public User queryUserByTelephone(String telephone) {
        String sql = "select * from user where telephone=?";
        return queryForOne(User.class, sql, telephone);
    }

    @Override
    public User queryUserByQQ(Integer qq) {
        String sql = "select * from user where qq=?";
        return queryForOne(User.class, sql, qq);
    }

    @Override
    public User queryUserByEmail(String email) {
        String sql = "select * from user where email=?";
        return queryForOne(User.class, sql, email);
    }

    @Override
    public List<User> queryAllUser() {
        String sql = "select * from user";
        return queryForList(User.class, sql);
    }

    @Override
    public List<User> queryAllUser(String userName, String telephone, String qq, String email) {
        String sql = "SELECT * FROM user WHERE userName LIKE '%' AND telephone LIKE '%' AND qq LIKE '%' AND email LIKE '%'";
        if(StringUtils.isNotEmpty(userName)){
            String string="userName LIKE '%"+userName+"%'";
            sql=sql.replace("userName LIKE '%'",string);
        }
        if(StringUtils.isNotEmpty(telephone)){
            String string="telephone LIKE '%"+telephone+"%'";
            sql=sql.replace("telephone LIKE '%'",string);
        }
        if(StringUtils.isNotEmpty(qq)){
            String string="qq LIKE '%"+qq+"%'";
            sql=sql.replace("qq LIKE '%'",string);
        }
        if(StringUtils.isNotEmpty(email)){
            String string="email LIKE '"+email+"'";
            sql=sql.replace("email LIKE '%'",string);
        }
        return queryForList(User.class, sql);
    }

    @Override
    public User findUserVoteOrNot(String userName) {
        String sql = "select * from user where userName = ? and vote = 1";
        return queryForOne(User.class, sql, userName);
    }

    @Override
    public Integer setUserVoteIsTrue(String username) {
        String sql = "update user set vote = 1 where UserName = ?";
        return update(sql, username);
    }
}