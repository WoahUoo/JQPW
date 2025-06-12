import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import news from '@/views/modules/news/list'
    import shoupiaodingdan from '@/views/modules/shoupiaodingdan/list'
    import menpiaoleixing from '@/views/modules/menpiaoleixing/list'
    import shoupiaoyuan from '@/views/modules/shoupiaoyuan/list'
    import menpiaoxinxi from '@/views/modules/menpiaoxinxi/list'
    import tuipiaoxinxi from '@/views/modules/tuipiaoxinxi/list'
    import newstype from '@/views/modules/newstype/list'


//2.配置路由   注意：名字
export const routes = [{
    path: '/',
    name: '系统首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '系统首页',
      component: Home,
      meta: {icon:'', title:'center', affix: true}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/news',
        name: '公告信息',
        component: news
      }
      ,{
	path: '/shoupiaodingdan',
        name: '售票订单',
        component: shoupiaodingdan
      }
      ,{
	path: '/menpiaoleixing',
        name: '门票类型',
        component: menpiaoleixing
      }
      ,{
	path: '/shoupiaoyuan',
        name: '售票员',
        component: shoupiaoyuan
      }

      ,{
	path: '/menpiaoxinxi',
        name: '门票信息',
        component: menpiaoxinxi
      }
      ,{
	path: '/tuipiaoxinxi',
        name: '退票信息',
        component: tuipiaoxinxi
      }

      ,{
	path: '/newstype',
        name: '公告信息分类',
        component: newstype
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}
export default router;
