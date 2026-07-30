<template>


<div class="home">



<h1>

AI智能记账助手

</h1>

<button
@click="$router.push('/ai')"
>

AI记账助手
</button>





<!-- 数据卡片 -->

<div class="cards">



<StatCard

title="本月收入"

:value="income"

/>



<StatCard

title="本月支出"

:value="expense"

/>



<StatCard

title="当前余额"

:value="balance"

/>



</div>





<div class="charts">


<CategoryChart />


<TrendChart />


</div>



</div>



</template>





<script setup>


import {

ref,

onMounted

}

from 'vue'



import StatCard from '../components/StatCard.vue'


import CategoryChart from '../components/CategoryChart.vue'


import TrendChart from '../components/TrendChart.vue'



import {

getIncome,

getExpense

}

from '../api/statistics'





const income=
ref(0)



const expense=
ref(0)



const balance=
ref(0)





onMounted(async()=>{


const incomeRes=
await getIncome()



const expenseRes=
await getExpense()



income.value=
incomeRes.data



expense.value=
expenseRes.data



balance.value=

income.value-

expense.value



})



</script>




<style scoped>


.home{


padding:30px;


background:#f5f6fa;


min-height:100vh;


}




.cards{


display:flex;

gap:20px;


}




.charts{


margin-top:30px;


display:flex;

gap:30px;


background:white;


padding:20px;


border-radius:10px;


}


</style>