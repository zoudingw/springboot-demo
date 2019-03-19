package com.zdw.springboot.study.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Data
public class User {

    @Id
    @GeneratedValue
    private Integer userId;

    @Column(unique = true)
    private String userName;

    private  String salt;

    private byte state;

    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name ="UserRole",joinColumns = {@JoinColumn(name = "userId")},inverseJoinColumns = {@JoinColumn(name = "roleId")})
    private List<Role> roleList;

    private  String addr;

    private Date birthday;
}
