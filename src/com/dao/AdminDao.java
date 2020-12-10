package com.dao;

import com.entity.Admin;
import com.entity.User;
import com.utils.Page;

import java.util.List;

/**
 * 作者：林星源
 * 日期: 2020/12/9 11:14
 * 描述:
 */

public interface AdminDao {
    int updateAdmin(Admin admin);

    int deleteUser(Integer userId);

    List<User> queryAllUser();

    Admin queryUserById(Integer userId);

    Admin queryAdminByName(String adminName);

    Admin queryAdminByNameAndPassword(Admin admin);

    List<Admin> queryAdminByPage(Integer begin, Integer pageSize);

    Integer queryPageTotalCounts();

    Admin queryUserByUsername(String username);

}
