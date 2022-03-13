package com.kkb.my.travle.service;

import com.github.pagehelper.PageInfo;
import com.kkb.my.travle.domain.Route;

/**
 * 线路业务接口
 */
public interface RouteService {

    PageInfo<Route> findPage(Route condition, Integer pageNum, Integer pageSize);
    Route findById(Integer rid);
    int add(Route route);
    int update(Route route);
    int delete(Integer rid);

}
