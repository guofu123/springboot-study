package com.kkb.my.travle.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 路线详情图片列表
 */
@Data
@TableName("tab_route_img")
public class RouteImg implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer rgid;
    private Integer rid;
    private String bigpic;
    private String smallpic;
}
