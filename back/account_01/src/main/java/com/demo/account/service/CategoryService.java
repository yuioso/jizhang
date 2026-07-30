package com.demo.account.service;


import com.demo.account.dto.CategoryDTO;

import com.demo.account.entity.Category;


import java.util.List;



public interface CategoryService {


    List<Category> list(
            Long userId
    );



    void add(
            Long userId,
            CategoryDTO dto
    );



    void delete(
            Long userId,
            Long id
    );


}

