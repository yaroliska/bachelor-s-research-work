<template>
  <div class="add-new_wrapper">
    <div class="add-new">
      <div class="add-new__label">Введите название новой станции</div>
      <input type="text" id="add-new__input_station-name" class="add-new__input" name="name" required minlength="2" maxlength="30">
      <div class="add-new__label">Добавьте описание новой станции, если это необходимо</div>
      <textarea type="text" id="add-new__input_description" class="add-new__input add-new__input_description" name="name" required minlength="10"></textarea>
      <router-link to="constructorMainPage" class="flex-row-center">
        <button class="button_medium" v-on:click="saveNewStation">Сохранить</button>
      </router-link>
    </div>
  </div>
</template>

<script>
  import fieldsValidator from '../javascript/fieldsValidation.js';
  let fieldValidator =new fieldsValidator;
  const axios = require('axios');
    export default {
      name: "addNewStation",
      data() {
        return {
          station: { //объект станции, который будем доставать из базы данных
            name: '',
            description: '',
            id:'',
          }
        }
      },
      methods:{
        saveNewStation:function () {
          let name = document.getElementById('add-new__input_station-name').value;
          let description =document.getElementById('add-new__input_description').value;
         if(fieldValidator.checkStationNameInput(name)&&fieldValidator.checkDescriptionInput(description)){
            //если все норма -> отправляем данные на сервер
           console.log(name);
           console.log(description);
           this.station.name =name;
           this.station.description=description;
           console.log(this.station);
           this.postNewStation();
            //меняем состояние шины данных
           this.$store.state.constructorState.stationName=name;
          }else {
            //this.$store.state.exception ='текст ошибки';
           //в constructorMainPage => if(ошибка существует -> выплюнуть ее в виде всплывающего уведомления
          }
        },


        //STORE FUNCTIONS


        //DATABASE FUNCTIONS
        postNewStation(){
          console.log('post new station');
          axios.post('http://localhost:8081/api/station', this.station)
          .then(function (response) {
            this.$store.state.constructorState.stationId=response.data;
            location.href=location.href;
          })
        }
      }
    }
</script>

<style scoped>
  .add-new{
    display: flex;
    flex-direction: column;
    justify-content: center;
    height: 80vh;
  }
  .add-new__label{
    color:var(--green-medium);
    font-size: 20px;
    align-self: center;
    padding: 10px;
  }
  .add-new__input{
    border-style: solid;
    border-color: var(--green-lightest);
    border-width: 3px;
    border-radius: 5px;
    align-self: center;
    height: 50px;
    margin-bottom: 20px;
    width:400px;
    color:var(--green-light);
    font-size: 20px;
    text-align: center;
  }
  .add-new__input:focus,.add-new__input:hover{
    outline: none;
    border-color:var(--green-light);
  }

  .add-new__input_description{
    height: 150px;
  }
  .button_medium{
    color: var(--green-dark);
    font-size: 20px;
    border-style: solid;
    align-self: center;
    border-radius: 5px;
    border-color: var(--green-lightest);
    padding: 5px 10px 5px 10px;
    margin-top: 30px;
  }
  .button_medium:hover{
    outline: none;
    color:white;
    background-color: var(--green-lightest);
  }
  .button_medium:focus{
    border-color: var(--green-dark);
    background-color: var(--green-light);
    color:white;
    outline: none;
  }

  /*данный класс должен быть вынесен*/
  .flex-row-center{
    display: flex;
    flex-direction: row;
    justify-content: center;
  }

</style>
