<template>
  <div>
    <div class="items_list">
      <router-link to="addNewVersion">
        <div class="addNewItem circle-group"
             v-on:click="changeMainHeader('Нажмите <- в браузере, чтобы вернуться назад')">
          <div class="circle circle__addNewItem"></div>
          <div class="under-circle">Создать новую</div>
        </div>
      </router-link>

      <div class="circle-group" v-on:click="chooseVersion" v-if="checkVersionAvailabilityFromStore"
           v-for="version in listOfVersions">
        <router-link class="flex-column-center" to="editor">
          <div class="circle"></div>
          <div class="under-circle">{{version.name}}</div>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script>
  const axios = require('axios');
  export default {
    name: "constructorVersionsPage",
    data() {
      return {
        listOfVersions: [], //список станций если они есть
        version: { //объект версии, который будем доставать из базы данных
          creator: '',
          date: '',
          station: '',
          id: '',
          name: ''
        }
      }
    },
    methods: {
      chooseVersion(event) {
        console.log('chooseVersion function(event)');
        this.changeMainHeader("Нажмите на знак вопроса, чтобы узнать подробнее о возможностях редактора, или откройте руководство пользователя!");
        //записали в состояние какую станцию выбрали
        this.$store.state.constructorState.versionDate = this.returnInnerTextFromCircleGroup(event);
        console.log(event.srcElement.data);
        //здесь еще должен записаться ID версии
        console.log('переходим на версию ' + this.$store.state.constructorState.versionId);
      },


      //ВСПОМОГАТЕЛЬНЫЕ ФУНКЦИИ, КОТОРЫЕ МОЖНО ВЫНЕСТИ
      returnInnerTextFromCircleGroup(event) {
        console.log('returnInnerTextFromCircleGroup function');
        if (event.srcElement.classList.contains('under-circle')) {
          //TODO this.$store.state.constructorState.stationId=event.srcElement.id; - по аналогии
          return event.srcElement.innerText;
        }
        else if (event.srcElement.classList.contains('circle')) {
          return event.srcElement.nextSibling.nextElementSibling.innerText;
        }
        else if (event.srcElement.classList.contains('circle-group')) {
          return event.srcElement.lastChild.innerText;
        }
      },

      //STORE METHODS
      changeMainHeader: function (text) {
        console.log('changeMainHeader function');
        this.$store.commit('changeMainHeader', text);
      },

      checkVersionAvailabilityFromStore: function () {
        console.log('checkVersionAvailabilityFromStore function');
        console.log(this.$store.state.versionsExist);
        if (this.$store.state.versionsExist === true) {
          return true;
        }
        else {
          this.$store.commit('changeMainHeader', 'Вы еще не создали ни одной версии, для данной станции! Начните работу!');
          return false;
        }
      },

      //DATABASE FUNCTIONS
      checkVersionAvailability: function () {
        console.log('checkVersionAvailability function');
        let self = this;
        axios.get('http://localhost:8081/api/global_version?stationId='+this.$store.state.constructorState.station.id)
          .then(function (response) {
            // console.log(response.data);
            // console.log(response.data.length);
            if (response.data.length > 0) {
              console.log('response.data');
              self.listOfVersions= response.data;
              console.log(self.listOfVersions);
              self.$store.state.versionsExist = true;
              console.log('получили данные');
            }
            else {
              console.log('данных нет');
              self.$store.state.versionsExist = false;
            }
          })
          .catch(function (error) {
            console.log('ошибка');
            console.log(error);
          })
      }
    },
    mounted: function () {
      console.log('mounted constructorVersionPage');
      this.checkVersionAvailability();
      console.log(this.listOfVersions);
      this.$store.commit('changeMainHeader', 'Выберите существующую версию, или создайте новую! Для возврата нажмите <- в браузере');
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
  .flex-column-center {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
  }
</style>
