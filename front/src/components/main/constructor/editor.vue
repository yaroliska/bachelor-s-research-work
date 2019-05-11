<template>
  <div class="wrapper">
    <div class="toolbar">
      <!--//РЕДАКТОР ПУТЕЙ-->
      <div class="path toolbar_part">
        <button class="toolbar_part_button" id="path_pallet_btn" v-on:click="editing_mode">Редактор Путей</button>
        <button type="button" class="toolbar_part_icon toolbar_part_path_btn">
          <v-icon class="v-icon" id="choose-path" v-on:click="chooseTool">navigation</v-icon>
        </button>
        <button type="button" class="toolbar_part_icon toolbar_part_path_btn" >
          <v-icon class="v-icon" id="add-path" v-on:click="chooseTool">remove</v-icon>
        </button>
        <button type="button" class="toolbar_part_icon toolbar_part_path_btn" >
          <v-icon class="v-icon" id="deadlock" v-on:click="chooseTool">space_bar</v-icon>
        </button>
        <button type="button" class="toolbar_part_icon toolbar_part_path_btn" >
          <v-icon class="v-icon" id="path-settings" v-on:click="chooseTool">build</v-icon>
        </button>
        <button type="button" class="toolbar_part_icon toolbar_part_path_btn" >
          <v-icon class="v-icon" id="delete-path" v-on:click="chooseTool">clear</v-icon>
        </button>
      </div>

      <!--//РЕДАКТОР СТРЕЛОК-->
      <div class="arrow toolbar_part">
        <button class="toolbar_part_button" id="arrow_pallet_btn" v-on:click="editing_mode">Редактор стрелок</button>
        <button type="button" class="toolbar_part_icon toolbar_part_arrow_btn" >
          <v-icon class="v-icon" id="choose-arrow" v-on:click="chooseTool">navigation</v-icon>
        </button>
        <button type="button" class="toolbar_part_icon toolbar_part_arrow_btn" >
          <v-icon class="v-icon" id="add-arrow" v-on:click="chooseTool">call_made</v-icon>
        </button>
        <button type="button" class="toolbar_part_icon toolbar_part_arrow_btn" >
          <v-icon class="v-icon" id="arrow-settings" v-on:click="chooseTool">build</v-icon>
        </button>
        <button type="button" class="toolbar_part_icon toolbar_part_arrow_btn" >
          <v-icon class="v-icon" id="delete-arrow" v-on:click="chooseTool">clear</v-icon>
        </button>
        <!--
        -->
      </div>
      <!--//РЕДАКТОР СВЕТОФОРОВ-->
      <div class="traffic-light toolbar_part">
        <button class="toolbar_part_button" id="traffic-light_pallet_btn" v-on:click="editing_mode">Редактор светофоров
        </button>
        <button type="button" class="toolbar_part_icon toolbar_part_traffic-light_btn" >
          <v-icon class="v-icon" id="test1" v-on:click="chooseTool">navigation</v-icon>
        </button>
      </div>

      <!--//РЕДАКТОР ОБЪЕКТОВ ИНФРАСТРУКТУРЫ-->
      <div class="infrastructure toolbar_part">
        <button class="toolbar_part_button" id="infrastructure_pallet_btn" v-on:click="editing_mode">Редактор объектов
          инфраструктуры
        </button>
        <button type="button" class="toolbar_part_icon toolbar_part_infrastructure_btn" >
          <v-icon class="v-icon" id="test2" v-on:click="chooseTool">navigation</v-icon>
        </button>
      </div>
    </div>
    <canvas_editor></canvas_editor>
  </div>
</template>

