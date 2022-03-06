package com.kkb.ggf.bill.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "bill_")
public class BillVo {

    /**
     * 对应数据库表的字段,作为接收对象的时候会对字段进行校验，需要添加BindingResult
     */
    @Id
    @Column(name = "id_")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title_")
    private String title;
    @Column(name = "bill_time_")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date billTime;
    @Column(name = "type_id_")
    private Long typeId;
    @Column(name = "price_")
    private Double price;
    @Column(name = "explain_")
    private String explain;

    /**
     * 类别名称
     */
    @Transient
    private String typeName;

    /**
     * 作为查询条件，开始时间和结束时间
     */
    @Transient
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startTime;
    @Transient
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;


}
