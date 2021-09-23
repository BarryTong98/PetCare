import Vue from 'vue'
import Router from 'vue-router'
import Login from '/src/components/Login'
import Home from '/src/components/Home'
import Signup from '@/components/Signup'

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
          component: Home
        },
        {
          path: '/signup',
          component: Signup
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

