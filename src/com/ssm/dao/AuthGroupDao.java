package com.ssm.dao;

import com.ssm.domain.AuthGroup;

public interface AuthGroupDao {
    int deleteByPrimaryKey(Integer id);

    int insert(AuthGroup record);

    int insertSelective(AuthGroup record);

    AuthGroup selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AuthGroup record);

    int updateByPrimaryKey(AuthGroup record);
}