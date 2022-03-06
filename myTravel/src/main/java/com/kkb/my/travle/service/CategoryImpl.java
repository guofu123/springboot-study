package com.kkb.my.travle.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kkb.my.travle.dao.CategoryDao;
import com.kkb.my.travle.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 线路分类实现类
 */
@Service
public class CategoryImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    /**
     * 查询所有
     * @return
     */
    @Override
    public List<Category> list() {
        QueryWrapper<Category> categoryQueryWrapper = new QueryWrapper<>();
        categoryQueryWrapper.orderByAsc("cid");
        return categoryDao.selectList(categoryQueryWrapper);
    }

    @Override
    public Category getById(Integer cid) {
        return categoryDao.selectById(cid);
    }

    @Override
    public Integer add(Category category) {
        return categoryDao.insert(category);
    }

    @Override
    public Integer update(Category category) {
        return categoryDao.updateById(category);
    }

    @Override
    public Integer delete(Integer cid) {
        return categoryDao.deleteById(cid);
    }
}
