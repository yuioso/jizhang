package com.demo.account.service;


import com.demo.account.dto.BillDTO;

import com.demo.account.vo.BillVO;
import com.demo.account.vo.PageResult;


import java.util.List;



public interface BillService {



    /**
     * 添加账单
     */
    void add(
            Long userId,
            BillDTO dto
    );




    /**
     * 查询账单
     */
    List<BillVO> list(
            Long userId
    );




    /**
     * 删除
     */
    void delete(
            Long userId,
            Long id
    );

    PageResult<BillVO> page(
            Long userId,
            Long page,
            Long size
    );



}

