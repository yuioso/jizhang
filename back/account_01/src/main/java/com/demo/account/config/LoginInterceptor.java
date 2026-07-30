package com.demo.account.config;


import com.demo.account.utils.JwtUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Component;

import org.springframework.web.servlet.HandlerInterceptor;



@Component
@RequiredArgsConstructor
public class LoginInterceptor
        implements HandlerInterceptor {


    private final JwtUtil jwtUtil;



    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler
    ){


        String token =
                request.getHeader("token");



        if(token==null){

            return false;

        }


        Long userId =
                jwtUtil.getUserId(token);



        //保存用户ID

        request.setAttribute(
                "userId",
                userId
        );



        return true;


    }


}
