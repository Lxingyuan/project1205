package com.service;

import com.entity.User;
import com.utils.Page;
import com.utils.Page2;

import java.util.List;

/**
 * 作者：林星源
 * 日期: 2020/12/9 15:31
 * 描述:
 */
public interface UserService {
    //注册
    int register(User user);

    //登录
    User login(User user);

    int insertUser(User user);
    //更新信息
    int update(User user);
    int updateUser2(User user);
    int deleteUser(Integer userId);

    User queryUserById(Integer id);

    User queryUserByName(String username);

    User queryUserByNameAndPassword(User user);

    //用户分页
    Page<User> queryUserByPage(int pageNo, int pageSize);

    User queryUserByUsername(String username);

    User queryUserByTelephone(String telephone);
    User queryUserByQQ(Integer qq);

    User queryUserByEmail(String email);
    //电影分页2
    Page2<User> queryUserByPage2();

    Page2<User> queryUserByPage2(String userName,String telephone,String qq,String email);

    int updateUserColumnValue(Integer userId,String columnName,String columnValue);

    User findUserVoteOrNot(String userName);

    Integer setUserVoteIsTrue(String username);
}
