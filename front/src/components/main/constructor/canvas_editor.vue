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
          this.mouse.current = {
            x: event.offsetX,
            y: event.offsetY
          };
          if(this.$store.state.constructorState.editorState.editorMode.nameOfMode==='pathEditing'){
            this.iHandleMouseMovePath(event);
          }
          else if(this.$store.state.constructorState.editorState.editorMode.nameOfMode==='arrowEditing'){
            this.iHandleMouseMoveArrow(event);
          }
          else if(this.$store.state.constructorState.editorState.editorMode.nameOfMode==='traffic-lightEditing'){
            this.iHandleMouseMoveTrafficLight(event);
          }
          else if(this.$store.state.constructorState.editorState.editorMode.nameOfMode==='infrastructureEditing'){
            this.iHandleMouseMoveInfrastructure(event);
          }
        },
        iHandleMouseDown:function (event){
          console.log('iHandleMouseDown function');
          console.log(this.$store.state.constructorState.editorState.editorMode.nameOfMode);
          if(this.$store.state.constructorState.editorState.editorMode.nameOfMode==='pathEditing'){
            this.iHandleMouseDownPath(event);
          }
          else if(this.$store.state.constructorState.editorState.editorMode.nameOfMode==='arrowEditing'){
            this.iHandleMouseDownArrow(event);
          }
          else if(this.$store.state.constructorState.editorState.editorMode.nameOfMode==='traffic-lightEditing'){
            this.iHandleMouseDownTrafficLight(event);
          }
          else if(this.$store.state.constructorState.editorState.editorMode.nameOfMode==='infrastructureEditing'){
            this.iHandleMouseDownInfrastructure(event);
          }
        },
        iHandleMouseUp:function (event){
          if(this.$store.state.constructorState.editorState.editorMode.nameOfMode==='pathEditing'){
            this.iHandleMouseUpPath(event);
          }
          else if(this.$store.state.constructorState.editorState.editorMode.nameOfMode==='arrowEditing'){
            this.iHandleMouseUpArrow(event);
          }
          else if(this.$store.state.constructorState.editorState.editorMode.nameOfMode==='traffic-lightEditing'){
            this.iHandleMouseUpTrafficLight(event);
          }
          else if(this.$store.state.constructorState.editorState.editorMode.nameOfMode==='infrastructureEditing'){
            this.iHandleMouseUpInfrastructure(event);
          }
        },

        //PATH FUNCTIONS
        iHandleMouseDownPath:function(event){
          console.log('iHandleMouseDown Path function');
          //если мы хотим выделить путь
          if(this.$store.state.constructorState.editorState.editorMode.typeOfTool==="choose-path"){
          }
          //если мы хотим нарисовать путь
          else if(this.$store.state.constructorState.editorState.editorMode.typeOfTool==="add-path"){
            console.log('Я режим добавления путей');

            console.log('Я добавил первые координаты пути в текущий путь');
          }
          //
          else if(this.$store.state.constructorState.editorState.editorMode.typeOfTool==="deadlock"){
          }
          //
          else if(this.$store.state.constructorState.editorState.editorMode.typeOfTool==="path-settings"){
          }
        },
        iHandleMouseUpPath:function(event){
          console.log('iHandleMouseUP Path function');
          //если мы хотим выделить путь
          if(this.$store.state.constructorState.editorState.editorMode.typeOfTool==="choose-path"){
          }
          //если мы хотим нарисовать путь
          else if(this.$store.state.constructorState.editorState.editorMode.typeOfTool==="add-path"){
            console.log('Я режим добавления путей');
            console.log('Я добавил вторые координаты в текущий путь');
          }
          //
          else if(this.$store.state.constructorState.editorState.editorMode.typeOfTool==="deadlock"){
          }
          //
          else if(this.$store.state.constructorState.editorState.editorMode.typeOfTool==="path-settings"){
          }
        },
        iHandleMouseMovePath:function(event){
          //если мы хотим выделить путь
          if(this.$store.state.constructorState.editorState.editorMode.typeOfTool==="choose-path"){
          }
          //если мы хотим нарисовать путь
          else if(this.$store.state.constructorState.editorState.editorMode.typeOfTool==="add-path"){
          }
          //
          else if(this.$store.state.constructorState.editorState.editorMode.typeOfTool==="deadlock"){
          }
          //
          else if(this.$store.state.constructorState.editorState.editorMode.typeOfTool==="path-settings"){
          }
        },
        //ARROW FUNCTIONS
        iHandleMouseDownArrow:function(event){
          //если мы хотим выделить стрелку
          if(this.$store.state.constructorState.editorState.editorMode.typeOfTool==="choose-arrow"){
            //перенести сюда настройки и удаление
          }
          //если мы хотим добавить стрелку
          else if(this.$store.state.constructorState.editorState.editorMode.typeOfTool==="add-arrow"){
          }
          //если мы хотим настроить стрелку
          else if(this.$store.state.constructorState.editorState.editorMode.typeOfTool==="arrow-settings"){
          }
          //если мы хотим удалить стрелку
          else if(this.$store.state.constructorState.editorState.editorMode.typeOfTool==="delete-arrow"){
          }
        },
        iHandleMouseUpArrow:function(event){
          //если мы хотим выделить стрелку
          if(this.$store.state.constructorState.editorState.editorMode.typeOfTool==="choose-arrow"){
            //перенести сюда настройки и удаление
          }
          //если мы хотим добавить стрелку
          else if(this.$store.state.constructorState.editorState.editorMode.typeOfTool==="add-arrow"){
          }
          //если мы хотим настроить стрелку
          else if(this.$store.state.constructorState.editorState.editorMode.typeOfTool==="arrow-settings"){
          }
          //если мы хотим удалить стрелку
          else if(this.$store.state.constructorState.editorState.editorMode.typeOfTool==="delete-arrow"){
          }
        },
        iHandleMouseMoveArrow:function(event){
          //если мы хотим выделить стрелку
          if(this.$store.state.constructorState.editorState.editorMode.typeOfTool==="choose-arrow"){
            //перенести сюда настройки и удаление
          }
          //если мы хотим добавить стрелку
          else if(this.$store.state.constructorState.editorState.editorMode.typeOfTool==="add-arrow"){
          }
          //если мы хотим настроить стрелку
          else if(this.$store.state.constructorState.editorState.editorMode.typeOfTool==="arrow-settings"){
          }
          //если мы хотим удалить стрелку
          else if(this.$store.state.constructorState.editorState.editorMode.typeOfTool==="delete-arrow"){
          }
        },
        //TRAFFIC-LIGHT FUNCTIONS
        iHandleMouseDownTrafficLight:function(event){
          //если мы хотим выделить стрелку
          if(this.$store.state.constructorState.editorState.editorMode.typeOfTool==="choose-arrow"){
            //перенести сюда настройки и удаление
          }
        },
        iHandleMouseUpTrafficLight:function(event){
          //если мы хотим выделить стрелку
          if(this.$store.state.constructorState.editorState.editorMode.typeOfTool==="choose-arrow"){
            //перенести сюда настройки и удаление
          }
        },
        iHandleMouseMoveTrafficLight:function(event){
          //если мы хотим выделить стрелку
          if(this.$store.state.constructorState.editorState.editorMode.typeOfTool==="choose-arrow"){
            //перенести сюда настройки и удаление
          }
        },
        //TRAFFIC-LIGHT FUNCTIONS
        iHandleMouseDownInfrastructure:function(event){
          //если мы хотим выделить стрелку
          if(this.$store.state.constructorState.editorState.editorMode.typeOfTool==="choose-arrow"){
            //перенести сюда настройки и удаление
          }
        },
        iHandleMouseUpInfrastructure:function(event){
          //если мы хотим выделить стрелку
          if(this.$store.state.constructorState.editorState.editorMode.typeOfTool==="choose-arrow"){
            //перенести сюда настройки и удаление
          }
        },
        iHandleMouseMoveInfrastructure:function(event){
          //если мы хотим выделить стрелку
          if(this.$store.state.constructorState.editorState.editorMode.typeOfTool==="choose-arrow"){
            //перенести сюда настройки и удаление
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
