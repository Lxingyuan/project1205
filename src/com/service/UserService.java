package com.service;

import com.entity.User;
import com.utils.Page;

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

    //更新信息
    int update(User user);

    User queryUserById(Integer id);

    User queryUserByName(String username);

    User queryUserByNameAndPassword(User user);

    //用户分页
    Page<User> queryUserByPage(int pageNo, int pageSize);

    User queryUserByUsername(String username);

    User queryUserByTelephone(String telephone);

}
