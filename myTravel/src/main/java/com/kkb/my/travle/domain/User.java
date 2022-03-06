package com.kkb.my.travle.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 用户实体对象
 */
@Data
@TableName("tab_user")
public class User {
    @TableId(type = IdType.AUTO)
    private Integer uid;
    private String username;
    private String password;
    private String name;
    private Date birthday;
    private String sex;
    private String telephone;
    private String email;
    private String status;
    private String code;
    private Boolean isadmin;
}
