package com.demo.account.config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {




    /**
     * 密码加密工具
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();

    }





    /**
     * Spring Security配置
     */
    @Bean
    public SecurityFilterChain filterChain(
            HttpSecurity http
    ) throws Exception {



        http

                //关闭csrf
                .csrf(
                        csrf -> csrf.disable()
                )


                //关闭默认登录页面
                .formLogin(
                        form -> form.disable()
                )


                //关闭http basic认证
                .httpBasic(
                        basic -> basic.disable()
                )


                //接口权限设置
                .authorizeHttpRequests(
                        auth -> auth


                                //注册登录不需要认证
                                .requestMatchers(
                                        "/user/register",
                                        "/user/login"
                                )
                                .permitAll()


                                //其他接口允许访问
                                //暂时方便开发测试
                                .anyRequest()
                                .permitAll()

                );



        return http.build();


    }




}

