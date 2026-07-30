<template>


<div>

<h3>
消费分类
</h3>


<div
ref="chart"
class="chart"
></div>


</div>


</template>



<script setup>


import {

onMounted,

ref

} from 'vue'



import * as echarts from 'echarts'



import {
getCategory
}
from '../api/statistics'



const chart=ref()



onMounted(async()=>{



    const result =
        await getCategory()



    const data =
        result.data



    const myChart =
        echarts.init(
            chart.value
        )



    myChart.setOption({



        tooltip:{},



        series:[

        {


        type:'pie',


        radius:'60%',


        data:data.map(item=>({


            name:item.name,


            value:item.value



        }))


        }


        ]


    })


})



</script>



<style scoped>


.chart{


width:500px;

height:350px;


}


</style>