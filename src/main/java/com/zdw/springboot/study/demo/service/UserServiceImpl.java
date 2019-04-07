package com.zdw.springboot.study.demo.service;

import com.zdw.springboot.study.demo.dao.UserDao;
import com.zdw.springboot.study.demo.entity.Role;
import com.zdw.springboot.study.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Author:zoudw
 * Since:JDK 7
 * Date:2019/3/15
 * Description:
 *
 * @Copyright:2018, zoudw@szinfinova.com All Rights Reserved
 */
@Service("userDetailsService")
public class UserServiceImpl implements IUserService {

    @Autowired
    UserDao userDao;


    @Override
    public int updateUserNameById(String name, Long id) {
        return 0;
    }

    public User getUserByUserName(String name){
        User user = userDao.getByName(name);
        return user;
    }

}

