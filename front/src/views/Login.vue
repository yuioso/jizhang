<template>


<div class="login">


<h2>
AI智能记账助手
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




<button
@click="handleLogin"
>

登录

</button>



<p>

没有账号？

<router-link to="/register">

去注册

</router-link>


</p>



</div>


</template>



<script setup>


import {
    reactive
} from 'vue'


import {
    useRouter
} from 'vue-router'


import {
    login
} from '../api/user'


import {
    setToken
} from '../utils/token'



const router=
useRouter()




// 表单数据

const form=reactive({


    username:'',


    password:''


})




// 登录方法

async function handleLogin(){



    const res =
        await login(form)



    if(res.code===200){


        //保存token

        setToken(
            res.data.token
        )


        //跳转首页

        router.push(
            '/home'
        )


    }

    console.log("后端返回完整res：", res)


}


</script>



<style scoped>


.login{


width:300px;

margin:150px auto;


display:flex;

flex-direction:column;

gap:15px;


}


input{


height:35px;


}


button{


height:40px;


background:#409eff;


color:white;


border:none;


}


</style>