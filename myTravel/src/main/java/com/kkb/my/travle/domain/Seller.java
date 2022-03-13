package com.kkb.my.travle.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 所属商家
 */
@Data
@TableName("tab_seller")
public class Seller implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer sid;
    private String sname;
    private String consphone;
    private String address;

}
