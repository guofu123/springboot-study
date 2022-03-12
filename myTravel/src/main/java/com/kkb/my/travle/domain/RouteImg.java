package com.kkb.my.travle.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 路线详情图片列表
 */
@TableName("tab_route_img")
public class RouteImg {
    @TableId(type = IdType.AUTO)
    private Integer rgid;
    private Integer rid;
    private String bigpic;
    private String smallpic;
}
