package com.demo.account.mapper;


import com.demo.account.entity.User;
import org.apache.ibatis.annotations.*;



@Mapper
public interface UserMapper {



    /**
     * 根据用户名查询用户
     */
    @Select(
            "select * from user where username=#{username}"
    )
    User findByUsername(
            String username
    );



    /**
     * 新增用户
     */
    @Insert("""
        insert into user
        (
            username,
            password,
            nickname
        )
        values
        (
            #{username},
            #{password},
            #{nickname}
        )
    """)
    int insert(User user);



}
