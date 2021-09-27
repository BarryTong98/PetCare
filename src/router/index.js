import Vue from 'vue'
import Router from 'vue-router'
import Login from '/src/components/HomePage/Login'
import Home from '/src/components/HomePage/Home'
import Signup from '@/components/HomePage/Signup'
import Template from '/src/components/Template'
import Welcome from '@/components/HomePage/Welcome'
import Examination from '@/components/Health/Examination'
import Aboutus from '@/components/HomePage/Aboutus'
Vue.use(Router)

export default new Router({
      routes: [
        {
          path: '/',
          redirect:'/login'
        },
        {
          path: '/login',
          component: Login
        },
        {
          path: '/home',
          component: Home,
          redirect:'/welcome',
          children:[
            {
              path: '/welcome',
              component: Welcome
            },
            {
              path: '/examination',
              component: Examination
            },
            {
              path: '/aboutus',
              component: Aboutus
            }
          ]
        },
        {
          path: '/signup',
          component: Signup
        },
        {
          path: '/template',
          component: Template
        }
      ]
})

// 挂载路由导航守卫
// router.beforeEach((to, from, next)=>{
//   //to 将要访问的路径
//   //from 代表从哪个路径跳转过来
//   //next是一个函数，表示放行
//   //next()放行， next('login')强制跳转
//   if(to.path ==='/login') return next()
//   //获取token
//   const  tokenStr=  window.sessionStorage.getItem('token');
//   if(!tokenStr) return next('/login')
// })

