package com.kkb.my.travle.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kkb.my.travle.dao.RouteDao;
import com.kkb.my.travle.domain.Route;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 线路业务实现类
 */
@Service
public class RouteServiceImpl implements RouteService {

    @Resource
    private RouteDao routeDao;

    @Override
    public PageInfo<Route> findPage(Route condition, Integer pageNum, Integer pageSize) {
        return PageHelper.startPage(pageNum,pageSize).doSelectPageInfo(()->routeDao.find(condition));
    }

    @Override
    public Route findById(Integer rid) {
        return routeDao.findById(rid);
    }

    @Override
    public int add(Route route) {
        // 默认是上架
        route.setRflag("1");
        return routeDao.insert(route);
    }

    @Override
    public int update(Route route) {
        return routeDao.updateById(route);
    }

    @Override
    public int delete(Integer rid) {
        Route route = new Route();
        route.setRid(rid);
        // 设置为下架
        route.setRflag("0");
        return routeDao.updateById(route);
    }
}
