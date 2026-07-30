package com.demo.account.controller;

import com.demo.account.service.StatisticsService;

import com.demo.account.vo.Result;


import jakarta.servlet.http.HttpServletRequest;


import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.*;



@RestController

@RequestMapping("/statistics")

@RequiredArgsConstructor

public class StatisticsController {



    private final StatisticsService service;




    /**
     * 收入
     */
    @GetMapping("/income")
    public Result income(
            HttpServletRequest request
    ){


        Long userId =
                (Long)request.getAttribute(
                        "userId"
                );


        return Result.success(
                service.income(userId)
        );


    }




    /**
     * 支出
     */
    @GetMapping("/expense")
    public Result expense(
            HttpServletRequest request
    ){


        Long userId =
                (Long)request.getAttribute(
                        "userId"
                );


        return Result.success(
                service.expense(userId)
        );


    }




    /**
     * 分类统计
     */
    @GetMapping("/category")
    public Result category(
            HttpServletRequest request
    ){


        Long userId =
                (Long)request.getAttribute(
                        "userId"
                );


        return Result.success(
                service.category(userId)
        );


    }





    /**
     * 趋势
     */
    @GetMapping("/trend")
    public Result trend(
            HttpServletRequest request
    ){


        Long userId =
                (Long)request.getAttribute(
                        "userId"
                );


        return Result.success(
                service.trend(userId)
        );


    }


}
