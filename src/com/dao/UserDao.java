package com.dao;

import com.entity.User;

import java.util.List;

/**
 * 作者：林星源
 * 日期: 2020/12/9 11:13
 * 描述:
 */
public interface UserDao {
    int insertUser(User user);

    int updateUser(User user);

    User queryUserById(Integer id);

    User queryUserByNameAndPassword(User user);
}
