import mainView from './components/main/mainView.vue';
import comparisonOfModelsMain from './components/main/comparisonOfModels/comparisonOfModelsMain.vue';
import constructorMainPage from './components/main/constructor/constructorMainPage.vue';
import userGuidMain from './components/main/userGuid/userGuidMain';
import aboutProgram from './components/main/aboutProgram/aboutProgram';
import addNewStation from './components/main/constructor/addNewStation';

export default [
  {
    path: '/',
    redirect: '/mainview/constructorMainPage'
  },
  {
    path: '/mainview',
    component: mainView,
    children: [
      {
        path:'comparisonOfModels',
        component:comparisonOfModelsMain
      },
      {
        path:'constructorMainPage',
        component:constructorMainPage,
      },
      {
        path:'addNewStation',
        component:addNewStation
      },
      {
        path:'userGuid',
        component:userGuidMain
      },
      {
        path:'aboutProgram',
        component:aboutProgram
      },
    ]
  }
]
