package com.zdw.springboot.study.demo.service;

import com.zdw.springboot.study.demo.dao.UserRoleDao;
import com.zdw.springboot.study.demo.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserRoleImpl implements IUserRole {

    @Autowired
    UserRoleDao userRoleDao;

    @Override
    public List<UserRole> selectByPrimaryByUserId(Integer userId) {
        return userRoleDao.selectByPrimaryByUserId(userId);
    }

    @Override
    public List<UserRole> selectByPrimaryByRoleId(Integer roleId) {
        return userRoleDao.selectByPrimaryByRoleId(roleId);
    }
}
