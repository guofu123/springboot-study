package com.kkb.ggf.bill.config;

import com.github.pagehelper.PageInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * show Myabtis的配置
 *
 * @author guguofu
 * @since 2021/12/2
 */
@Configuration
public class MybatisConfig {

    /**
     * 配置分页插件
     */
    @Bean
    public PageInterceptor pageInterceptor(){
        return new PageInterceptor();
    }
}
