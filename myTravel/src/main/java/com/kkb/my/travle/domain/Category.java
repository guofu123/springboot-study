package com.kkb.my.travle.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 线路分类
 */
@Data
@TableName("tab_category")
public class Category {
    @TableId(type = IdType.AUTO)
    private Integer cid;
    private String cname;
}
