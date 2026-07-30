package com.demo.account.dto.statistics;


import lombok.Data;

import java.math.BigDecimal;


/**
 * 消费趋势
 */
@Data
public class TrendDTO {


    /**
     * 日期
     */
    private String date;



    /**
     * 金额
     */
    private BigDecimal amount;


}
