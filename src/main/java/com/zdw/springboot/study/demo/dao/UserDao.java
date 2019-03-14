package com.zdw.springboot.study.demo.dao;

import com.zdw.springboot.study.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Long> {
    User findByUserId(Long id);
}
