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

import Search from "@/components/Search";
import Information from "@/components/Information";
import orderAdd from "@/components/orderAdd";

import MyAccount from "@/components/UserAccountPage/MyAccount";
import MyOrderCompleted from "@/components/UserAccountPage/MyOrderCompleted";
import PersonalInformation from "@/components/UserAccountPage/PersonalInformation";
import EditInformation from "@/components/UserAccountPage/EditInformation";
import MyOrderNotStart from "@/components/UserAccountPage/MyOrderNotStart";
import MyOrderCanceled from "@/components/UserAccountPage/MyOrderCanceled";
import MyAccountHome from "@/components/UserAccountPage/MyAccountHome";
import OrderEvaluate from "@/components/UserAccountPage/OrderEvaluate";
import MyOrderEvaluated from "@/components/UserAccountPage/MyOrderEvaluated";


Vue.use(Router)

const router =  new Router({
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
      path: '/search/:keyword/:address/:checked',
      name: 'search',
      component: Search
    },
    {
      path: '/information/:yelp/:id',
      name: 'information',
      component: Information
    },
    {
      path: '/orderAdd/:type/:id/:price/:yelp',
      name: 'orderAdd',
      component: orderAdd
    },
    {
      path: '/myaccount',
      component: MyAccount,
      redirect:'/myaccounthome',
      children:[
        { path: '/myaccounthome',
          component: MyAccountHome,
        },
        { path: '/ordercom',
          component: MyOrderCompleted,
        },
        { path: '/ordernotstart',
          component: MyOrderNotStart,
        },
        { path: '/ordercancel',
          component: MyOrderCanceled,
        },
        { path: '/ordereva',
          component: MyOrderEvaluated,
        },
        { path: '/information',
          component: PersonalInformation,
        },
        { path: '/editinfo',
          component:EditInformation,
        },
        {
          path: '/myaccountreset',
          component: Reset2
        },
        {
          name:'Evaluate',
          path: '/orderevaluate/:currentspid/:orderid',
          component: OrderEvaluate
        },
      ]
    },

  ]
})

router.beforeEach((to, from, next)=>{
  const tokenStr =  window.sessionStorage.getItem('token');
  if((to.path ==='/myaccounthome' || to.path ==='/myaccountreset'|| to.path ==='/ordernotstart' || to.path ==='/ordercom' || to.path ==='/ordercancel' || to.path ==='/ordereva' || to.path ==='/information') && !tokenStr) next('/homelogin')
  next()
})


export default router


