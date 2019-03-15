package com.zdw.springboot.study.demo;

import com.alibaba.fastjson.JSONObject;
import com.zdw.springboot.study.demo.dao.UserDao;
import com.zdw.springboot.study.demo.entity.User;
import com.zdw.springboot.study.demo.service.UserServiceImol;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    UserDao userDao;

    @Autowired
    UserServiceImol userServiceImol;

    @Test
    public  void test(){
       User user1  =  new User("haha","aaa");
       User user2  =  new User("xixi","aaa");
       User user3  =  new User("hehe","aaa");
       List<User> users=new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
       // userDao.saveAll(users);

        User ha = userDao.findByUserNameLike("%ha%");

        List<User> top3ByOrderByUserIdDesc = userDao.findTop3ByOrderByUserIdDesc();

        List<User> all = userDao.findAll();
        System.out.println(JSONObject.toJSONString(all));

        int hehehhee = userServiceImol.updateUserNameById("hehehhee", 10L);

        User one = userDao.findByUserId(1L);
        System.out.println(JSONObject.toJSONString(one));
        PageRequest pageRequest = new PageRequest(1, 2, Sort.by(Sort.Direction.DESC, "userId"));
        Page<User> all1 = userDao.findAll(pageRequest);
        System.out.println("......");
    }

}
