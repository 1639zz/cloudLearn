package com.joryi.springcloud.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @program: com.joryi.spingcloud
 * @description: 配置文件类
 * @author: joryizhang
 * @create: 2021-10-15 23:12
 **/
@SpringBootConfiguration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced // 继续加上这个
    public RestTemplate getTemplate(){
        return new RestTemplate();
    }
}