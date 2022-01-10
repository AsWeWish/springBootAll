package com.example.cloudfeignconsumer80;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CloudFeignConsumer80Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudFeignConsumer80Application.class, args);
    }

}
