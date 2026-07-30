package com.demo.account.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;



@Configuration
@RequiredArgsConstructor
public class CorsConfig
        implements WebMvcConfigurer {
    private final LoginInterceptor loginInterceptor;

    @Override

    public void addCorsMappings(
            CorsRegistry registry
    )
    {


        registry.addMapping("/**")


                //允许前端地址

                .allowedOrigins(
                        "http://localhost:5173"
                )


                //允许请求方法

                .allowedMethods(
                        "*"
                )


                //允许请求头

                .allowedHeaders(
                        "*"
                )


                //允许携带token

                .allowCredentials(true);



    }

    @Override
    public void addInterceptors(
            InterceptorRegistry registry
    ){


        registry.addInterceptor(
                        loginInterceptor
                )

                .addPathPatterns(
                        "/bill/**",
                        "/category/**"
                )

                .excludePathPatterns(
                        "/user/**"
                );


    }


}
