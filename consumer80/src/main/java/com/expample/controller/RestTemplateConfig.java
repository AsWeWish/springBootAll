package com.expample.controller;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.lang.annotation.ElementType;
import java.nio.charset.Charset;
/**
 * 描述：
 *
 * @author xxx
 * @create 2019-07-25-15:55
 */
@Configuration
public class RestTemplateConfig {

    @Bean
//    @LoadBalanced
    public RestTemplate restTemplate(ClientHttpRequestFactory factory){
        RestTemplate restTemplate= new RestTemplate(factory);
        // 支持中文编码
        restTemplate.getMessageConverters().set(1,
                new StringHttpMessageConverter(Charset.forName("UTF-8")));
        return restTemplate;

    }

    @Bean
//    @LoadBalanced
    public ClientHttpRequestFactory simpleClientHttpRequestFactory(){
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(5000);//单位为ms
        factory.setConnectTimeout(5000);//单位为ms
        return factory;
    }
}
