<template>
  <div>

  </div>
</template>

<script>
  export default {
    data() {
      return {
        state: {
          stateStr:'constructorMainPage_noStations',
          station_id: null,
          version_id: null,
          editing_mode: {
            //это только пример
            mode: 'pathEditing',
            mode_tool: 'addPath'
          }//выбранный режим редактора
        },
        stationsList:[], //список станций если они есть
        station:{ //объект станции, который будем доставать из базы данных
          name:'',
          description:'',
          id:0
        }
      }
    },
    beforeCreate() {
      //обратиться к базе данных
      //узнать есть ли в базе данных станции
      //если есть то получить их список и вывести на этой странице
      //если нет то перенаправить пользователя на другую страницу
    }
  }
</script>

<style scoped>

</style>
