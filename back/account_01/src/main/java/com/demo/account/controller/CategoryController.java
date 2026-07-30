package com.demo.account.controller;

import com.demo.account.dto.CategoryDTO;

import com.demo.account.service.CategoryService;

import com.demo.account.vo.Result;


import jakarta.servlet.http.HttpServletRequest;


import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.*;



@RestController

@RequestMapping("/category")

@RequiredArgsConstructor

public class CategoryController {


    private final CategoryService service;



    @GetMapping
    public Result list(
            HttpServletRequest request
    ){


        Long userId =
                (Long)request.getAttribute(
                        "userId"
                );


        return Result.success(
                service.list(userId)
        );


    }





    @PostMapping
    public Result add(
            @RequestBody CategoryDTO dto,
            HttpServletRequest request
    ){


        Long userId =
                (Long)request.getAttribute(
                        "userId"
                );



        service.add(
                userId,
                dto
        );



        return Result.success(
                "添加成功"
        );


    }





    @DeleteMapping("/{id}")
    public Result delete(
            @PathVariable Long id,
            HttpServletRequest request
    ){


        Long userId =
                (Long)request.getAttribute(
                        "userId"
                );


        service.delete(
                userId,
                id
        );


        return Result.success(
                "删除成功"
        );


    }


}
