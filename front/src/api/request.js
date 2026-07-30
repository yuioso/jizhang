import axios from 'axios'


// 创建axios实例

const request = axios.create({


    // 后端地址

    baseURL:'http://localhost:8080',


    // 超时时间

    timeout:30000


})




// 请求拦截器

request.interceptors.request.use(
    config=>{


        // 获取token

        const token =
            localStorage.getItem(
                'token'
            )


        if(token){

            // 添加请求头

            config.headers.token =
                token

        }


        return config

    }
)



// 响应拦截器

request.interceptors.response.use(

    response=>{


        return response.data


    },


    error=>{


        console.log(error)


        return Promise.reject(error)

    }


)



export default request