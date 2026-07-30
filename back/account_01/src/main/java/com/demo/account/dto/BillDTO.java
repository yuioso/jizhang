package com.demo.account.dto;


import lombok.Data;


import java.math.BigDecimal;
import java.time.LocalDate;



@Data
public class BillDTO {


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
     * 1支出 2收入
     */
    private Integer type;



    /**
     * 备注
     */
    private String remark;



    /**
     * 日期
     */
    private LocalDate billTime;


}

