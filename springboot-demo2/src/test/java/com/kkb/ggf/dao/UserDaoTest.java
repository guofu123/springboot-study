package com.kkb.ggf.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Autowired
    private JdbcDao jdbcDao;

    @Autowired
    private UserDao userDao;

    @Test
    public void findAll() {
        jdbcDao.findAll().forEach(user -> {
            System.out.println(user);
        });
    }

    @Test
    public void getAll() {
        userDao.getAll().forEach(user -> {
            System.out.println(user);
        });

    }
}