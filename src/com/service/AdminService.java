package com.service;

import com.entity.Admin;
import com.entity.User;
import com.utils.Page;

import java.util.List;

/**
 * 作者：林星源
 * 日期: 2020/12/9 15:26
 * 描述:
 */
public interface AdminService {
    int updateAdmin(Admin admin);

    int deleteUser(Integer userId);

    List<User> queryAllUser();

    Admin queryUserById(Integer userId);

    Admin queryAdminByNameAndPassword(Admin admin);

    Page<Admin> queryByPage(int pageNo, int pageSize);
}
