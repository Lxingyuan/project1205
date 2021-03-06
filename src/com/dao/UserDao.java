package com.dao;

import com.entity.User;

import java.util.List;

/**
 * 作者：林星源
 * 日期: 2020/12/9 11:13
 * 描述:
 */
public interface UserDao {
    int registerUser(User user);

    int insertUser(User user);

    int updateUser(User user);
    int updateUser2(User user);

    int updateLevel(User user);

    int updateScore(User user);

    //修改某个字段的电影信息
    int updateUserColumnValue(Integer userId, String columnName, String columnValue);

    int deleteUser(Integer userId);

    User queryUserById(Integer id);

    User queryUserByName(String username);

    //根据资源查询上传用户
    User queryUserByToolId(String toolId);

    User queryUserByNameAndPassword(User user);

    Integer queryPageTotalCounts();

    List<User> queryUserByPage(Integer pageNo, Integer pageSize);

    User queryUserByUsername(String username);

    User queryUserByTelephone(String telephone);

    User queryUserByQQ(Integer qq);

    User queryUserByEmail(String email);

    List<User> queryAllUser();

    List<User> queryAllUser(String userName, String telephone, String qq, String email);

    User findUserVoteOrNot(String userName);

    Integer setUserVoteIsTrue(String username);

    Integer scoreUp(Integer userId, Integer score);

    Integer levelUp(Integer userId, Integer level, Integer score);
}
