package com.kkb.ggf.config;

//import com.alibaba.druid.pool.DruidDataSource;
import com.kkb.ggf.property.JdbcProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * 配置类
 */
@Configuration
//@EnableConfigurationProperties(JdbcProperties.class)
public class JdbcConfig {

    // 注册一个数据源的bean
    // @Autowired可以省略
//    @Bean("ds3")
//    public DataSource getDataSource(@Autowired JdbcProperties jdbc){
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setDriverClassName(jdbc.getDriverClassName());
//        dataSource.setUrl(jdbc.getUrl());
//        dataSource.setUsername(jdbc.getUsername());
//        dataSource.setPassword(jdbc.getPassword());
//        return dataSource;
//    }

}









