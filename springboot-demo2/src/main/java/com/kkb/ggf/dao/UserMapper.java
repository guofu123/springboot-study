package com.kkb.ggf.dao;

import com.kkb.ggf.bean.User;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User> {

    List<User> findByNameAndNote(User user);
}
