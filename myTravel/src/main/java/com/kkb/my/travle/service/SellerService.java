package com.kkb.my.travle.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.kkb.my.travle.domain.Seller;

import java.util.List;

/**
 * 商家业务接口
 */
public interface SellerService {

    PageInfo<Seller> findPage(Seller condition, Integer pageNum, Integer pageSize);
    List<Seller> findList(Seller seller);
    Seller findById(Integer sid);
    int add(Seller seller);
    int update(Seller seller);
    int delete(Integer sid);
}
