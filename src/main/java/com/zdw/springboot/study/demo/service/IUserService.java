package com.zdw.springboot.study.demo.service;

import com.zdw.springboot.study.demo.entity.User;

public interface IUserService {

    public int updateUserNameById(String name,Long id);

    public User getUserByUserName(String name);
}
