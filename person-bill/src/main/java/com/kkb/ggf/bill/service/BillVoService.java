package com.kkb.ggf.bill.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kkb.ggf.bill.dao.BillVoDao;
import com.kkb.ggf.bill.pojo.BillVo;
import com.kkb.ggf.bill.vo.BillSearchVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class BillVoService {

    @Resource
    private BillVoDao billVoDao;

    /**
     * 分页查询
     *
     * @param vo       查询条件
     * @param pageNum  页码
     * @param pageSize 一页大小
     * @return 返回查询结果
     */
    public PageInfo<BillVo> getListPage(BillSearchVo vo, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        // 多条件查询条件
        List<BillVo> billPage = billVoDao.getBillPage(vo);
        if (billPage==null){
            billPage = new ArrayList<>();
        }
        return new PageInfo<>(billPage);
    }

    /**
     * 通过主键查询账单记录
     * @param id 主键id
     * @return 查询结果
     */
    public BillVo getBillVoById(Long id){
        return billVoDao.selectByPrimaryKey(id);
    }

    /**
     * 新增账单记录，没有数据校验
     * @param record 新增的数据
     * @return 新增情况
     */
    public int addOneBill(BillVo record){
        return billVoDao.insertSelective(record);
    }

    /**
     * 更新账单记录，没有添加数据检查
     * @param record 更新的信息
     * @return 更新情况
     */
    public int updateOneBill(BillVo record){
        return billVoDao.updateByPrimaryKeySelective(record);
    }

    /**
     * 删除账单记录，根据主键删除
     * @param id 账单记录id
     * @return 删除情况
     */
    public int deleteOneBill(Long id){
        return billVoDao.deleteByPrimaryKey(id);
    }

}







