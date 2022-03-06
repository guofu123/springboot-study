package com.kkb.ggf.dao;

import com.kkb.ggf.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectAll(){
        userMapper.selectAll().forEach(user -> {
            System.out.println(user);
        });
    }

    @Test
    public void selectById(){
        User user = userMapper.selectByPrimaryKey(4);
        System.out.printf(user.toString());
    }

    @Test
    public void findByNameAndNote(){
        User user = new User();
        user.setUserName("a");
        user.setNote("J");
        // 使用了自定义的xml进行查询，不支持驼峰和下划线的自动转换
        userMapper.findByNameAndNote(user).forEach(user1 -> {
            System.out.println(user1);
        });
    }

    @Test
    public void findByNameAndNote2(){

        Example example = new Example(User.class);
        example.createCriteria().andLike("userName","%a%")
                .andLike("note","%J%");
        userMapper.selectByExample(example).forEach(user -> {
            System.out.println(user.toString());
        });
    }

    @Test
    public void addTest(){
        User user = new User();
        user.setUserName("guofu");
        user.setName("国赋");
        user.setAge(23);
        int i = userMapper.insertSelective(user);
        System.out.println(i);
    }


}