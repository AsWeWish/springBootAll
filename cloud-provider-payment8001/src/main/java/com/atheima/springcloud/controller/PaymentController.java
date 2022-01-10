package com.atheima.springcloud.controller;


import com.atheima.springcloud.service.PaymentServiceImpl;
import com.common.entities.CommonResult;
import com.common.entities.Payment;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import com.netflix.discovery.shared.Applications;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private DiscoveryClient discoveryClient;

    @Resource
    private PaymentServiceImpl paymentService;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        String serial = payment.getSerial();
        System.out.println(serial);
        int result = paymentService.insert(payment);
        if (result==1){
        return new CommonResult(200,"插入成功",result);

    }else {
        return new CommonResult(404,"插入失败",null);
    }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById( @PathVariable Long id){
        Payment date = paymentService.selectById(id);
        System.out.println(id);
        System.out.println(date);
        if (date!=null){
            return new CommonResult(200,"查询成功",date);
        }else {
            return new CommonResult(404,"没有查询到相关数据,请检查",null);
        }
    }

    @GetMapping("/payment/discovery")
    @ResponseBody
    public void discovery(){
        List<String> services = discoveryClient.getServices();
        List<ServiceInstance> payment8001 = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE80011 ");
        System.out.println("services"+services);
        System.out.println("instance"+payment8001);
    }

    @GetMapping("/payment/lb")
    public String getPaymentLB(){
        return "8001";
    }
}
