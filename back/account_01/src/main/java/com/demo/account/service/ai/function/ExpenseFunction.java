package com.demo.account.service.ai.function;


import com.demo.account.service.StatisticsService;


import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Component;



import java.math.BigDecimal;



@Component
@RequiredArgsConstructor
public class ExpenseFunction {



    private final StatisticsService statisticsService;




    /**
     * AI调用的方法
     */
    public BigDecimal getMonthlyExpense(
            Long userId
    ){


        return statisticsService.expense(
                userId
        );


    }



}