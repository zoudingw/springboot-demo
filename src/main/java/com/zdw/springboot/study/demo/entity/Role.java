package com.zdw.springboot.study.demo.entity;

import lombok.Data;
import org.hibernate.annotations.Proxy;

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
    @GeneratedValue
    private Integer roleId;

    @ManyToMany
    @JoinTable(name = "UserRole",joinColumns = {@JoinColumn(name = "roleId")},inverseJoinColumns = {@JoinColumn(name ="userId" )})
    private List<User> users;

    private String roleName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "RoleRight",joinColumns = {@JoinColumn(name = "roleId")},inverseJoinColumns = {@JoinColumn(name = "rightId")})
    private List<MyRight> rights;

    private String description;

    private Boolean avaliable = Boolean.FALSE;

}
