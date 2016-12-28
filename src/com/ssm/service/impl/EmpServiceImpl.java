package com.ssm.service.impl;

import com.ssm.dao.EmpDao;
import com.ssm.domain.AuthAndGroup;
import com.ssm.domain.Emp;
import com.ssm.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpDao empDao;

    @Override
    public Emp login(String name, String pass){
        return empDao.selectByNameAndPass(name,pass);
    }

    @Override
    public List<AuthAndGroup> findAuthInGroupById(Integer id) {
        return empDao.selectAuthInGroup(id);
    }

    @Override
    public List<AuthAndGroup> findAuthOutGroupById(Integer id) {
        return empDao.selectAuthOutGroup(id);
    }
}
