package com.demo.account.service;

import com.demo.account.dto.statistics.CategoryStatisticsDTO;
import com.demo.account.dto.statistics.TrendDTO;


import java.math.BigDecimal;
import java.util.List;



public interface StatisticsService {



    BigDecimal income(
            Long userId
    );



    BigDecimal expense(
            Long userId
    );



    List<CategoryStatisticsDTO> category(
            Long userId
    );



    List<TrendDTO> trend(
            Long userId
    );



}
