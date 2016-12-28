package com.ssm.service.impl;

import com.ssm.domain.User;
import com.ssm.service.UserService;
import javafx.application.Application;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by lanling on 2016/12/21.
 */
public class UserServiceImplTest {

    private UserService userService;
    @Before
    public void setUp() throws Exception {
        ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
        userService = (UserService) act.getBean("userServiceImpl");
    }

    @Test
    public void login() throws Exception {
        User login = userService.login("1", "1");
        System.out.println(login);
    }

    @Test
    public void exit() throws Exception {

    }

    @Test
    public void add() throws Exception {

    }

    @Test
    public void update() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void findUserById() throws Exception {

    }

    @Test
    public void findUsersByCondition() throws Exception {

    }

}