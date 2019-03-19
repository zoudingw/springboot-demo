package com.zdw.springboot.study.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Author:zoudw
 * Since:JDK 7
 * Date:2019/3/15
 * Description:
 *
 * @Copyright:2018, zoudw@szinfinova.com All Rights Reserved
 */
@Entity
@Data
public class Role {
    @Id
    @GeneratedValue()
    private Integer roleId;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "UserRole",joinColumns = {@JoinColumn(name = "roleId")},inverseJoinColumns = {@JoinColumn(name ="userId" )})
    private List<User> users;

    private String roleName;

    @ManyToMany
    @JoinTable(name = "RoleRitht",joinColumns = {@JoinColumn(name = "roleId")},inverseJoinColumns = {@JoinColumn(name = "rightId")})
    private List<Right> rights;

    private String desc;

    private Boolean avaliable = Boolean.FALSE;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

}
