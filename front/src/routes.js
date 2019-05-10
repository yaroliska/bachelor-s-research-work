import mainView from './components/main/mainView.vue';
import comparisonOfModelsMain from './components/main/comparisonOfModels/comparisonOfModelsMain.vue';
import constructorMainPage from './components/main/constructor/constructorMainPage.vue';
import userGuidMain from './components/main/userGuid/userGuidMain.vue';
import aboutProgram from './components/main/aboutProgram/aboutProgram.vue';
import addNewStation from './components/main/constructor/addNewStation.vue';
import constructorVersionsPage from './components/main/constructor/constructorVersionsPage.vue';
import addNewVersion from './components/main/constructor/addNewVersion.vue';
import editor from './components/main/constructor/editor.vue';

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
        path:'constructorVersionsPage',
        component:constructorVersionsPage
      },
      {
        path:'addNewVersion',
        component:addNewVersion
      },
      {
        path:'editor',
        component:editor
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
