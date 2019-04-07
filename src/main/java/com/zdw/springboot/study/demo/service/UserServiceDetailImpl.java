package com.zdw.springboot.study.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.zdw.springboot.study.demo.dao.RoleDao;
import com.zdw.springboot.study.demo.dao.RoleRightDao;
import com.zdw.springboot.study.demo.dao.UserDao;
import com.zdw.springboot.study.demo.dao.UserRoleDao;
import com.zdw.springboot.study.demo.entity.MyUserDetail;
import com.zdw.springboot.study.demo.entity.Role;
import com.zdw.springboot.study.demo.entity.User;
import com.zdw.springboot.study.demo.entity.UserRole;
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
@Service("userDetailsServiceImpl")
public class UserServiceDetailImpl implements UserDetailsService ,Serializable{

    private final  static String serialVersionUID = "3045101594556178750";

    @Autowired
    UserServiceImpl userService;

    @Autowired
    IUserRole userRoleService;


    @Autowired
    IRoleService roleService;



    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userService.getUserByUserName(s);
        List<UserRole> userRoles = userRoleService.selectByPrimaryByUserId(user.getUserId());
        List<Role> roles = new ArrayList<>();
        for (UserRole u : userRoles) {
            Role role = roleService.selectByPrimaryKey(u.getRoleId());
            roles.add(role);
        }
        user.setRoleList(roles);
       /* User user = new User();
        user.setPassword("$2a$10$YpTZGPQ88.nmnwA8ZinCqujcpo1i6lWYJ.JneB/Viq8mjIT5B2AEa");
        user.setUserName("admin");
        user.setUserId(1);
        Role role = new Role();
        role.setRoleName("ROLE_ADMIN");
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        user.setRoleList(roles);*/
        return new MyUserDetail(user);
    }
}

