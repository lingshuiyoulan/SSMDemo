package com.ssm.service;

import com.ssm.domain.User;
import com.ssm.utils.PageBean;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    User login(String name, String pass) ;

    boolean exit();

    boolean add(User user);

    boolean update(int id, User user);

    boolean delete(int id);

    User findUserById(int id);

    List<User> findUsersByCondition(User user);

    PageBean<User> findUsersByPage(Integer page,Integer pageSize);
}