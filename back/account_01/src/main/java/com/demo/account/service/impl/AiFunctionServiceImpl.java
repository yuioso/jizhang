package com.demo.account.service.impl;

import com.demo.account.service.AiFunctionService;
import com.demo.account.service.StatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class AiFunctionServiceImpl
        implements AiFunctionService {


    private final StatisticsService statisticsService;



    @Override
    public BigDecimal getMonthlyExpense(
            Long userId
    ){


        return statisticsService.expense(
                userId
        );


    }


}
