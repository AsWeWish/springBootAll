package com.example.cloudconsumerconsul80;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudConsumerConsul80Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerConsul80Application.class, args);
    }

}
