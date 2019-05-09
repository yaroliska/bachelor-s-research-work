<template>
  <div>

  </div>
</template>

<script>
  const axios = require('axios');

  export default {
    data() {
      return {
        state: {
          stateStr: 'constructorMainPage_noStations',
          station_id: null,
          version_id: null,
          editing_mode: {
            //это только пример
            mode: 'pathEditing',
            mode_tool: 'addPath'
          }//выбранный режим редактора
        },
        listOfStations: [], //список станций если они есть
        station: { //объект станции, который будем доставать из базы данных
          name: '',
          description: '',
          id: 0
        }
      }
    },
    methods: {},
      //DATABASE FUNCTIONS
      beforeCreate() {
        function checkStationAvailability(){
          axios.get('http://localhost:8081/api/station')
            .then(function (response) {
              console.log(response.data);
              // this.listOfStations=response.data;
            })
            .catch(function (error) {
              console.log(error);
            })
        }
        //обратиться к базе данных
        checkStationAvailability();
        //узнать есть ли в базе данных станции
        //если есть то получить их список и вывести на этой странице
        //если нет то перенаправить пользователя на другую страницу
      },
    mounted:function () {
      document.getElementById('v-toolbar-title-header').innerText="Руководство пользователя";
    }
  }
</script>

<style scoped>

</style>