<script>
  import canvas_editor from './canvas_editor.vue';

  export default {
    components: {
      'canvas_editor': canvas_editor
    },
    data() {
      return {
        state: {
          version_id: null,
          editing_mode: {
            //это только пример
            mode: 'pathEditing',
            mode_tool: 'addPath'
          }//выбранный режим редактора
        }
        //component: 'editor'
      }
    },
    methods: {
      //PANELS FUNCTIONS
      //определяет какая панель нажата, меняет режим редактирования в store, показывает кнопки
      editing_mode: function (event) {
        //ВЫБРАЛИ ПАНЕЛЬ УПРАВЛЕНИЯ ПУТЯМИ
        if (event.srcElement.id === 'path_pallet_btn') {
          console.log('path_pallet_btn');
          //убираем кнопки в какой-то другой панели
          this.checkEditorPalletOn();
          //делаем эту панель активной
          document.getElementById('path_pallet_btn').classList.add('editor_pallet-on');
          document.getElementById('path_pallet_btn').style.display="none";
          //меняем state в соответствие с выбранной панелью
          this.$store.state.constructorState.editorState.editorMode.nameOfMode = 'pathEditing';
          //делаем видимыми кнопки для этой панели
          let pathButtons = document.getElementsByClassName('toolbar_part_path_btn');
          for (let btn of pathButtons){
            btn.style.display="block";
          }

          //ВЫБРАЛИ ПАНЕЛЬ УПРАВЛЕНИЯ СТРЕЛКАМИ
        } else if (event.srcElement.id === 'arrow_pallet_btn') {
          console.log('arrow_pallet_btn');
          //убираем кнопки в какой-то другой панели
          this.checkEditorPalletOn();
          //делаем эту панель активной
          document.getElementById('arrow_pallet_btn').classList.add('editor_pallet-on');
          document.getElementById('arrow_pallet_btn').style.display="none";
          //меняем state в соответствие с выбранной панелью
          this.$store.state.constructorState.editorState.editorMode.nameOfMode = 'arrowEditing';
          //делаем видимыми кнопки для этой панели
          let arrowButtons = document.getElementsByClassName('toolbar_part_arrow_btn');
          for (let btn of arrowButtons){
            btn.style.display="block";
          }

          //ВЫБРАЛИ ПАНЕЛЬ УПРАВЛЕНИЯ СВЕТОФОРАМИ
        } else if (event.srcElement.id === 'traffic-light_pallet_btn') {
          console.log('traffic-light_pallet_btn');
          //убираем кнопки в какой-то другой панели
          this.checkEditorPalletOn();
          //делаем эту панель активной
          document.getElementById('traffic-light_pallet_btn').classList.add('editor_pallet-on');
          document.getElementById('traffic-light_pallet_btn').style.display="none";
          //меняем state в соответствие с выбранной панелью
          this.$store.state.constructorState.editorState.editorMode.nameOfMode = 'traffic-lightEditing';
          //делаем видимыми кнопки для этой панели
          let tlButtons = document.getElementsByClassName('toolbar_part_traffic-light_btn');
          for (let btn of tlButtons){
            btn.style.display="block";
          }

          //ВЫБРАЛИ ПАНЕЛЬ УПРАВЛЕНИЯ ОБЪЕКТАМИ ИНФРАСТРУКТУРЫ
        } else if (event.srcElement.id === 'infrastructure_pallet_btn') {
          console.log('infrastructure_pallet_btn');
          //убираем кнопки в какой-то другой панели
          this.checkEditorPalletOn();
          //делаем эту панель активной
          document.getElementById('infrastructure_pallet_btn').classList.add('editor_pallet-on');
          document.getElementById('infrastructure_pallet_btn').style.display="none";
          //меняем state в соответствие с выбранной панелью
          this.$store.state.constructorState.editorState.editorMode.nameOfMode = 'infrastructureEditing';
          //делаем видимыми кнопки для этой панели
          let infrButtons = document.getElementsByClassName('toolbar_part_infrastructure_btn');
          for (let btn of infrButtons){
            btn.style.display="block";
          }
        }
      },
      //находит предыдущую панель, которая была активна и удаляет из нее все кнопки
      checkEditorPalletOn: function () {
        if (document.getElementsByClassName('editor_pallet-on').length > 0) {
          //нашли панель которая включена
          document.getElementsByClassName('editor_pallet-on')[0].style.display="block";
          let panelId = document.getElementsByClassName('editor_pallet-on')[0].id;
          //нашли все кнопки для этой панели
          let buttons = document.getElementsByClassName(this.returnBtnClassForPallet(panelId));
          for (let btn of buttons) {
            btn.style.display="none";//выключили все кнопки
          }
          //вот тут надо включить саму панель(не включенную а вообще) чтобы она осталась как кнопка
          //отключили панель
          document.getElementsByClassName('editor_pallet-on')[0].classList.remove('editor_pallet-on');
        }
      },
      //метод который возвращает нам id для кнопок панели конкретного режима редактирования
      returnBtnClassForPallet:function (panelId) {
        //на вход приходит path_pallet_btn, arrow_pallet_btn, traffic-light_pallet_btn, infrastructure_pallet_btn
        //на выход должно быть toolbar_part_path_btn, toolbar_part_arrow_btn и т.д.

        //выход может быть сформирован с помощью такой функции:
        let type ='path'; // данный параметр должен быть вытащен из данных на входе
        let className=`toolbar_part_${type}_btn`;
        return className;
      },

      //TOOLS FUNCTIONS
      chooseTool:function (event) {
        //изменили состояние редактора в зависимости от того какая кнопка нажата
        this.$store.state.constructorState.editorState.typeOfTool = event.srcElement.id;
      }
    },
    mounted:function () {
      //при открытии данной компоненты в store должны быть уже записаны название станции, ее id, название версии и её id
      //заполняем store для тестирования
      this.$store.state.constructorState.stationName="Белозерки";//тут должен быть id станции, которую мы выбрали
      this.$store.state.constructorState.stationId =9999;
      this.$store.state.constructorState.versionDate='11/05/2019';
      this.$store.state.constructorState.versionId=9999;
      this.$store.state.constructorState.mainHeader="Белозерки (версия 11/05/2019)";
    }
  }
</script>

<style scoped>
  .v-icon {
    color: var(--green-dark);
    padding: 4px 6px 4px 6px;
  }

  .toolbar {
    display: flex;
    flex-direction: row;
    justify-content: flex-start;
    background-color: var(--green-darkest);
  }

  .toolbar_part {
    display: flex;
    flex-direction: row;
    border-right-style: solid;
    border-radius: 0px;
    margin: 0px 0px 0px 0px;
    border-color: var(--green-light);
  }

  .toolbar_part:hover {
    background-color: var(--green-dark);
  }

  .editor_pallet-on {
    background-color: var(--green-dark);
  }

  .toolbar_part_button {
    font-size: 20px;
    margin: 0;
    padding: 6px 10px 6px 10px;
  }

  .toolbar_part_icon {
    align-self: center;
    background-color: var(--green-light);
    margin: 2px;
    border-color: var(--green-lightest);
    border-width: 2px;
    border-style: solid;
    border-radius: 6px;
  }

  .toolbar_part_icon:hover {
    background-color: var(--green-lightest);
  }

  .toolbar_part_icon:active {

  }

  .toolbar_part_icon:focus {
    outline: none;
    background-color: var(--green-light);
    border-color: var(--green-darkest);
    border-width: 2px;
  }

  .v-icon:hover {
    color: var(--green-lightest);
  }
  .toolbar_part_arrow_btn, .toolbar_part_path_btn, .toolbar_part_traffic-light_btn, .toolbar_part_infrastructure_btn{
    display: none;
  }
</style>
