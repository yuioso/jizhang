import request from './request'



//收入

export function getIncome(){


    return request.get(
        '/statistics/income'
    )


}



//支出

export function getExpense(){


    return request.get(
        '/statistics/expense'
    )


}



//分类统计

export function getCategory(){


    return request.get(
        '/statistics/category'
    )


}



//趋势

export function getTrend(){


    return request.get(
        '/statistics/trend'
    )


}