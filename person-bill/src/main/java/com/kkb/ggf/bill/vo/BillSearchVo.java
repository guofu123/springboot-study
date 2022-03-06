package com.kkb.ggf.bill.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 用于查询账单的对象
 */
@Data
public class BillSearchVo {

    private String title;
    private Long typeId;

    private Double price;
    private String explain;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;


}
