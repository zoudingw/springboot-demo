package com.zdw.springboot.study.demo.entity;

import javax.persistence.*;

/**
 * Author:zoudw
 * Since:JDK 7
 * Date:2019/3/15
 * Description:
 *
 * @Copyright:2018, zoudw@szinfinova.com All Rights Reserved
 */
@Table(name = "t_role")
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer roleId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "role_name")
    private String roleName;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
