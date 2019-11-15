import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import AppIndex from '@/components/home/AppIndex'
import Temp from '@/components/temp'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/temp',
      name: 'Temp',
      component: Temp
    },
    {
      path: '/AppIndex',
      name: 'AppIndex',
      component: AppIndex
    }
  ]
})
