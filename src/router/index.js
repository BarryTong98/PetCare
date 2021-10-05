import Vue from 'vue'
import Router from 'vue-router'
import Login from '/src/components/HomePage/Login'
import Home from '/src/components/HomePage/Home'
import Signup from '@/components/HomePage/Signup'
import Template from '/src/components/Template'
import Welcome from '@/components/HomePage/Welcome'
import Examination from '@/components/Health/Examination'
import Aboutus from '@/components/HomePage/Aboutus'
import CardList from '@/components/HomePage/CardList'
import HomeHeader from '@/components/HomePage/HomeHeader'
import Register from '@/components/HomePage/Register'
import HomeLogin from '@/components/HomePage/HomeLogin'
import Reset from '@/components/HomePage/Reset'
import Reset2 from '@/components/HomePage/Reset2'
import MyAccount from "@/components/UserAccountPage/MyAccount";
import MyOrder from "@/components/UserAccountPage/MyOrder";
import PersonalInformation from "@/components/UserAccountPage/PersonalInformation";
import EditInformation from "@/components/UserAccountPage/EditInformation";
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      redirect: '/home'
    },
    {
      path: '/login',
      component: Login
    },
    {
      path: '/home',
      component: Home,
      redirect: '/welcome',
      children: [
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
        },
        {
          path: '/cardlist',
          component: CardList
        }
      ]
    },
    {
      path: '/signup',
      component: Signup,
      redirect: '/homelogin',
      children: [
        {
          path: '/register',
          component: Register
        },
        {
          path: '/homelogin',
          component: HomeLogin
        },
        {
          path: '/reset',
          component: Reset
        },
        {
          path: '/reset2',
          component: Reset2
        }
      ]
    },
    {
      path: '/template',
      component: Template
    }
    ,
    {
      path: '/homeheader',
      component: HomeHeader
    },
    {
      path: '/myaccount',
      component: MyAccount,
      children:[
        { path: '/order',
          component: MyOrder,
        },
        { path: '/information',
          component: PersonalInformation,
        },
        { path: '/editinfo',
          component:EditInformation,
        }
      ]
    },

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

