package com.kkb.ggf.config;

import com.kkb.ggf.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Bean
    public LoginInterceptor abInterceptor(){
        return new LoginInterceptor();
    }

    /**
     * path路径匹配通配符 ‘?’ 匹配任何单字符 、
     * ‘*’ 匹配0或者任意数量的字符
     * ‘/**’ 匹配0或者更多的目录
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.abInterceptor()).addPathPatterns("/**");
    }
}
