package com.kkb.ggf.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kkb.ggf.bean.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Resource
    private UserDao userDao;

    @Test
    public void getAll() {
        List<User> users = userDao.selectList(null);
        users.forEach(u -> {
            System.out.println(u);
        });
    }

    // 新增
    @Test
    public void insertOne() {
        User user = new User();
        user.setName("国服");
        user.setAge(18);
        user.setEmail("3165177264@qq.com");
        user.setPhone("17860635787");
        int num = userDao.insert(user);
        Assert.assertTrue(num > 0);
        userDao.selectList(null).forEach(System.out::println);
    }

    // 删除测试
    @Test
    public void deleteTest() {
        // 主键删除
//        int i = userDao.deleteById(4);

        // 批量删除1
//        int delete = userDao.delete(new QueryWrapper<User>().like("name", "kai"));
//        System.out.println("deleteNums: "+ delete);
        // 批量删除2
//        int delete = userDao.delete(Wrappers.<User>query().like("name", "kai"));
//        System.out.println("deleteNums: "+ delete);
        // 批量删除3
        int delete = userDao.delete(Wrappers.<User>query().lambda().like(User::getName, "kaike"));
        System.out.println("deleteNums: "+ delete);

        userDao.selectList(null).forEach(System.out::println);
    }

    // 更新测试
    @Test
    public void updateTest(){
        // 通过主键进行更新
//        User user = new User();
//        user.setId(2L);
//        user.setName("国富");
//        user.setAge(20);
//        userDao.updateById(user);

        // 批量更新1
//        int update = userDao.update(null, Wrappers.<User>update().set("email", "1371112@qq.com").like("name", "kai"));
//        System.out.println("updates:"+update);
        // 批量更新2
        User user = new User();
        user.setEmail("1371112@qq.com");
        int update = userDao.update(user, Wrappers.<User>update().like("name", "kai"));
        System.out.println("updates:"+update);

        userDao.selectList(null).forEach(System.out::println);
    }

    // 查询测试
    @Test
    public void selectTest(){
//        User one = userDao.selectOne(Wrappers.<User>query().eq("name", "Sandy"));
//        System.out.println(one);

        // 查询部分字段（投影查询）
        userDao.selectList(Wrappers.<User>query().select("id","name")).forEach(System.out::println);

    }

    // 测试分页查询
    @Test
    public void pageSelectTest(){
        // 内置分页插件
        Page<User> page = new Page<>(1, 5);
//        QueryWrapper<User> age1 = new QueryWrapper<User>().eq("age", 331);
        QueryWrapper<User> age = Wrappers.<User>query().eq("age", 331);
        Page<User> userPage = userDao.selectPage(page, age);
        System.out.println("count："+ userPage.getTotal());
        userPage.getRecords().forEach(System.out::println);
    }

}







