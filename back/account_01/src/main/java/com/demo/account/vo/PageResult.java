package com.demo.account.vo;


import lombok.Data;

import java.util.List;



@Data
public class PageResult<T>{


    /**
     * 数据
     */
    private List<T> records;



    /**
     * 总数量
     */
    private Long total;



    /**
     * 当前页
     */
    private Long page;



    /**
     * 每页数量
     */
    private Long size;



    public PageResult(
            List<T> records,
            Long total,
            Long page,
            Long size
    ){

        this.records=records;

        this.total=total;

        this.page=page;

        this.size=size;

    }

}

