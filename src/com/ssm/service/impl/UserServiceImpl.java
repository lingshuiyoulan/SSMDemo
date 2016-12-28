package com.ssm.service.impl;

import com.ssm.dao.UserDao;
import com.ssm.domain.User;
import com.ssm.service.UserService;
import com.ssm.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User login(String name, String pass){
       return userDao.selectByNameAndPass(name, pass);
    }

    @Override
    public boolean exit() {
        return false;
    }

    @Override
    public boolean add(User user){
        int res = userDao.insert(user);
        return res == 1;
    }

    @Override
    public boolean update(int id, User user){
        user.setId(id);
        int res = userDao.updateByPrimaryKey(user);
        return res == 1;
    }

    @Override
    public boolean delete(int id){
        int res = userDao.deleteByPrimaryKey(id);
        return res == 1;
    }

    @Override
    public User findUserById(int id){
        User user = userDao.selectByPrimaryKey(id);
        return user;
    }

    @Override
    public List<User> findUsersByCondition(User user){
        List<User> users = userDao.selectByCondition(user);
        return users;
    }

    @Override
    public PageBean<User> findUsersByPage(Integer page,Integer pageSize) {
        Integer totals = userDao.selectCount();
        PageBean<User> pageBean = new PageBean<>();
        pageBean.setPageSize(pageSize);
        pageBean.setTotalRecords(totals);
        pageBean.setCurPage(page);
        List<User> users = userDao.selectByPage(pageBean);
        pageBean.setData(users);
        return pageBean;
    }
}
