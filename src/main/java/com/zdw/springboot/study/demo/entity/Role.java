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

    @Column(name = "user_id")
    private List<User> users;

    private String roleName;

    private String desc;

    private Boolean avaliable;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

}
