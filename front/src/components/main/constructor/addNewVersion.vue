<template>
  <div class="add-new_wrapper">
    <div class="add-new">
      <div class="add-new__label">Введите ваше ФИО</div>
      <input type="text" id="add-new__input_creator-fio" class="add-new__input" name="name" required minlength="2" maxlength="50">
      <div class="add-new__label">Введите краткое название для данной версии</div>
      <input type="text" id="add-new__input_version-short-name" class="add-new__input" name="name" required minlength="2" maxlength="50">
      <div class="add-new__label">Добавьте описание новой версии, если это необходимо</div>
      <textarea type="text" id="add-new__input_version-description" class="add-new__input add-new__input_description" name="name" required minlength="10"></textarea>
      <router-link to="constructorVersionsPage" class="flex-row-center">
        <button class="button_medium" v-on:click="saveNewVersion">Сохранить</button>
      </router-link>
    </div>
  </div>
</template>

<script>
  import fieldsValidator from '../javascript/fieldsValidation.js';
  const axios = require('axios');
  let fieldValidator =new fieldsValidator;
    export default {
        name: "addNewVersion",
      data(){
      return {
        version: { //объект версии, который будем записывать в бд
          creator: '',
          date: '',
          description:'',
          name:'',//краткое название станции
          station: '',
          id: ''
        }
      }

      },
      methods:{
        saveNewVersion:function () {
          let fio = document.getElementById('add-new__input_creator-fio').value;
          let versionShortName = document.getElementById('add-new__input_version-short-name').value;
          let description = document.getElementById('add-new__input_version-description').value;
          if(fieldValidator.checkCreatorFIO(fio)&&fieldValidator.checkDescriptionInput(description)&&fieldValidator.checkVersionShortName(versionShortName)){
            //если все норма -> отправляем данные на сервер
            let now = new Date();
            console.log(fio);
            console.log(versionShortName);
            console.log(description);
            console.log(now);
            this.version.creator = fio;
            this.version.date = now;
            this.version.station = this.$store.state.constructorState.station;
            this.version.description=description;
            this.version.name = versionShortName;
            console.log(this.version);
            this.postNewVersion();
            this.$store.state.constructorState.stationName=versionShortName;
            //меняем состояние шины данных
          }else {
            //this.$store.state.exception ='текст ошибки';
            //в constructorMainPage => if(ошибка существует -> выплюнуть ее в виде всплывающего уведомления
          }
        },
        //STORE FUNCTIONS


        //DATABASE FUNCTIONS
        postNewVersion(){
          console.log(this.version);
          axios.post('http://localhost:8081/api/global_version', this.version)
            .then(function (response) {
              console.log(response.data);
              this.$store.state.constructorState.versionId=response.data;
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
