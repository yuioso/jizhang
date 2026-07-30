package com.demo.account.service;


import com.demo.account.dto.LoginDTO;
import com.demo.account.dto.RegisterDTO;
import com.demo.account.vo.LoginVO;

public interface UserService {



    /**
     * 注册
     */
    void register(
            RegisterDTO dto
    );



    /**
     * 登录
     */
    LoginVO login(
            LoginDTO dto
    );


}
