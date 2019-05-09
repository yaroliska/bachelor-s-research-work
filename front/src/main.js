import Vue from 'vue'
import App from './App'
import Vuetify from 'vuetify'
import 'vuetify/dist/vuetify.min.css'
import VueRouter from 'vue-router'
import Routes from './routes'
require('./assets/styles/colorScheme.css')
import {store} from './store/store.js'

Vue.use(Vuetify)
Vue.use(VueRouter);


export const router = new VueRouter({
  routes:Routes,
  mode:'history'
});

export const bus = new Vue();

new Vue({
  store:store,
  el: '#app',
  render: h => h(App),
  router:router
});

