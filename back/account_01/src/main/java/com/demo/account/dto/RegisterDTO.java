package com.demo.account.dto;


import lombok.Data;



@Data
public class RegisterDTO {


    /**
     * 用户名
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 昵称
     */
    private String nickname;


}

