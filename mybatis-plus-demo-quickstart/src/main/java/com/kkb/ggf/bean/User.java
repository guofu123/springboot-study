package com.kkb.ggf.bean;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@Data
@TableName("user2")
public class User {
    @TableId
    private Long id;
    private String name;
    private Integer age;
    private String email;
    @TableField(exist = false)
    private String phone;
}
