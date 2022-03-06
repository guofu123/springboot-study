package com.kkb.ggf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.mybatis.spring.annotation.MapperScan;
// tk.mybatis的扫描
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 启动类
 */
@SpringBootApplication
@MapperScan("com.kkb.ggf.dao")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
