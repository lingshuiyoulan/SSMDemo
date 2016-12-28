package com.ssm.service;

import com.ssm.domain.Dept;

import java.sql.SQLException;
import java.util.List;

public interface DeptService {
    List<Dept> findDeptsByCondition(Dept dept) throws SQLException;

    Dept findDeptById(int id) throws SQLException;

    boolean add(Dept dept) throws SQLException;

    boolean update(int id, Dept dept) throws SQLException;

    boolean delete(int id) throws SQLException;
}