package com.demo.account.service.impl;

import com.demo.account.dto.CategoryDTO;

import com.demo.account.entity.Category;

import com.demo.account.mapper.CategoryMapper;

import com.demo.account.service.CategoryService;


import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Service;



import java.util.List;



@Service

@RequiredArgsConstructor

public class CategoryServiceImpl
        implements CategoryService {



    private final CategoryMapper mapper;



    @Override
    public List<Category> list(
            Long userId
    ){

        return mapper.list(userId);

    }



    @Override
    public void add(
            Long userId,
            CategoryDTO dto
    ){


        Category c=new Category();


        c.setUserId(userId);

        c.setName(dto.getName());

        c.setType(dto.getType());

        c.setIcon(dto.getIcon());


        mapper.insert(c);


    }



    @Override
    public void delete(
            Long userId,
            Long id
    ){

        mapper.delete(
                id,
                userId
        );


    }


}

