<template>


<div class="card">


<div class="title">

{{title}}

</div>


<div class="money">

¥{{value}}

</div>


</div>


</template>




<script setup>


defineProps({


    title:String,


    value:Number


})


</script>



<style scoped>


.card{


width:200px;

padding:20px;

background:white;

border-radius:10px;

box-shadow:
0 2px 8px #ddd;


}



.title{


color:#666;


}



.money{


font-size:28px;

margin-top:15px;


}



</style>