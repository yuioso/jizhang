package com.demo.account.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration

@MapperScan("com.demo.account.mapper")

public class MyBatisConfig {


}
