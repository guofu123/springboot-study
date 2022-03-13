package com.kkb.my.travle.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.kkb.my.travle.dao.RouteImgDao;
import com.kkb.my.travle.domain.RouteImg;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Wrapper;
import java.util.List;

@Service
public class RouteImgServiceImpl implements RouteImgService {

    @Resource
    private RouteImgDao routeImgDao;

    /**
     * 保存路线的图片
     *
     * @param rid
     * @param routeImgs
     */
    @Override
    public void saveImgs(Integer rid, List<RouteImg> routeImgs) {
        // 删除原来的
        routeImgDao.delete(Wrappers.<RouteImg>query().eq("rid", rid));
        // 保存提交的
        for (RouteImg img : routeImgs) {
            routeImgDao.insert(img);
        }
    }
}
