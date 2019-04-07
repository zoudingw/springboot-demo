package com.zdw.springboot.study.demo.service;

import com.zdw.springboot.study.demo.entity.Role;

public interface IRoleService {
    Role selectByPrimaryKey(Integer roleId);
}
