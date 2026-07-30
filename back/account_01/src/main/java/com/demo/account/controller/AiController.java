package com.demo.account.controller;

import com.demo.account.dto.ai.AiBillDTO;
import com.demo.account.dto.ai.AiRequestDTO;

import com.demo.account.service.AiService;

import com.demo.account.vo.Result;


import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.*;



@RestController

@RequestMapping("/ai")

@RequiredArgsConstructor

public class AiController {



    private final AiService aiService;


    @PostMapping("/parse")
    public Result parse(
            @RequestBody AiRequestDTO dto
    ){


        return Result.success(

                aiService.parseBill(
                        dto.getMessage()
                )

        );


    }

    @PostMapping("/bill")
    public Result createBill(
            @RequestBody AiRequestDTO dto,
            HttpServletRequest request
    ){


//        Long userId =
//                (Long)request.getAttribute(
//                        "userId"
//                );

        Long userId = 1L;


        AiBillDTO billDTO =
                aiService.parseBill(
                        dto.getMessage()
                );



        aiService.saveBill(
                userId,
                billDTO
        );



        return Result.success(
                billDTO
        );


    }

    @PostMapping("/chat")
    public Result chat(
            @RequestBody AiRequestDTO dto,
            HttpServletRequest request
    ){


        Long userId =
                (Long)request.getAttribute(
                        "userId"
                );



        String answer =
                aiService.chat(
                        userId,
                        dto.getMessage()
                );



        return Result.success(
                answer
        );


    }


}
