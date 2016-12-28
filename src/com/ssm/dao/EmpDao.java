package com.ssm.dao;

import com.ssm.domain.AuthAndGroup;
import com.ssm.domain.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Emp record);

    int insertSelective(Emp record);

    Emp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Emp record);

    int updateByPrimaryKey(Emp record);

    Emp selectByNameAndPass(@Param("name") String name, @Param("pass") String pass);

    List<AuthAndGroup> selectAuthInGroup(Integer id);

    List<AuthAndGroup> selectAuthOutGroup(Integer id);
}