package com.zdw.springboot.study.demo.service;

import com.zdw.springboot.study.demo.dao.RoleDao;
import com.zdw.springboot.study.demo.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    RoleDao roleDao;

    @Override
    public Role selectByPrimaryKey(Integer roleId) {
        return roleDao.selectByPrimaryKey(roleId);
    }
}
