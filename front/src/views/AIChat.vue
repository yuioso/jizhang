<template>


<div class="chat">


<h2>
AI智能记账助手
</h2>



<!-- 聊天区域 -->

<div 
class="messages"
ref="messageBox"
>


<div
v-for="(item,index) in messages"
:key="index"
:class="item.role"
>


<div>


{{item.content}}


</div>


</div>


</div>




<!-- 输入区域 -->


<div class="input-box">


<input

v-model="input"

placeholder="例如：昨天吃饭花了50元"

/>



<button
@click="send"
>

发送

</button>


</div>


</div>


</template>



<script setup>


import {

ref,

nextTick

}

from 'vue'



import {

createBill,

chat

}

from '../api/ai'





const input=
ref('')





const messages=
ref([


{

role:'ai',

content:
'你好，我可以帮你记录和查询账单。'


}


])





const messageBox=
ref(null)




async function send(){



if(!input.value){

return

}



const text =
input.value




//显示用户消息


messages.value.push({


role:'user',


content:text


})



input.value=''





let res





/*
判断是否是记账

*/

if(

text.includes('花')

||

text.includes('买')

||

text.includes('消费')

){



res =
await createBill({

message:text

})




messages.value.push({


role:'ai',


content:

"已记录账单：\n"

+

JSON.stringify(
res.data
)



})


}

else{


/*
查询类问题

*/

res =
await chat({

message:text

})



messages.value.push({


role:'ai',


content:res.data


})

}


await nextTick()


scrollBottom()


}






function scrollBottom(){


messageBox.value.scrollTop =

messageBox.value.scrollHeight


}



</script>



<style scoped>


.chat{


width:700px;

margin:40px auto;


}



.messages{


height:500px;

border:1px solid #ddd;


padding:20px;

overflow:auto;


}



.user{


text-align:right;

margin:15px;


}



.user div{


display:inline-block;

background:#409eff;

color:white;

padding:10px;

border-radius:8px;


}



.ai{


text-align:left;

margin:15px;


}



.ai div{


display:inline-block;

background:#eee;

padding:10px;

border-radius:8px;


}



.input-box{


display:flex;

margin-top:20px;


}



input{


flex:1;

height:40px;


}



button{


width:80px;


}


</style>