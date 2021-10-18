package com.joryi.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: com.joryi.spingcloud
 * @description: lb实现类
 * @author: joryizhang
 * @create: 2021-10-18 10:45
 **/
@Component
public class MyLb implements LoadBalance {
    private AtomicInteger atomicInteger =new AtomicInteger(0);
    private final int getAndIncrement(){
        int current;
        int next;
        do{
            current=this.atomicInteger.get();
            //2147482647整形数的最大值
            next= current >= 2147482647?0:current+1;
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("第几次访问next: "+next);
        return next;
    }
    //负载均衡算法：rest接口第几次请求服务器集群总数量=实际位置下标，每次重启后服务器计数从1开始
    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
