package com.wei.study.java.spring.boot;

import com.wei.study.java.spring.boot.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test1() {
        System.out.println(userMapper.selectAll());
    }
}
