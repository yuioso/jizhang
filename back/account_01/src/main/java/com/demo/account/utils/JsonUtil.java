package com.demo.account.utils;

import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonUtil {


    private static final ObjectMapper mapper =
            new ObjectMapper();



    public static <T> T parse(
            String json,
            Class<T> clazz
    ){


        try {


            return mapper.readValue(
                    json,
                    clazz
            );


        }catch(Exception e){

            throw new RuntimeException(e);

        }


    }


}
