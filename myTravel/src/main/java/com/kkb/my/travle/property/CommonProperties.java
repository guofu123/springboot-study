package com.kkb.my.travle.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 常用的配置参数
 * 需要写非静态的setter，getter方法可以静态也可以非静态
 */
@Component
@ConfigurationProperties(prefix = "mytravel")
public class CommonProperties {

    private static String uploadPath;


    public static String getFileUploadPath(){
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        CommonProperties.uploadPath = uploadPath;
    }
}
