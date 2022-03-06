package com.kkb.ggf.dao;

import com.kkb.ggf.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//@Mapper
public interface UserDao {


    List<User> getAll();

}
