package com.kkb.my.travle.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kkb.my.travle.domain.Route;

import java.util.List;

/**
 * 线路数据库操作的dao
 */
public interface RouteDao extends BaseMapper<Route> {
    /**
     * 分页查询，需要关联查询数据
     *
     * @param condition 查询条件
     * @return 查询结果
     */
    List<Route> find(Route condition);

    /**
     * 根据id查询
     *
     * @param rid
     * @return
     */
    Route findById(Integer rid);
}
