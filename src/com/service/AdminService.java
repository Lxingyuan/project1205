package com.service;

import com.entity.Admin;
import com.entity.User;
import com.utils.Page;
import com.utils.Page2;

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

    Admin queryAdminByName(String username);

    Admin queryAdminByNameAndPassword(Admin admin);

    Page<Admin> queryAdminByPage(int pageNo, int pageSize);

    Admin queryUserByUsername(String username);

    //登录
    Admin login(Admin admin);

    Page2<Admin> queryAdminByPage2();

    int updateUserColumnValue(Integer userId, String columnName, String columnValue);
}
