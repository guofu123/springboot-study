package com.kkb.ggf.service;

import com.kkb.ggf.bean.User;
import com.kkb.ggf.dao.UserDao;
import com.kkb.ggf.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getAll(){
        return userMapper.selectAll();
    }

}
