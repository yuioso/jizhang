package com.demo.account.service.impl;


import com.demo.account.config.AiConfig;

import com.demo.account.dto.BillDTO;
import com.demo.account.dto.ai.AiBillDTO;

import com.demo.account.mapper.CategoryMapper;
import com.demo.account.service.AiService;

import com.demo.account.service.BillService;
import com.demo.account.service.ai.function.ExpenseFunction;
import com.demo.account.utils.JsonUtil;


import lombok.RequiredArgsConstructor;


import org.springframework.http.*;

import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;



@Service
@RequiredArgsConstructor
public class AiServiceImpl implements AiService {


    private final RestTemplate restTemplate;


    private final AiConfig aiConfig;

    private final ExpenseFunction expenseFunction;

    private final CategoryMapper categoryMapper;


    private final BillService billService;




    @Override
    public AiBillDTO parseBill(
            String message
    ){


        String prompt = """

        你是一个智能记账助手。

        请解析用户消费描述。

        只返回JSON，不要解释。

        JSON格式：

        {
          "amount":数字,
          "category":"分类",
          "type":1,
          "remark":"备注",
          "billTime":"yyyy-MM-dd格式日期"
        }


        用户输入：

        """
                +
                message;



        //请求头

        HttpHeaders headers =
                new HttpHeaders();


        headers.setContentType(
                MediaType.APPLICATION_JSON
        );


        headers.setBearerAuth(
                aiConfig.getApiKey()
        );



        //消息体

        Map<String,Object> body =
                new HashMap<>();


        body.put(
                "model",
                aiConfig.getModel()
        );



        List<Map<String,String>> messages =
                new ArrayList<>();



        messages.add(
                Map.of(
                        "role",
                        "user",
                        "content",
                        prompt
                )
        );



        body.put(
                "messages",
                messages
        );



        HttpEntity<Object> entity =
                new HttpEntity<>(
                        body,
                        headers
                );



        ResponseEntity<Map> response =
                restTemplate.postForEntity(
                        aiConfig.getApiUrl(),
                        entity,
                        Map.class
                );



        /*
          获取AI返回内容
        */


        List choices =
                (List)response.getBody()
                        .get("choices");



        Map first =
                (Map)choices.get(0);



        Map messageObj =
                (Map)first.get("message");



        String content =
                (String)messageObj.get(
                        "content"
                );



        /*
          JSON字符串转对象
        */


        return JsonUtil.parse(
                content,
                AiBillDTO.class
        );

    }

    @Override
    public void saveBill(
            Long userId,
            AiBillDTO dto
    ){


    /*
       1.根据分类名称查询分类ID
    */


        Long categoryId =
                categoryMapper.findIdByName(
                        userId,
                        dto.getCategory()
                );



    /*
       2.创建账单对象
    */


        BillDTO bill =
                new BillDTO();



        bill.setCategoryId(
                categoryId
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
                LocalDate.parse(dto.getBillTime())
        );



    /*
       3.调用原来的账单业务
    */


        billService.add(
                userId,
                bill
        );


    }

    @Override
    public String chat(
            Long userId,
            String message
    ){


    /*
      这里以后是真正调用大模型
    */

        String content = message;



    /*
      简化版Function Calling

      如果AI判断需要查询消费
    */

        if(
                content.contains("花了多少钱")
                        ||
                        content.contains("消费多少")
        ){


            BigDecimal money =
                    expenseFunction
                            .getMonthlyExpense(
                                    userId
                            );



            return
                    "你本月支出了"
                            +
                            money
                            +
                            "元";


        }



        return "我暂时无法理解你的需求";


    }

}