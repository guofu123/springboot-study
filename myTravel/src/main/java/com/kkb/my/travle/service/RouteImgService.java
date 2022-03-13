package com.kkb.my.travle.service;

import com.kkb.my.travle.domain.RouteImg;

import java.util.List;

/**
 * 存储路线大小图片的业务接口
 */
public interface RouteImgService {

    /**
     * 保存路线的图片
     * @param rid
     * @param routeImgs
     */
    void saveImgs(Integer rid, List<RouteImg> routeImgs);
}
