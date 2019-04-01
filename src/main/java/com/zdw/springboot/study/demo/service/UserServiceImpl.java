package com.zdw.springboot.study.demo.service;

import com.zdw.springboot.study.demo.dao.UserDao;
import com.zdw.springboot.study.demo.entity.Role;
import com.zdw.springboot.study.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class UserServiceImpl implements IUserService{

    @Autowired
    UserDao userDao;

    @Transactional
    public int updateUserNameById(String name,Long id){
        return userDao.updateUsernameByUserId(name,id);
    }

    @Transactional
    public User getUserByUserName(String name){
        User user = userDao.findByUserNameLike(name);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDao.findByUserNameLike(s);
        return new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                List<GrantedAuthority> list = new ArrayList<>();
                for (Role role : user.getRoleList()) {
                    GrantedAuthority authority = new SimpleGrantedAuthority(role.getRoleName());
                    list.add(authority);
                }
                return list;
            }

            @Override
            public String getPassword() {
                return user.getPassword();
            }

            @Override
            public String getUsername() {
                return user.getUserName();
            }

            @Override
            public boolean isAccountNonExpired() {
                return false;
            }

            @Override
            public boolean isAccountNonLocked() {
                return false;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return false;
            }

            @Override
            public boolean isEnabled() {
                return false;
            }
        };
        }
}

