package com.expample.controller;



import com.common.entities.CommonResult;
import com.common.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;


    @PostMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        System.out.println(payment);
        CommonResult<Payment> forObject = restTemplate.postForObject("http://CLOUD-PAYMENT-SERVICE80011/payment/create", payment, CommonResult.class);
        return forObject;
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        CommonResult forObject = restTemplate.getForObject("http://CLOUD-PAYMENT-SERVICE80011/payment/get/" + id, CommonResult.class, id);
        System.out.println(forObject);
        return forObject;
    }

    @GetMapping("/consumer/payment/test")
    @ResponseBody
    public CommonResult<Payment> rbbonTest(){
        ResponseEntity<CommonResult> test = restTemplate.getForEntity("http://CLOUD-PAYMENT-SERVICE80011/payment/get/test", CommonResult.class, "test");
        HttpStatus statusCode = test.getStatusCode();
        if (statusCode.equals(200)){
            return test.getBody();
        }else {
            return new CommonResult<Payment>(404,"返回信息异常",null);
        }
    }



}
