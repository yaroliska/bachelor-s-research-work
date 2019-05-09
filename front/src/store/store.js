import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

export const store = new Vuex.Store({
  state: {
    mainHeader: 'Начните работу!',
    stationsExist:null,
    constructorState:{
      stationId:null,
      versionId:null,
      editorState:{
        editorMode:{
          nameOfMode:null,
          typeOfTool:null
        }
      }
    }
  },
  getters: {
    getMainHeader:state=>{
      let mainHeader=state.mainHeader;
      return mainHeader;
    }
  },
  mutations: {
    changeMainHeader: (state, payload) => {
      state.mainHeader = payload;
    },
    setStationExist:(state,payload)=>{
      state.stationsExist=payload;
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
