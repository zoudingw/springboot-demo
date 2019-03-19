package com.zdw.springboot.study.demo.service;

import com.zdw.springboot.study.demo.dao.UserDao;
import com.zdw.springboot.study.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Author:zoudw
 * Since:JDK 7
 * Date:2019/3/15
 * Description:
 *
 * @Copyright:2018, zoudw@szinfinova.com All Rights Reserved
 */
@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    UserDao userDao;

    @Transactional
    public int updateUserNameById(String name,Long id){
        return userDao.updateUsernameByUserId(name,id);
    }

    public User getUserByUserName(String name){
        User user = userDao.findByUserNameLike(name);
        return user;
    }

}
