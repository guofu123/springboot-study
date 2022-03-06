package com.kkb.ggf.bill.service;

import com.github.pagehelper.PageInfo;
import com.kkb.ggf.bill.pojo.BillVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.ParseException;
@RunWith(SpringRunner.class)
@SpringBootTest
public class BillVoServiceTest {

    @Resource
    private BillVoService billVoService;

    @Test
    public void getListPage() throws ParseException {
//        BillVo billVo = new BillVo();
//        billVo.setTitle("交通");
//        billVo.setTypeId(2L);
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        billVo.setStartTime(dateFormat.parse("2020-05-27"));
        PageInfo<BillVo> listPage = billVoService.getListPage(null, 2, 2);
        listPage.getList().forEach(System.out::println);
        System.out.println("总记录数:" +listPage.getTotal());
    }
}