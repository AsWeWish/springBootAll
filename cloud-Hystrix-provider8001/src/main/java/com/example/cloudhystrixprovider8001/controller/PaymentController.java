package com.example.cloudhystrixprovider8001.controller;


import com.example.cloudhystrixprovider8001.service.PaymentService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController  {
    @Autowired
    private PaymentService service;
    @Value("8001")
    private String serverport;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id){
       return service.paymentInfo_ok(id);
    }

    @SneakyThrows
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_timeout(@PathVariable("id") Integer id){
        return service.paymentInfo_timeout(id);
    }
}
