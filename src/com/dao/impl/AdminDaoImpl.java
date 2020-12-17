package com.dao.impl;

import com.dao.AdminDao;
import com.dao.BaseDao;
import com.entity.Admin;
import com.entity.Comment;
import com.entity.User;
import com.utils.Page;

import java.util.List;

/**
 * 作者：林星源
 * 日期: 2020/12/9 11:29
 * 描述:
 */
public class AdminDaoImpl extends BaseDao implements AdminDao {

    @Override
    public int updateAdmin(Admin admin) {
        String sql = "update admin set UpdateTime=?,Title=?,UserName=?,Password=?,LastTime=?,LogCount=?,HeadPic=?";
        return update(sql, admin.getUpdateTime(), admin.getTitle(), admin.getUserName(), admin.getPassword(), admin.getLastTime(), admin.getLogCount(), admin.getHeadPic());
    }

    @Override
    public int deleteUser(Integer userId) {
        String sql = "delete from user where userId = ?";
        return update(sql, userId);
    }

    @Override
    public List<User> queryAllUser() {
        String sql = "select * from user";
        return queryForList(User.class, sql);
    }

    @Override
    public Admin queryUserById(Integer adminId) {
        return null;
    }

    @Override
    public  Admin queryAdminByName(String adminName){
        String sql="select * from admin where UserName=?";
        return queryForOne(Admin.class, sql, adminName);
    }

    @Override
    public Admin queryAdminByNameAndPassword(Admin admin) {
        String sql = "select * from admin where UserName = ? and Password = ?";
        return queryForOne(Admin.class, sql, admin.getUserName(), admin.getPassword());
    }

    //查询当前表的总记录条数
    @Override
    public Integer queryPageTotalCounts() {
        String sql = "select count(1) from user";
        return Math.toIntExact((Long) queryForSingleValue(sql));
    }

    @Override
    public Admin queryUserByUsername(String username) {
        String sql = "select * from admin where username=?";
        return queryForOne(Admin.class, sql, username);
    }

    @Override
    public List<Admin> queryAdminByPage(Integer begin, Integer pageSize) {
        String sql = "select * from user limit ?, ?";
        return queryForList(Admin.class, sql, begin, pageSize);
    }

    public List<Admin> queryAllAdmin() {
        String sql = "select * from admin ";
        return queryForList(Admin.class, sql);
    }

}
