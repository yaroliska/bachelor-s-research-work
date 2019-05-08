<template>
  <div class="wrapper">
    <div class="toolbar">
      <div class="path toolbar_part">
        <button class="toolbar_part_button" id="path_pallet_btn" v-on:click="editing_mode">Редактор Путей</button>
        <button type="button" class="toolbar_part_icon toolbar_part_path_btn" id="choose-path">
          <v-icon class="v-icon">navigation</v-icon>
        </button>
        <button type="button" class="toolbar_part_icon toolbar_part_path_btn" id="add-path">
          <v-icon class="v-icon">remove</v-icon>
        </button>
        <button type="button" class="toolbar_part_icon toolbar_part_path_btn" id="deadlock">
          <v-icon class="v-icon">space_bar</v-icon>
        </button>
        <button type="button" class="toolbar_part_icon toolbar_part_path_btn" id="path-settings">
          <v-icon class="v-icon">build</v-icon>
        </button>
        <button type="button" class="toolbar_part_icon toolbar_part_path_btn" id="delete-path">
          <v-icon class="v-icon">clear</v-icon>
        </button>
      </div>
      <div class="arrow toolbar_part">
        <button class="toolbar_part_button" id="arrow_pallet_btn" v-on:click="editing_mode">Редактор стрелок</button>
        <button type="button" class="toolbar_part_icon toolbar_part_arrow_btn" id="choose-arrow">
          <v-icon class="v-icon">navigation</v-icon>
        </button>
        <button type="button" class="toolbar_part_icon toolbar_part_arrow_btn" id="add-arrow">
          <v-icon class="v-icon">call_made</v-icon>
        </button>
        <button type="button" class="toolbar_part_icon toolbar_part_arrow_btn" id="arrow-settings">
          <v-icon class="v-icon">build</v-icon>
        </button>
        <button type="button" class="toolbar_part_icon toolbar_part_arrow_btn" id="delete-arrow">
          <v-icon class="v-icon">clear</v-icon>
        </button>
        <!--
        -->
      </div>
      <div class="traffic-light toolbar_part">
        <button class="toolbar_part_button" id="traffic-light_pallet_btn" v-on:click="editing_mode">Редактор светофоров
        </button>
      </div>
      <div class="infrastructure toolbar_part">
        <button class="toolbar_part_button" id="infrastructure_pallet_btn" v-on:click="editing_mode">Редактор объектов
          инфраструктуры
        </button>
      </div>
    </div>
    <canvas_editor :state="state"></canvas_editor>
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
      editing_mode: function (event) {
        if (event.srcElement.id === 'path_pallet_btn') {
          console.log('path_pallet_btn');
          //убираем кнопки в какой-то другой панели
          this.checkEditorPalletOn();
          document.getElementById('path_pallet_btn').classList.add('editor_pallet-on');
          document.getElementById('path_pallet_btn').style.display="none";
          //меняем state в соответствие с выбранной панелью
          this.state.editing_mode.mode = 'pathEditing';
          //добавляем кнопки
          let pathButtons = document.getElementsByClassName('toolbar_part_path_btn');
          for (let btn of pathButtons){
            btn.style.display="block";
          }
        }
        else if (event.srcElement.id === 'arrow_pallet_btn') {
          console.log('arrow_pallet_btn');
          this.checkEditorPalletOn();
          document.getElementById('arrow_pallet_btn').classList.add('editor_pallet-on');
          //меняем state
          //добавляем кнопки

        } else if (event.srcElement.id === 'traffic-light_pallet_btn') {
          console.log('traffic-light_pallet_btn');
          this.checkEditorPalletOn();
          document.getElementById('traffic-light_pallet_btn').classList.add('editor_pallet-on');
          //меняем state
          //добавляем кнопки

        } else if (event.srcElement.id === 'infrastructure_pallet_btn') {
          console.log('infrastructure_pallet_btn');
          this.checkEditorPalletOn();
          document.getElementById('infrastructure_pallet_btn').classList.add('editor_pallet-on');
          //меняем state
          //добавляем кнопки
        }
      },

      //help functions
      checkEditorPalletOn: function () {
        if (document.getElementsByClassName('editor_pallet-on').length > 0) {
          //нашли панель которая включена
          let panelId = document.getElementsByClassName('editor_pallet-on')[0].id;
          //нашли все кнопки для этой панели
          let buttons = document.getElementsByClassName(this.returnBtnClassForPallet(panelId));
          for (let btn of buttons) {
            btn.style.display="none";//выключили все кнопки
          }
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
      }


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
  .toolbar_part_arrow_btn, .toolbar_part_path_btn{
    display: none;
  }
</style>
