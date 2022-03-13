package com.kkb.my.travle.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kkb.my.travle.domain.RouteImg;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RouteImgDao extends BaseMapper<RouteImg> {

    @Select("select * from tab_route_img where rid = #{rid}")
    List<RouteImg> findByRid(Integer rid);

    
}
