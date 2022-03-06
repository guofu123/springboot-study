package com.kkb.ggf.bill.service;

import com.kkb.ggf.bill.dao.BillTypeDao;
import com.kkb.ggf.bill.pojo.BillType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BillTypeService {

    @Resource
    private BillTypeDao billTypeDao;

    /**
     * 获取所有的账单类型
     */
    public List<BillType> getAllBillType(){
        return billTypeDao.selectAll();
    }
}
