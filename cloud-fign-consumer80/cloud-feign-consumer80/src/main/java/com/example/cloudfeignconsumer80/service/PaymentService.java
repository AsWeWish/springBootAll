package com.example.cloudfeignconsumer80.service;

import com.common.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component//加入到Ioc容器中
@FeignClient(value = "CLOUD-PAYMENT-SERVICE8001")//是一个Feign的客户端
public interface PaymentService {

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable Long id);
}
