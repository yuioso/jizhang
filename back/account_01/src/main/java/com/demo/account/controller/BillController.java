package com.demo.account.controller;


import com.demo.account.dto.BillDTO;

import com.demo.account.service.BillService;

import com.demo.account.vo.Result;


import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.*;



@RestController

@RequestMapping("/bill")

@RequiredArgsConstructor

public class BillController {



    private final BillService billService;



    /**
     * 新增账单
     */
    @PostMapping
    public Result<String> add(
            @RequestBody BillDTO dto
    ){


        //这里暂时写死用户

        Long userId=1L;



        billService.add(
                userId,
                dto
        );



        return Result.success(
                "添加成功"
        );

    }





    /**
     * 查询账单
     */
    @GetMapping
    public Result list(
            HttpServletRequest request
    ){


        Long userId =
                (Long)request.getAttribute(
                        "userId"
                );


        return Result.success(
                billService.list(userId)
        );

    }





    /**
     * 删除账单
     */
    @DeleteMapping("/{id}")
    public Result delete(
            @PathVariable Long id
    ){


        Long userId=1L;


        billService.delete(
                userId,
                id
        );


        return Result.success(
                "删除成功"
        );

    }


}

