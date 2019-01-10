import mainView from './components/main/mainView.vue';
import department from './components/main/department.vue';
import student from './components/main/student.vue';


export default [
  {
    path: '/',
    redirect: '/mainview/department'
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
      }
    ]
  }
]
