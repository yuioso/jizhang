package com.demo.account.vo;

import lombok.AllArgsConstructor;

import lombok.Data;



@Data

@AllArgsConstructor

public class LoginVO {


    /**
     * JWT令牌
     */
    private String token;



    /**
     * 用户ID
     */
    private Long userId;



    /**
     * 用户名
     */
    private String username;



}

