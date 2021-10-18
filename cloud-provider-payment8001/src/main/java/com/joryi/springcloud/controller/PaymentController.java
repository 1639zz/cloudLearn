package com.joryi.springcloud.controller;



import com.joryi.springcloud.entities.CommonResult;
import com.joryi.springcloud.entities.Payment;
import com.joryi.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    private DiscoveryClient discoveryClient;
    

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
//    @GetMapping(value = "/discovery")
//    public Object discovery(){
//        //获得服务清单列表
//        List<String> services = discoveryClient.getServices();
//        for(String service: services){
//            log.info("*****service: " + service);
//        }
//        // 根据具体服务进一步获得该微服务的信息
//        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-ORDER-SERVICE");
//        for(ServiceInstance serviceInstance:instances){
//            log.info(serviceInstance.getServiceId() + "\t" + serviceInstance.getHost()
//                    + "\t" + serviceInstance.getPort() + "\t" + serviceInstance.getUri());
//        }
//        return this.discoveryClient;
//    }

}


