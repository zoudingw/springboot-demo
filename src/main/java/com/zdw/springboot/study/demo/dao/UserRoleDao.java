package com.zdw.springboot.study.demo.dao;

import com.zdw.springboot.study.demo.entity.Role;
import com.zdw.springboot.study.demo.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Author:zoudw
 * Since:JDK 7
 * Date:2019/3/15
 * Description:
 *
 * @Copyright:2018, zoudw@szinfinova.com All Rights Reserved
 */
@Mapper
public interface UserRoleDao {
    List<UserRole> selectByPrimaryByUserId(Integer userId);
    List<UserRole> selectByPrimaryByRoleId(Integer roleId);
}
