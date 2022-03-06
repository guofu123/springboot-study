//package com.kkb.ggf.controller;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//import javax.sql.DataSource;
//
//@RestController
//@Deprecated
//public class HelloController {
//
////    @Resource(name = "ds3")
////    private DataSource dataSource;
//    @Resource(name = "ds4")
//    private DataSource dataSource;
//
//    @GetMapping("/hello")
//    public String hello(){
//        return "Hello SpringBoot.";
//    }
//
////    @GetMapping("/ds3")
////    public String getDataSourceInfo(){
////        return "全注解配置数据源-----" + dataSource;
////    }
//
//    @GetMapping("/ds4")
//    public String getDataSourceInfo2(){
//        return "全注解配置数据源-----" + dataSource;
//    }
//}
