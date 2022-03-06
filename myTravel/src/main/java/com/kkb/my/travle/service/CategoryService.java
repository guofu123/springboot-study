package com.kkb.my.travle.service;

import com.kkb.my.travle.domain.Category;

import java.util.List;

/**
 * 线路分类业务接口
 */
public interface CategoryService {

    List<Category> list();
    Category getById(Integer cid);
    Integer add(Category category);
    Integer update(Category category);
    Integer delete(Integer cid);
}
