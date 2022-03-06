package com.kkb.my.travle.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kkb.my.travle.dao.UserDao;
import com.kkb.my.travle.domain.User;
import com.kkb.my.travle.util.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户业务实现类
 */
@Service
public class UserServiceImpl implements UserService{

    /**
     * 用户数据库操作对象
     */
    @Resource
    private UserDao userDao;

    /**
     * 分页查询
     *
     * @param condition 查询条件
     * @param pageNum   页码
     * @param pageSize  页大小
     * @return 查询结果
     */
    @Override
    public PageInfo<User> findPage(User condition, int pageNum, int pageSize) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        if (condition!=null){
            if (condition.getUid()!=null){
                wrapper.eq(User::getUid, condition.getUid());
            }
            if (StringUtils.isNotBlank(condition.getUsername())){
                wrapper.like(User::getUsername, condition.getUsername());
            }
            if (StringUtils.isNotBlank(condition.getPassword())){
                wrapper.eq(User::getPassword, condition.getPassword());
            }
            if (StringUtils.isNotBlank(condition.getName())){
                wrapper.like(User::getName, condition.getName());
            }
            if (condition.getBirthday()!=null){
                wrapper.eq(User::getBirthday, DateUtil.strToDateTime(condition.getBirthday()));
            }
            if (condition.getSex()!=null){
                wrapper.eq(User::getSex, condition.getSex());
            }
            if (condition.getTelephone()!=null){
                wrapper.like(User::getTelephone, condition.getEmail());
            }
            if (condition.getEmail()!=null){
                wrapper.like(User::getEmail, condition.getEmail());
            }
            if (condition.getStatus()!=null){
                wrapper.eq(User::getStatus, condition.getStatus());
            }
            if (condition.getCode()!=null){
                wrapper.eq(User::getCode, condition.getCode());
            }
            if (condition.getIsadmin()!=null){
                wrapper.eq(User::getIsadmin, condition.getIsadmin());
            }
        }
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> userDao.selectList(wrapper));
    }

    /**
     * 查询
     *
     * @param condition 查询条件
     * @return 查询结果
     */
    @Override
    public List<User> find(User condition) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        if (condition!=null){
            if (condition.getUid()!=null){
                wrapper.eq(User::getUid, condition.getUid());
            }
            if (StringUtils.isNotBlank(condition.getUsername())){
                wrapper.like(User::getUsername, condition.getUsername());
            }
            if (StringUtils.isNotBlank(condition.getPassword())){
                wrapper.eq(User::getPassword, condition.getPassword());
            }
            if (StringUtils.isNotBlank(condition.getName())){
                wrapper.like(User::getName, condition.getName());
            }
            if (condition.getBirthday()!=null){
                wrapper.eq(User::getBirthday, DateUtil.strToDateTime(condition.getBirthday()));
            }
            if (condition.getSex()!=null){
                wrapper.eq(User::getSex, condition.getSex());
            }
            if (condition.getTelephone()!=null){
                wrapper.like(User::getTelephone, condition.getEmail());
            }
            if (condition.getEmail()!=null){
                wrapper.like(User::getEmail, condition.getEmail());
            }
            if (condition.getStatus()!=null){
                wrapper.eq(User::getStatus, condition.getStatus());
            }
            if (condition.getCode()!=null){
                wrapper.eq(User::getCode, condition.getCode());
            }
            if (condition.getIsadmin()!=null){
                wrapper.eq(User::getIsadmin, condition.getIsadmin());
            }
        }
        return userDao.selectList(wrapper);
    }

    /**
     * 根据主键查询
     * @param uid 主键id
     * @return
     */
    @Override
    public User findById(Integer uid) {
        return userDao.selectById(uid);
    }

    /**
     * 添加
     *
     * @param user
     * @return
     */
    @Override
    public int add(User user) {
        // 添加的用户默认是启用的
        user.setStatus("Y");
        return userDao.insert(user);
    }

    /**
     * 更新,没有添加校验
     *
     * @param user
     * @return
     */
    @Override
    public int update(User user) {
        return userDao.updateById(user);
    }

    /**
     * 删除
     *
     * @param uid 主键
     * @return
     */
    @Override
    public int delete(Integer uid) {
        return userDao.deleteById(uid);
    }
}
