package com.atheima.springcloud.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.common.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

import org.springframework.context.annotation.Configuration;

@Mapper
@Configuration
public interface PaymentDao extends BaseMapper<Payment> {
}
