package com.demo.account.entity;

import lombok.Data;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;



@Data
public class Bill {


    /**
     * 账单ID
     */
    private Long id;



    /**
     * 用户ID
     */
    private Long userId;



    /**
     * 分类ID
     */
    private Long categoryId;



    /**
     * 金额
     */
    private BigDecimal amount;



    /**
     * 类型
     * 1 支出
     * 2 收入
     */
    private Integer type;



    /**
     * 备注
     */
    private String remark;



    /**
     * 消费日期
     */
    private LocalDate billTime;



    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}

