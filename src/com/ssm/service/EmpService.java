package com.ssm.service;

import com.ssm.domain.AuthAndGroup;
import com.ssm.domain.Emp;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by lanling on 2016/12/21.
 */
public interface EmpService {
    Emp login(String name, String pass);

    List<AuthAndGroup> findAuthInGroupById(Integer id);

    List<AuthAndGroup> findAuthOutGroupById(Integer id);
}
