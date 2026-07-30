package com.demo.account.service.impl;

import com.demo.account.dto.LoginDTO;
import com.demo.account.dto.RegisterDTO;
import com.demo.account.mapper.UserMapper;
import com.demo.account.entity.User;
import com.demo.account.service.UserService;
import com.demo.account.utils.JwtUtil;
import com.demo.account.vo.LoginVO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service

@RequiredArgsConstructor

public class UserServiceImpl
        implements UserService {



    private final UserMapper userMapper;



    private final JwtUtil jwtUtil;



    /**
     * 密码加密工具
     */
    private final BCryptPasswordEncoder encoder
            =
            new BCryptPasswordEncoder();




    @Override
    public void register(
            RegisterDTO dto
    ){


        //判断用户名是否存在

        User exist =
                userMapper.findByUsername(
                        dto.getUsername()
                );


        if(exist!=null){

            throw new RuntimeException(
                    "用户名已存在"
            );

        }



        User user=new User();


        user.setUsername(
                dto.getUsername()
        );


        //密码加密

        user.setPassword(
                encoder.encode(
                        dto.getPassword()
                )
        );


        user.setNickname(
                dto.getNickname()
        );



        userMapper.insert(user);


    }





    @Override
    public LoginVO login(
            LoginDTO dto
    ){


        User user =
                userMapper.findByUsername(
                        dto.getUsername()
                );


        if(user==null){

            throw new RuntimeException(
                    "用户不存在"
            );

        }



        //比较密码

        boolean match =
                encoder.matches(
                        dto.getPassword(),
                        user.getPassword()
                );



        if(!match){

            throw new RuntimeException(
                    "密码错误"
            );

        }



        //生成token

        String token =
                jwtUtil.createToken(
                        user.getId()
                );



        return new LoginVO(
                token,
                user.getId(),
                user.getUsername()
        );


    }


}
