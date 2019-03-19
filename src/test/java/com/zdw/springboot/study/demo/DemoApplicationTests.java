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

}
