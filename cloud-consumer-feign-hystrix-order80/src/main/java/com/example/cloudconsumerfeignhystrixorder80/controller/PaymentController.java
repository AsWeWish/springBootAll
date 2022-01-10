package com.example.cloudconsumerfeignhystrixorder80.controller;

import com.example.cloudconsumerfeignhystrixorder80.service.service;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class PaymentController {
    @Autowired
    private service  service;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id){
       return service.paymentInfo_ok(id);
    }

    @HystrixCommand
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_timeout(@PathVariable("id") Integer id){
        return service.paymentInfo_timeout(id);
    }

    public String payment_Global_FallbackMethod(){
        return "本地延迟大,请刷新";
    }
}
