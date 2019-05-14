<template>
  <div v-on:click="contextMenuOff">
    <div class="items_list" v-on:click="contextMenuOff">
      <router-link to="addNewStation">
        <div class="addNewItem circle-group"
             v-on:click="changeMainHeader('Нажмите <- в браузере, чтобы вернуться назад')">
          <div class="circle circle__addNewItem"></div>
          <div class="under-circle">Создать новую</div>
        </div>
      </router-link>

      <div class="circle-group" v-on:click="chooseStation" v-on:contextmenu="contextMenuOn"
           v-if="checkStationAvailabilityFromStore"
           v-for="station in listOfStations">
        <router-link class="flex-column-center" to="constructorVersionsPage">
          <div class="circle"></div>
          <div class="wrap">
            <div class="under-circle" :id="station.id">{{station.name}}</div>
          </div>
        </router-link>
      </div>

    </div>
    <div class="context-menu">
      <ul class="context-menu__items">
        <li class="context-menu__item" v-on:click="deleteStation">
          <a href="#" class="context-menu__link">
            <i class="fa fa-eye"></i> Удалить станцию
          </a>
        </li>
        <li class="context-menu__item">
          <a href="#" class="context-menu__link">
            <i class="fa fa-edit"></i> Посмотреть подробную информацию
          </a>
        </li>
      </ul>
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
        },
        menuState: 0
      }
    },
    methods: {
      deleteStation(){
        axios.get('http://localhost:8081/api/station/delete?id='+34)
          .then(function (response) {
            // doesn't work Dunno why.
            console.log(response.data);
            window.location.href=location.href.substring(0,location.href.length-1);
          })
        // setTimeout(function(){location.href=location.href; console.log('Ratata')},1000)
        // console.log('Ratata____');
      },
      contextMenuOn(event) {
        event.preventDefault();
        console.log('contextMenuOver');
        let menu = document.getElementsByClassName('context-menu');
        if (this.menuState === 0) {
          this.menuState = 1;
          menu[0].classList.replace('context-menu', 'context-menu--active');
          console.log(event);
          let menuNew = document.getElementsByClassName('context-menu--active')[0];
          console.log(menuNew);
          console.log(event.clientX, '   ', event.clientY);
          if (document.getElementsByClassName('v-navigation-drawer--mini-variant')[0] != undefined) {
            menuNew.style.left = `${event.clientX - 80}px`;
            menuNew.style.top = `${event.clientY - 48}px`;
          } else if (document.getElementsByClassName('v-navigation-drawer--open')[0] != undefined) {
            menuNew.style.left = `${event.clientX - 300}px`;
            menuNew.style.top = `${event.clientY - 48}px`;
          }
        }
        //menu[0].style.left= event.clientX;
        //menu[0].style.top = event.clientY;
      },
    contextMenuOff(event) {
      if (this.menuState === 1) {
        let menu = document.getElementsByClassName('context-menu--active');
        this.menuState = 0;
        menu[0].classList.replace('context-menu--active', 'context-menu');
      }
    },

    chooseStation(event) {
      console.log('chooseStation function(event)');
      this.changeMainHeader("Создайте новую версию или выберите из существующих");
      //записали в состояние какую станцию выбрали
      this.$store.state.constructorState.stationName = this.returnInnerTextFromCircleGroup(event);
      console.log(event);
      //здесь еще должен записаться ID станции
      console.log('переходим на' + this.$store.state.constructorState.stationName);
      this.toggleMenuOn();
    },
    toggleMenuOn() {
      if (menuState !== 1) {
        menuState = 1;
        menu.classList.add(active);
      }
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
      for (let st of this.listOfStations) {
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
  }
  ,
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

  .wrap {
    display: flex;
    flex-direction: row;
    align-items: center;
  }

  .menu {
    font-size: 20px;
    border-style: solid;
    border-color: var(--green-medium);
    border-width: 1px;
    border-radius: 14px;
    margin: 0px 0px 0px 5px;
    padding: 0px 9px 0px 9px;
    color: var(--green-dark);
    text-align: center;
    background-color: var(--green-lightest);
  }

  .menu:hover {

  }

  .menu:after {

  }

  /*данный класс должен быть вынесен*/
  .flex-column-center {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
  }

  .context-menu {
    display: none;
    position: absolute;
    z-index: 10;
  }

  .context-menu--active {
    display: block;
    position: absolute;
    left: 0px;
    top: 0px;
  }

  .context-menu__item {
    background-color: var(--green-light);
    padding: 2px 10px 2px 10px;
    list-style-type: none;
  }

  .context-menu__link {
    font-size: 19px;
    color: var(--white);
  }

  .context-menu__items {
    border-radius: 5px;
    background-color: var(--green-light);
    padding: 2px 10px 2px 15px;
  }
</style>
