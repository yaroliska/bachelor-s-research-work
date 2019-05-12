<template>
  <div>
    <div class="items_list">
      <router-link to="addNewStation">
        <div class="addNewItem circle-group"
             v-on:click="changeMainHeader('Нажмите <- в браузере, чтобы вернуться назад')">
          <div class="circle circle__addNewItem"></div>
          <div class="under-circle">Создать новую</div>
        </div>
      </router-link>

      <div class="circle-group" v-on:click="chooseStation" v-if="checkStationAvailabilityFromStore"
           v-for="station in listOfStations">
        <router-link class="flex-column-center" to="constructorVersionsPage">
          <div class="circle"></div>
          <div class="under-circle" :id="station.id" >{{station.name}}</div>
        </router-link>
      </div>

    </div>
  </div>
</template>

<script>

  const axios = require('axios');

  export default {
    data() {
      return {
        listOfStations: [], //список станций если они есть
        station: { //объект станции, который будем доставать из базы данных
          name: '',
          description: '',
          id: 0
        }
      }
    },
    methods: {
      chooseStation(event) {
        console.log('chooseStation function(event)');
        this.changeMainHeader("Создайте новую версию или выберите из существующих");
        //записали в состояние какую станцию выбрали
        this.$store.state.constructorState.stationName = this.returnInnerTextFromCircleGroup(event);
        console.log(event);
        //здесь еще должен записаться ID станции
        console.log('переходим на' + this.$store.state.constructorState.stationName);
      },


      //ВСПОМОГАТЕЛЬНЫЕ ФУНКЦИИ, КОТОРЫЕ МОЖНО ВЫНЕСТИ
      returnInnerTextFromCircleGroup(event) {
        console.log('returnInnerTextFromCircleGroup function');
        if (event.srcElement.classList.contains('under-circle')) {
          this.stationToStorage(parseInt(event.srcElement.id));
          return event.srcElement.innerText;
        }
        else if (event.srcElement.classList.contains('circle')) {
          this.stationToStorage(parseInt(event.srcElement.nextSibling.nextElementSibling.id));
          return event.srcElement.nextSibling.nextElementSibling.innerText;
        }
        else if (event.srcElement.classList.contains('circle-group')) {
          this.stationToStorage(parseInt(event.srcElement.lastChild.id));
          return event.srcElement.lastChild.innerText;
        }
      },


    //STORE METHODS
    stationToStorage: function (id) {
      for (let st of this.listOfStations){
        if (st.id === id) {
          console.log('Выбрана станция:');
          console.log(st);
          this.$store.state.constructorState.station = st;
          }
        }
      },

      //STORE METHODS
      changeMainHeader: function (text) {
        console.log('changeMainHeader function');
        this.$store.commit('changeMainHeader', text);
      },

      checkStationAvailabilityFromStore: function () {
        console.log('checkStationAvailabilityFromStore function');
        console.log(this.$store.state.stationsExist);
        if (this.$store.state.stationsExist === true) {
          return true;
        }
        else {
          this.$store.commit('changeMainHeader', 'Вы еще не создали ни одной станции! Начните работу, нажав на Создать новую');
          return false;
        }
      },

      //DATABASE FUNCTIONS
      checkStationAvailability: function () {
        console.log('checkStationAvailability function');
        let self = this;
        console.log('checkStationAvailability function');
        axios.get('http://localhost:8081/api/station')
          .then(function (response) {
            console.log(response.data);
            console.log(response.data.length);
            if (response.data.length > 0) {
              console.log('response.data');
              self.listOfStations = response.data;
              self.$store.state.stationsExist = true;
              console.log('получили данные');
            }
            else {
              console.log('данных нет');
              self.$store.state.stationsExist = false;
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
      this.$store.commit('changeMainHeader', 'Выберите существующую станцию, или создайте новую!');
    }
  }
</script>

<style scoped>
  :root {
    --main-bg-color: brown;
    --green-lightest: #AED6C5;
    --green-light: #639C83;
    --green-medium: #338562; /* Main Primary color */
    --green-dark: #137048;
    --green-darkest: #003C22;
    --white: #fff;
  }

  .items_list {
    color: black;
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    justify-content: start;
    padding-top: 50px;
    padding-left: 35px;
    padding-right: 5px;
  }

  .circle {
    border: 2px solid var(--green-light);
    background-color: var(--green-lightest);
    border-radius: 50%;
    width: 150px;
    height: 150px;
  }

  .circle-group {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    padding-right: 30px;
    margin-bottom: 20px;
  }

  .circle__addNewItem {
    background-color: white;
    background-size: cover;
    background-image: url("/static/addNewItemCircle.png");
  }

  .under-circle {
    font-size: 20px;
    padding-top: 10px;
    color: var(--green-darkest);
  }
  /*данный класс должен быть вынесен*/
  .flex-column-center{
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
  }
</style>
