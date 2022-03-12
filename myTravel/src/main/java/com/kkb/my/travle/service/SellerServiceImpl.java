package com.kkb.my.travle.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kkb.my.travle.dao.SellerDao;
import com.kkb.my.travle.domain.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商家业务实现类
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerDao sellerDao;

    /**
     * 分页查找
     * @param condition 条件
     * @param pageNum 页码
     * @param pageSize 页大小
     * @return
     */
    @Override
    public PageInfo<Seller> findPage(Seller condition, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<Seller> wrapper = new LambdaQueryWrapper<>();
        if (condition!=null){
            if (StringUtils.isNotBlank(condition.getSname())){
                wrapper.like(Seller::getSname, condition.getSname());
            }
            if (StringUtils.isNotBlank(condition.getConsphone())){
                wrapper.like(Seller::getConsphone, condition.getConsphone());
            }
            if (StringUtils.isNotBlank(condition.getAddress())){
                wrapper.like(Seller::getAddress, condition.getAddress());
            }
        }
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(()->sellerDao.selectList(wrapper));
    }

    @Override
    public List<Seller> findList(Seller condition) {
        LambdaQueryWrapper<Seller> wrapper = new LambdaQueryWrapper<>();
        if (condition!=null){
            if (StringUtils.isNotBlank(condition.getSname())){
                wrapper.like(Seller::getSname, condition.getSname());
            }
            if (StringUtils.isNotBlank(condition.getConsphone())){
                wrapper.like(Seller::getConsphone, condition.getConsphone());
            }
            if (StringUtils.isNotBlank(condition.getAddress())){
                wrapper.like(Seller::getAddress, condition.getAddress());
            }
        }
        return sellerDao.selectList(wrapper);
    }

    /**
     * 通过主键查找
     * @param sid
     * @return
     */
    @Override
    public Seller findById(Integer sid) {
        if (sid==null || sid<0)
            return null;
        return sellerDao.selectById(sid);
    }

    @Override
    public int add(Seller seller) {
        return sellerDao.insert(seller);
    }

    @Override
    public int update(Seller seller) {
        return sellerDao.updateById(seller);
    }

    @Override
    public int delete(Integer sid) {
        return sellerDao.deleteById(sid);
    }
}
