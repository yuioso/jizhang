package com.demo.account.mapper;


import com.demo.account.dto.statistics.CategoryStatisticsDTO;
import com.demo.account.dto.statistics.TrendDTO;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.math.BigDecimal;
import java.util.List;



@Mapper
public interface StatisticsMapper {


    /**
     * 查询收入
     */
    BigDecimal getIncome(
            @Param("userId")
            Long userId
    );



    /**
     * 查询支出
     */
    BigDecimal getExpense(
            @Param("userId")
            Long userId
    );



    /**
     * 分类统计
     */
    List<CategoryStatisticsDTO> getCategoryStatistics(
            @Param("userId")
            Long userId
    );



    /**
     * 最近7天趋势
     */
    List<TrendDTO> getTrend(
            @Param("userId")
            Long userId
    );


}
