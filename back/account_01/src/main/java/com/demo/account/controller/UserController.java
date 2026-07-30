package com.demo.account.controller;

import com.demo.account.dto.LoginDTO;

import com.demo.account.dto.RegisterDTO;

import com.demo.account.service.UserService;

import com.demo.account.vo.LoginVO;

import com.demo.account.vo.Result;


import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.*;



@RestController

@RequestMapping("/user")

@RequiredArgsConstructor

public class UserController {



    private final UserService userService;




    /**
     * 注册接口
     */
    @PostMapping("/register")
    public Result<String> register(
            @RequestBody RegisterDTO dto
    ){


        userService.register(dto);


        return Result.success(
                "注册成功"
        );


    }





    /**
     * 登录接口
     */
    @PostMapping("/login")
    public Result<LoginVO> login(
            @RequestBody LoginDTO dto
    ){


        LoginVO vo = userService.login(dto);



        return Result.success(vo);


    }


}

