package com.kkb.ggf.dao;

import com.kkb.ggf.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> findAll(){
        return jdbcTemplate.query("select * from tb_user",new BeanPropertyRowMapper<>(User.class));
    }


}
