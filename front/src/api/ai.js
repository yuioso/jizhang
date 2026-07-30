import request from './request'



/**
 * AI自动记账
 */
export function createBill(data){


    return request.post(
        '/ai/bill',
        data
    )


}



/**
 * AI聊天查询
 */
export function chat(data){


    return request.post(
        '/ai/chat',
        data
    )


}