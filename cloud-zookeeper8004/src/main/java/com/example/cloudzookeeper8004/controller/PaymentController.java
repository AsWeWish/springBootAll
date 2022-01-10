package com.example.cloudzookeeper8004.controller;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONConverter;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/payment/zk")
    @ResponseBody
    public String paymentZk(){
        System.out.println("springcloud with zookeeper:"+serverPort+"\t"+ UUID.randomUUID().toString());
        String obj="springcloud with zookeeper:"+serverPort+"\t"+ UUID.randomUUID().toString();
        return obj;


    }

}
