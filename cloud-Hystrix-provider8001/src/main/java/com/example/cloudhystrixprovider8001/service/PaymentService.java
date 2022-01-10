package com.example.cloudhystrixprovider8001.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {


    public String paymentInfo_ok(Integer id){
        return "线程池"+Thread.currentThread().getName()+"paymentInfo_OK,id:"+id+"\t"+"哈哈";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_timeoutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5020")
    })
    public String paymentInfo_timeout(Integer id) throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        return "线程池"+Thread.currentThread().getName()+"paymentInfo_OK,id:"+id+"\t"+"执行需要3s";
    }

    public String paymentInfo_timeoutHandler(Integer id){
        return "线程池"+Thread.currentThread().getName()+"paymentInfo_OK,id:"+id+"\t"+"等会访问不行吗?点啥点啥!";
    }
}
