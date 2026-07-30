package com.demo.account.service.impl;


import com.demo.account.dto.BillDTO;

import com.demo.account.entity.Bill;

import com.demo.account.mapper.BillMapper;

import com.demo.account.service.BillService;

import com.demo.account.vo.BillVO;


import com.demo.account.vo.PageResult;
import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Service;



import java.util.List;



@Service

@RequiredArgsConstructor

public class BillServiceImpl
        implements BillService {

    private final BillMapper billMapper;


    @Override
    public void add(
            Long userId,
            BillDTO dto
    ){


        Bill bill=new Bill();


        bill.setUserId(userId);


        bill.setCategoryId(
                dto.getCategoryId()
        );


        bill.setAmount(
                dto.getAmount()
        );


        bill.setType(
                dto.getType()
        );


        bill.setRemark(
                dto.getRemark()
        );


        bill.setBillTime(
                dto.getBillTime()
        );



        billMapper.insert(bill);


    }


    @Override
    public List<BillVO> list(
            Long userId
    ){


        return billMapper.findList(
                userId
        );


    }





    @Override
    public void delete(
            Long userId,
            Long id
    ){


        billMapper.delete(
                id,
                userId
        );


    }

    public PageResult<BillVO> page(
            Long userId,
            Long page,
            Long size
    ){

        Long start =
                (page-1)*size;


        List<BillVO> list =
                billMapper.pageList(
                        userId,
                        start,
                        size
                );


        return new PageResult<>(
                list,
                100L,
                page,
                size
        );


    }


}

