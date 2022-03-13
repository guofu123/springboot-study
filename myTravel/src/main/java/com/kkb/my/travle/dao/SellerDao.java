package com.kkb.my.travle.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kkb.my.travle.domain.Seller;
import org.apache.ibatis.annotations.Select;

/**
 * 商家dao接口
 */
public interface SellerDao extends BaseMapper<Seller> {

    @Select("select * from tab_seller where sid = #{sid}")
    Seller findById(Integer sid);

}
