package com.joryi.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @program: com.joryi.spingcloud
 * @description: Orderzk80主启动类
 * @author: joryizhang
 * @create: 2021-10-17 18:13
 **/
@SpringBootApplication
@EnableEurekaClient
public class OrderMain81 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain81.class,args);
    }
}
