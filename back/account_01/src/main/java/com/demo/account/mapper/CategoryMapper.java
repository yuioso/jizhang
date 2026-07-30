package com.demo.account.mapper;

import com.demo.account.entity.Category;


import org.apache.ibatis.annotations.*;

import java.util.List;



@Mapper
public interface CategoryMapper {



    @Select("""
    select *
    from category
    where user_id=#{userId}
    """)
    List<Category> list(
            Long userId
    );




    @Insert("""
    insert into category
    (
      user_id,
      name,
      type,
      icon
    )
    values
    (
      #{userId},
      #{name},
      #{type},
      #{icon}
    )
    """)
    int insert(Category category);





    @Delete("""
    delete from category
    where id=#{id}
    and user_id=#{userId}
    """)
    int delete(
            Long id,
            Long userId
    );

    @Select("""
    select id
    from category
    
    where user_id=#{userId}
    
    and name=#{name}
    
    limit 1
    """)
    Long findIdByName(
            Long userId,
            String name
    );


}
