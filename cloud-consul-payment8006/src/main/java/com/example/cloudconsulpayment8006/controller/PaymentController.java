package com.example.cloudconsulpayment8006.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/payment/consul")
    @ResponseBody
    public String paymentConsule(){
        return "consul"+serverPort+"\t"+ UUID.randomUUID().toString();
    }
}
