package com.demo.account.vo;

import lombok.Data;



@Data

public class Result<T> {


    /**
     * 状态码
     */

    private Integer code;



    /**
     * 提示信息
     */

    private String message;



    /**
     * 返回数据
     */

    private T data;




    public Result()
    {

    }




    public Result(
            Integer code,
            String message,
            T data
    )
    {

        this.code=code;

        this.message=message;

        this.data=data;

    }





    /**
     * 成功返回
     */

    public static <T> Result<T> success(T data)
    {


        return new Result<>(
                200,
                "success",
                data
        );


    }



    /**
     * 失败返回
     */

    public static <T> Result<T> error(String message)
    {


        return new Result<>(
                500,
                message,
                null
        );


    }



}

