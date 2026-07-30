package com.demo.account.service;

import java.math.BigDecimal;

public interface AiFunctionService {

    /**
     * 查询本月支出
     */
    BigDecimal getMonthlyExpense(
            Long userId
    );

}
