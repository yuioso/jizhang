package com.demo.account.service;

import com.demo.account.dto.ai.AiBillDTO;



public interface AiService {



    /**
     * AI解析账单
     */
    AiBillDTO parseBill(
            String message
    );

    void saveBill(
            Long userId,
            AiBillDTO dto
    );

    String chat(
            Long userId,
            String message
    );


}

