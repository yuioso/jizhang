package com.demo.account.dto.statistics;


import lombok.Data;

import java.math.BigDecimal;


/**
 * 分类统计返回对象
 */
@Data
public class CategoryStatisticsDTO {


    /**
     * 分类名称
     */
    private String name;


    /**
     * 金额
     */
    private BigDecimal value;


}
