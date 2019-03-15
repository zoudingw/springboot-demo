package com.zdw.springboot.study.demo.dao;

import com.zdw.springboot.study.demo.entity.User;
import com.zdw.springboot.study.demo.service.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserDao extends JpaRepository<User,Long> {
    User findByUserId(Long id);

    User findByUserNameLike(String name);

    List<User> findTop3ByOrderByUserIdDesc();

    @Modifying
    @Query("update User u set u.userName = ?1 where u.userId = ?2")
    int updateUsernameByUserId(String name,Long id);


}
