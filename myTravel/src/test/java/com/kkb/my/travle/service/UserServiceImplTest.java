package com.kkb.my.travle.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.kkb.my.travle.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Resource
    private UserService userService;

    @Test
    public void findPage() {
        User user = new User();
        user.setPassword("1");
        PageInfo<User> page = userService.findPage(user, 1, 2);
        System.out.println("pages： "+page.getPages());
        System.out.println("total： "+page.getTotal());
        for (User u : page.getList()) {
            System.out.println("==>" + u);
        }

    }

}