package com.atheima.springcloud.service;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.common.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Mapper
@Configuration
public interface PaymentServiceImpl extends BaseMapper<Payment> {


}
