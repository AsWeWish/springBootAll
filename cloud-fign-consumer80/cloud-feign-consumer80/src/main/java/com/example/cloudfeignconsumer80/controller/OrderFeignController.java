package com.example.cloudfeignconsumer80.controller;

import com.common.entities.CommonResult;
import com.common.entities.Payment;
import com.example.cloudfeignconsumer80.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderFeignController {

    @Resource
    private PaymentService service;
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById (@PathVariable("id") Long id){
        System.out.println(id);
        return service.getPaymentById(id);
    }

}
