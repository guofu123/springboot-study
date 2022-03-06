package com.kkb.my.travle.service;

import com.github.pagehelper.PageInfo;
import com.kkb.my.travle.domain.User;

import java.util.List;

/**
 * 用户业务操作接口
 */
public interface UserService {
    /**
     * 分页查询
     * @param condition 查询条件
     * @param pageNum 页码
     * @param pageSize 页大小
     * @return 查询结果
     */
    PageInfo<User> findPage(User condition, int pageNum, int pageSize);

    /**
     * 查询
     * @param condition 查询条件
     * @return 查询结果
     */
    List<User> find(User condition);

    /**
     * 根据主键查询
     * @param uid 主键id
     * @return
     */
    User findById(Integer uid);

    /**
     * 添加
     * @param user
     * @return
     */
    int add(User user);

    /**
     * 更新
     * @param user
     * @return
     */
    int update(User user);

    /**
     * 删除
     * @param uid 主键
     * @return
     */
    int delete(Integer uid);
}
