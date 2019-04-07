package com.zdw.springboot.study.demo.dao;

import com.zdw.springboot.study.demo.entity.User;
import io.micrometer.core.instrument.Meter;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserDao{
    User selectByPrimaryKey(Integer userId);

    User getByName(String userName);

    int deleteByPrimaryKey(Integer userId);

    int insertUser(User user);

    int insertSelective(User user);

    int updateByPrimaryKeySelective(User user);

}
