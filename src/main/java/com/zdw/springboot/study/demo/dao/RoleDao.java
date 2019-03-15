package com.zdw.springboot.study.demo.dao;

import com.zdw.springboot.study.demo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author:zoudw
 * Since:JDK 7
 * Date:2019/3/15
 * Description:
 *
 * @Copyright:2018, zoudw@szinfinova.com All Rights Reserved
 */
public interface RoleDao extends JpaRepository<Role,Integer> {
}
