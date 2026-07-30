package com.demo.account.service.impl;

import com.demo.account.dto.statistics.CategoryStatisticsDTO;
import com.demo.account.dto.statistics.TrendDTO;

import com.demo.account.mapper.StatisticsMapper;

import com.demo.account.service.StatisticsService;


import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.util.List;



@Service

@RequiredArgsConstructor

public class StatisticsServiceImpl
        implements StatisticsService {



    private final StatisticsMapper mapper;




    @Override
    public BigDecimal income(
            Long userId
    ){

        return mapper.getIncome(
                userId
        );

    }




    @Override
    public BigDecimal expense(
            Long userId
    ){

        return mapper.getExpense(
                userId
        );

    }





    @Override
    public List<CategoryStatisticsDTO> category(
            Long userId
    ){

        return mapper.getCategoryStatistics(
                userId
        );

    }





    @Override
    public List<TrendDTO> trend(
            Long userId
    ){

        return mapper.getTrend(
                userId
        );

    }


}