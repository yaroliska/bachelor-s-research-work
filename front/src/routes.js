import mainView from './components/main/mainView.vue';
import department from './components/main/department.vue';
import student from './components/main/student.vue';
//import editor from './components/main/editor.vue';
import constructorMainPage from './components/main/constructor/constructorMainPage.vue';


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
        path: 'department',
        component: department
      },
      {
        path: 'student',
        component: student
      },
      {
        path:'constructorMainPage',
        component:constructorMainPage
      }
    ]
  }
]
