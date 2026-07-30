<template>


<div class="register">


<h2>
用户注册
</h2>



<input

v-model="form.username"

placeholder="用户名"

/>




<input

v-model="form.password"

type="password"

placeholder="密码"

/>




<input

v-model="form.nickname"

placeholder="昵称"

/>




<button
@click="handleRegister"
>

注册

</button>



</div>


</template>



<script setup>


import {
reactive
} from 'vue'


import {
register
} from '../api/user'


import {
useRouter
} from 'vue-router'



const router=
useRouter()



const form=reactive({

username:'',

password:'',

nickname:''

})




async function handleRegister(){



const res =
await register(form)



if(res.code===200){


alert(
"注册成功"
)



router.push(
'/login'
)


}


}



</script>



<style scoped>


.register{


width:300px;

margin:150px auto;

display:flex;

flex-direction:column;

gap:15px;


}



</style>