package com.zdw.springboot.study.demo.entity;

import javax.persistence.*;

@Table(name = "t_user")
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "addr")
    private  String addr;

    public User() {
    }

    public User(String userName, String addr) {
        this.userName = userName;
        this.addr = addr;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}