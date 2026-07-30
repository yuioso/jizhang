<template>


<div>


<h3>
近7日消费趋势
</h3>


<div
ref="chart"
class="chart"
></div>


</div>


</template>



<script setup>


import {

ref,

onMounted

}

from 'vue'



import * as echarts from 'echarts'



import {
getTrend
}

from '../api/statistics'



const chart=ref()



onMounted(async()=>{


const result =
await getTrend()



const data =
result.data



const myChart =
echarts.init(
chart.value
)




myChart.setOption({



xAxis:{


type:'category',


data:data.map(
item=>item.date
)


},



yAxis:{


type:'value'


},



series:[

{

type:'line',

data:data.map(
item=>item.amount
)

}

]


})



})



</script>



<style scoped>


.chart{


width:600px;

height:350px;


}


</style>