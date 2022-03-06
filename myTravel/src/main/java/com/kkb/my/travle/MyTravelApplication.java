package com.kkb.my.travle;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.kkb.my.travle.dao")
public class MyTravelApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyTravelApplication.class,args);
    }
}

