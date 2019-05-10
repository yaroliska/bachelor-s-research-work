<template>
  <div>
    <div class="items_list">
      <router-link to="addNewStation" >
      <div class="addNewItem circle-group" >
        <div class="circle circle__addNewItem"></div>
        <div class="under-circle">Создать новую</div>
      </div>
      </router-link>
      <div class ="circle-group" v-if="checkStationAvailabilityFromStore" v-for="station in listOfStations">
        <div class="circle"></div>
        <div class="under-circle">{{station.name}}</div>
      </div>
    </div>
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
    computed:{

    },
    methods: {


      //STORE METHODS
      checkStationAvailabilityFromStore:function(){
        console.log(this.$store.state.stationsExist);
        if (this.$store.state.stationsExist===true){
          return true;
        }
        else return false;
      },

      //DATABASE FUNCTIONS
      checkStationAvailability: function () {
        let self = this;
        console.log('checkStationAvailability function');
        axios.get('http://localhost:8081/api/station')
          .then(function (response) {
            console.log(response.data);
            console.log(response.data.length);
            if (response.data.length > 0) {
              console.log('response.data');
              self.listOfStations = response.data;
              self.$store.state.stationsExist=true;
              console.log('получили данные');
            }
            else {
              console.log('данных нет');
              self.$store.state.stationsExist=false;
            }
          })
          .catch(function (error) {
            console.log('ошибка');
            console.log(error);
          })
      }
      },
      mounted: function () {
        console.log('mounted');
        this.checkStationAvailability();
        console.log(this.listOfStations);
      }
    }
</script>

<style scoped>
  :root {
    --main-bg-color: brown;
    --green-lightest:#AED6C5 ;
    --green-light:#639C83;
    --green-medium: #338562;	/* Main Primary color */
    --green-dark:#137048;
    --green-darkest: #003C22;
    --white: #fff;
  }
  .items_list{
    color:black;
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    justify-content: start;
    padding-top: 50px;
    padding-left: 35px;
    padding-right: 5px;
  }

  .circle{
    border: 2px solid var(--green-light);
    background-color: var(--green-lightest);
    border-radius: 50%;
    width: 150px;
    height: 150px;
  }
  .circle-group{
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    padding-right: 30px;
  }
  .circle__addNewItem{
    background-color: white;
    background-size: cover;
    background-image: url("/static/addNewItemCircle.png");
  }
  .under-circle{
    font-size: 20px;
    padding-top: 10px;
    color: var(--green-darkest);
  }
</style>
