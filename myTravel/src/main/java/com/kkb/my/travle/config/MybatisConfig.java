package com.kkb.my.travle.config;

import com.github.pagehelper.PageInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 配置mybatis
 */
@Configuration

public class MybatisConfig {

    /**
     * pagehelper的分页插件
     */
    @Bean
    public PageInterceptor pageInterceptor() {
        return new PageInterceptor();
    }

}
