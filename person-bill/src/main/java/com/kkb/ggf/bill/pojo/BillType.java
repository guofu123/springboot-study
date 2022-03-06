package com.kkb.ggf.bill.pojo;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "bill_type_")
public class BillType {

    @Id
    @Column(name = "id_")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_")
    private String name;
}
