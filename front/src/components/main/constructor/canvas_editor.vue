<template>
  <div>
    <canvas id="canvas" width="1380px" height="1000px">
  </canvas>
  <canvas id="interactive-canvas" v-on:mousedown="iHandleMouseDown" v-on:mouseup="iHandleMouseUp" v-on:mousemove="iHandleMouseMove" width="1380px" height="1000px">
  </canvas>

  </div>
</template>

<script>
  import Painter from '../javascript/editor/Painter.js';
  const axios = require('axios');
    export default {
      data: function () {
        return {
          mouse: {
            current: {
              x: 0,
              y: 0
            },
            down: false
          },
          step: 20,
          canvas:{},
          icanvas:{},
          helper:{},
          path:{
            number:'0',
            xbegin:'',
            ybegin:'',
            xend:'',
            yend:'',
            park:null,
            arrows:[]
          }
        }
      },
      computed:{

      },
      methods:{
        //MOUSE
        iHandleMouseMove:function(event){

        },
        iHandleMouseDown:function (event){
          if(this.$store.state.constructorState.editorState.editorMode.nameOfMode==='pathEditing'){
            this.iHandleMouseDownPath(event);
          }
        },
        iHandleMouseUp:function (event){
          if(this.$store.state.constructorState.editorState.editorMode.nameOfMode==='pathEditing'){
            //запускаем метод, который обрабатывает панель путей
            //path
          }
        },

        //PATH FUNCTIONS
        iHandleMouseDownPath:function(event){
          //если мы хотим выделить путь
          if(this.$store.state.constructorState.editorState.editorMode.typeOfTool==="choose-path"){
            //сюда надо перенести настройки пути (по выделению пути должно разворачиваться небольшое окно справа вверху с настройками)
            //сюда надо
          }
          //если мы хотим нарисовать путь
          else if(this.$store.state.constructorState.editorState.editorMode.typeOfTool==="add-path"){

          }
          //если мы хотим нарисовать тупик
          else if(this.$store.state.constructorState.editorState.editorMode.typeOfTool==="deadlock"){

          }
          //если мы хотим настроить путь
          else if(this.$store.state.constructorState.editorState.editorMode.typeOfTool==="path-settings"){

          }
        },

        //MOUNTED FUNCTIONS
        //получаем данные с канваса
        getCanvas:function(){
          this.canvas.width = document.getElementById("canvas").width;
          this.canvas.height =  document.getElementById("canvas").height;
          this.canvas.ctx =  document.getElementById("canvas").getContext("2d");
        },
        //получаем данные с интерактивного канваса
        getICanvas:function () {
          this.icanvas.width = document.getElementById("interactive-canvas").width;
          this.icanvas.height =  document.getElementById("interactive-canvas").height;
          this.icanvas.ctx =  document.getElementById("interactive-canvas").getContext("2d");
        },
        //вызывается в mounted и подготовливает все необходимое к началу работы
        toStart:function () {
          let painter = new Painter(20,this.canvas, this.canvas.ctx);
          let i_painer = new Painter(20,this.icanvas, this.icanvas.ctx);
          this.helper.painter=painter;
          this.helper.ipainter=i_painer;
          painter.drawDots();
          //забрать пути из базы данных
        }
      },
      mounted: function () {
        //получаем данные с канваса при загрузке
        this.getCanvas();
        this.getICanvas();
        //выполняем все необходимые запросы к бд и отрисовки перед началом работы
        this.toStart();
      }
    }

</script>

<style scoped>
  #canvas{
    position: relative;
    float: left;
    border:1px solid #d3d3d3;
    margin-top:42px;
  }
  #interactive-canvas{
    position: absolute;
    /* float: left; */
    z-index: 2;
    border: 1px solid #d3d3d3;
    margin-top: 42px;
    margin-left: -1382px;
  }
</style>
