package com.kkb.my.travle.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 线路实体类
 */
@Data
@TableName("tab_route")
public class Route implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer rid;
    private String rname;
    private Double price;
    @TableField("routeIntroduce")
    private String routeIntroduce;
    // 0代表没有上架，1代表是上架
    private String rflag;
    private String rdate;
    private String isThemeTour;
    private Integer count;
    private Integer cid;
    private String rimage;
    private Integer sid;
    private String sourceId;

    /* 关联查询的数据 */
    // 所属分类
    @TableField(exist = false)
    private Category category;
    // 所属商家
    @TableField(exist = false)
    private Seller seller;
    // 路线相关的陆翩列表
    @TableField(exist = false)
    private List<RouteImg> routeImgList;


}
