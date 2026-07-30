package com.demo.account.exception;


import com.demo.account.vo.Result;

import org.springframework.web.bind.annotation.*;



@RestControllerAdvice

public class GlobalExceptionHandler {



    @ExceptionHandler(Exception.class)

    public Result<String> error(
            Exception e
    )
    {


        return Result.error(
                e.getMessage()
        );


    }


}
