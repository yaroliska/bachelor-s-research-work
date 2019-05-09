import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

export const store = new Vuex.Store({
  state: {
    mainHeader: 'Привет, я header'
  },
  getters: {
    /*mainHeaderTwo:state=>{
      var mainHeaderTwo=state.mainHeader;
      return mainHeaderTwo;
    }*/
  },
  mutations: {
    changeMainHeader: (state, payload) => {
      state.mainHeader = payload;
    }
  }
})
  /*actions:{
    changeMainHeader:(context,text)=>{
      setTimeout(function () {
        context.commit('changeMainHeader', text);
      },2000)
    }
  }
})*/
