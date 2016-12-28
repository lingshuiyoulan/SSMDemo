package com.ssm.service.impl;

import com.ssm.dao.DeptDao;
import com.ssm.domain.Dept;
import com.ssm.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService{

    @Autowired
    private DeptDao deptDao;

    @Override
    public List<Dept> findDeptsByCondition(Dept dept) throws SQLException {
        return deptDao.selectByCondition(dept);
    }

    @Override
    public Dept findDeptById(int id) throws SQLException {
        return deptDao.selectByPrimaryKey(id);
    }

    @Override
    public boolean add(Dept dept) throws SQLException {
        return deptDao.insert(dept) == 1;
    }

    @Override
    public boolean update(int id, Dept dept) throws SQLException {
        dept.setDeptno(id);
        return deptDao.updateByPrimaryKeySelective(dept) == 1;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return deptDao.deleteByPrimaryKey(id) == 1;
    }
}
