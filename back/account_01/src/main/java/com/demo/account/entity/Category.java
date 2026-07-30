package com.demo.account.entity;

import lombok.Data;


import java.time.LocalDateTime;



@Data
public class Category {



    private Long id;



    private Long userId;



    private String name;



    /**
     * 1支出
     * 2收入
     */
    private Integer type;



    private String icon;



    private LocalDateTime createTime;


}

