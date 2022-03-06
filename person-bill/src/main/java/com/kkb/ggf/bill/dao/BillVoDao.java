package com.kkb.ggf.bill.dao;

import com.kkb.ggf.bill.pojo.BillVo;
import com.kkb.ggf.bill.vo.BillSearchVo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BillVoDao extends Mapper<BillVo> {

    List<BillVo> getBillPage(BillSearchVo vo);
}
