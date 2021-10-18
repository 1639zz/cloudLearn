package com.joryi.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: com.joryi.spingcloud
 * @description: ConsulProviderMain8006主启动类
 * @author: joryizhang
 * @create: 2021-10-17 18:27
 **/
@SpringBootApplication
@EnableDiscoveryClient // 提供者
public class PaymentMain8006 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8006.class,args);
    }
}

