package com.joryi.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @program: com.joryi.spingcloud
 * @description: PaymentController控制类
 * @author: joryizhang
 * @create: 2021-10-16 22:29
 **/
@RestController
@RequestMapping("/payment")
public class PaymentController {
      @Value("${server.port}")
      private String serverPort;
      @GetMapping("/zk")
      public String paymentZk(){
          return "springcloud with zk: "+serverPort+"\t"+ UUID.randomUUID().toString();
      }
}
