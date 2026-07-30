package com.demo.account.entity;


import lombok.Data;

import java.time.LocalDateTime;



@Data
public class User {


    /**
     * 用户ID
     */
    private Long id;



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



    /**
     * 头像
     */
    private String avatar;



    /**
     * 创建时间
     */
    private LocalDateTime createTime;



    /**
     * 更新时间
     */
    private LocalDateTime updateTime;



}

