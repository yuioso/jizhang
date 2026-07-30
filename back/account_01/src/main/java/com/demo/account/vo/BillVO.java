package com.demo.account.vo;

import lombok.Data;


import java.math.BigDecimal;
import java.time.LocalDate;



@Data
public class BillVO {


    private Long id;


    /**
     * 分类名称
     */
    private String categoryName;


    /**
     * 金额
     */
    private BigDecimal amount;


    /**
     * 类型
     */
    private Integer type;



    private String remark;



    private LocalDate billTime;



}

