package com.dao;

import com.entity.Admin;
import com.entity.User;
import com.utils.Page;

import java.util.List;

/**
 * @author：林星源
 * @date: 2020/12/9 11:13
 * @description:
 */

public interface AdminDao {
    /**
     * 更新管理员信息
     *
     * @param admin 管理员类
     * @return
     */
    int updateAdmin(Admin admin);

    /**
     * 删除用户
     *
     * @param userId
     * @return
     */
    int deleteUser(Integer userId);

    /**
     * 查询用户
     *
     * @return
     */
    List<User> queryAllUser();

    /**
     * 通过用户ID搜索
     *
     * @param userId
     * @return
     */
    Admin queryUserById(Integer userId);

    /**
     * 通过管理员账户密码搜索
     *
     * @param admin
     * @return
     */
    Admin queryAdminByNameAndPassword(Admin admin);

    List<Admin> queryAdminByPage(Integer begin, Integer pageSize);

    Integer queryPageTotalCounts();
}
