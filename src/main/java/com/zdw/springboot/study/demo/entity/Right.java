package com.zdw.springboot.study.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Author:zoudw
 * Since:JDK 7
 * Date:2019/3/19
 * Description:
 *
 * @Copyright:2018, zoudw@szinfinova.com All Rights Reserved
 */
@Entity
@Data
public class Right {
    @Id
    @GeneratedValue
    private Integer rightId;

    private  String rightName;

    @Column(columnDefinition = "enum('menu','button')")
    private String resourceType;

    private String url;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "RoleRitht",joinColumns = {@JoinColumn(name = "rightId")},inverseJoinColumns = {@JoinColumn(name = "roleId")})
    private List<Role> roles;
}
