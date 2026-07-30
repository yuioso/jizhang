import {
    createRouter,
    createWebHistory
} from 'vue-router'



import Login from '../views/Login.vue'

import Register from '../views/Register.vue'

import Home from '../views/Home.vue'

import AIChat from '../views/AIChat.vue'




const router=createRouter({



    history:
        createWebHistory(),



    routes:[


        {

            path:'/',

            redirect:'/login'

        },


        {


            path:'/login',

            component:Login


        },


        {


            path:'/register',

            component:Register


        },


        {


            path:'/home',

            component:Home


        },

        {


            path:'/ai',

            component:AIChat

        }

    ]



})



export default router