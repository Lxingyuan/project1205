package com.service;

import com.entity.User;
import com.utils.Page;

import java.util.List;

/**
 * 作者：LiuYunTao
 * 日期: 16:00 2020/11/26
 * 描述：
 */
public interface UserService {
    //注册
    int register(User user);

    //登录
    User login(User user);

    //更新信息
    int update(User user);

    User queryUserById(Integer id);

    Page<User> queryByPage(int pageNo, int pageSize);
}
