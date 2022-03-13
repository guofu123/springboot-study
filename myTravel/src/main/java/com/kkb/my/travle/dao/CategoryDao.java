package com.kkb.my.travle.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kkb.my.travle.domain.Category;
import org.apache.ibatis.annotations.Select;

public interface CategoryDao extends BaseMapper<Category> {

    @Select("select cid,cname from tab_category where cid = #{cid}")
    public Category findById(Integer cid);

}
