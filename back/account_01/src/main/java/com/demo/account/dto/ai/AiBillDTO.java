package com.demo.account.dto.ai;

import lombok.Data;


import java.math.BigDecimal;
import java.time.LocalDate;



@Data
public class AiBillDTO {


    /**
     * 金额
     */
    private BigDecimal amount;



    /**
     * 分类
     */
    private String category;



    /**
     * 类型
     */
    private Integer type;



    /**
     * 备注
     */
    private String remark;



    /**
     * 日期
     */
    private String billTime;



}

