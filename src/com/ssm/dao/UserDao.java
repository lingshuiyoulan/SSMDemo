package com.ssm.dao;

import com.ssm.domain.User;
import com.ssm.utils.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectByCondition(User user);

    User selectByNameAndPass(@Param("name") String name, @Param("pass") String pass);

    List<User> selectByPage(PageBean<User> pageBean);

    Integer selectCount();
}