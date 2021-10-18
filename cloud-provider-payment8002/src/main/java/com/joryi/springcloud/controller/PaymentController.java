package com.joryi.springcloud.controller;



import com.joryi.springcloud.entities.CommonResult;
import com.joryi.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.joryi.springcloud.service.PaymentService;

import javax.annotation.Resource;

/**
 * @program: com.joryi.spingcloud
 * @description: PaymentController
 * @author: joryizhang
 * @create: 2021-10-15 17:50
 **/

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    //只传给前端CommonResult，不需要前端了解其他的组件
    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("插入结果："+result);
        if(result > 0){
            return new CommonResult(200,"插入数据成功: "+serverPort,result);
        }else{
            return new CommonResult(444,"插入数据失败",null);
        }
    }
    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果："+payment);
        if(payment != null){
            return new CommonResult(200,"查询成功: "+serverPort,payment);
        }else{
            return new CommonResult(444,"没有对应记录,查询ID："+id,null);
        }
    }
    @GetMapping("/lb")
    public String getPaymentLB(){
        return serverPort;
    }
}


