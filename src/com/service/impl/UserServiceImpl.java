package com.service.impl;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.entity.User;
import com.service.UserService;
import com.utils.Page;
import com.utils.Page2;

import java.util.List;

/**
 * 作者：林星源
 * 日期: 2020/12/9 15:31
 * 描述:
 */
public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public int register(User user) {
        return userDao.registerUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByNameAndPassword(user);
    }

    @Override
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }


    @Override
    public int update(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public int updateUser2(User user) {
        return userDao.updateUser2(user);
    }

    @Override
    public int deleteUser(Integer userId) {
        return userDao.deleteUser(userId);
    }

    @Override
    public User queryUserById(Integer id) {
        return userDao.queryUserById(id);
    }

    @Override
    public User queryUserByName(String username) {
        return userDao.queryUserByName(username);
    }

    @Override
    public User queryUserByToolId(String toolId) {
        return userDao.queryUserByToolId(toolId);
    }

    @Override
    public User queryUserByNameAndPassword(User user) {
        return userDao.queryUserByNameAndPassword(user);
    }

    @Override
    public Page<User> queryUserByPage(int pageNo, int pageSize) {
        Page<User> page = new Page<>();
        //设置当前页码
        page.setPageNo(pageNo);
        //设置页面大小
        page.setPageSize(pageSize);
        //求总记录数
        Integer pageTotalCount = userDao.queryPageTotalCounts();
        //设置总记录数
        page.setPageTotalCount(pageTotalCount);
        //求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal += 1;
        }
        //设置总页码
        page.setPageTotal(pageTotal);
        //求开始页码
        int begin = (page.getPageNo() - 1) * pageSize;
        //获取开始页码的分页数据
        List<User> items = userDao.queryUserByPage(begin, pageSize);
        //设置数据
        page.setItems(items);
        return page;
    }

    @Override
    public User queryUserByUsername(String username) {
        return userDao.queryUserByUsername(username);
    }


    @Override
    public User queryUserByTelephone(String telephone) {
        return userDao.queryUserByTelephone(telephone);
    }

    @Override
    public User queryUserByQQ(Integer qq) {
        return userDao.queryUserByQQ(qq);
    }

    @Override
    public User queryUserByEmail(String email) {
        return userDao.queryUserByEmail(email);
    }

    @Override
    public Page2<User> queryUserByPage2() {
        Page2<User> page = new Page2<>();
        page.setCode(0);
        page.setMsg("");
        //求总记录数
        Integer pageTotalCount = userDao.queryPageTotalCounts();
        page.setCount(pageTotalCount);
        page.setData(userDao.queryAllUser());
        return page;
    }

    @Override
    public Page2<User> queryUserByPage2(String userName, String telephone, String qq, String email) {
        Page2<User> page = new Page2<>();
        page.setCode(0);
        page.setMsg("");
        List<User> list = userDao.queryAllUser(userName, telephone, qq, email);
        page.setData(list);
        page.setCount(list.size());
        return page;
    }

    @Override
    public int updateUserColumnValue(Integer userId, String columnName, String columnValue) {
        return userDao.updateUserColumnValue(userId, columnName, columnValue);
    }

    @Override
    public int scoreUp(Integer userId, Integer score) {
        return userDao.scoreUp(userId, score);
    }

    @Override
    public int levelUp(Integer userId, Integer level, Integer score) {
        return userDao.levelUp(userId, level, score);
    }

    @Override
    public User findUserVoteOrNot(String userName) {
        return userDao.findUserVoteOrNot(userName);
    }

    @Override
    public Integer setUserVoteIsTrue(String username) {
        return userDao.setUserVoteIsTrue(username);
    }
}
