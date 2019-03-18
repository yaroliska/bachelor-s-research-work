<template>
  <div>
    <canvas id="interactive-canvas" v-on:mousedown="iHandleMouseDown" v-on:mouseup="iHandleMouseUp" v-on:mousemove="iHandleMouseMove" width="1000px" height="1000px">
  </canvas>
  <canvas id="canvas" v-on:mousedown="handleMouseDown" v-on:mouseup="handleMouseUp" width="1000px" height="1000px">
  </canvas>

  </div>
</template>

<script>
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
        canvas:{
        },
        icanvas:{
        },
        listOfPaths:[],
        possiblePath:{
          number:'2',
          xbegin:'',
          ybegin:'',
          xend:'',
          yend:'',
          park:null,
          arrows:[]
        }
      }
    },
    methods: {
      //функции отлова мыши
      iHandleMouseMove:function(event){
        this.mouse.current = {
          x: event.offsetX,
          y: event.offsetY
        };
        //console.log('Знаю где мышь: x- '+this.mouse.current.x +' y- ' +this.mouse.current.y);
      },
      iHandleMouseDown:function (event) {
        this.mouse.down = true;
        //добавить привязку к состоянию редактора
        //функция подсветки рисуемой линии
        this.possiblePath.xbegin = this.align(this.mouse.current.x, this.step);
        this.possiblePath.ybegin = this.align(this.mouse.current.y, this.step);
        //console.log('Нажато в точке '+ this.mouse.current.x +' ' +this.mouse.current.y);
        //console.log('Возможное начало пути: ' + this.possiblePath.xbegin +' ' + this.possiblePath.ybegin);
      },
      iHandleMouseUp:function (event) {
        //добавить привязку к состоянию редактора
        this.possiblePath.xend = this.align(this.mouse.current.x, this.step);
        this.possiblePath.yend = this.align(this.mouse.current.y, this.step);
        this.drawLine(this.icanvas.ctx,this.possiblePath.xbegin, this.possiblePath.ybegin, this.possiblePath.xend, this.possiblePath.yend);
        //функция отправки в базу данных новой линии и получения из базы сгенерированного id для нового пути
        if(this.isValidPath(this.possiblePath)) {
          this.listOfPaths.push(Object.assign({}, this.possiblePath));
          console.log(this.listOfPaths);
        }
        else console.log('Это было одинарное нажатие, путь записать нельзя');
      },

      //основные функции
      //находим ближайшую усредненную точку
      align:function (val, step) {
        return val -(val%step)+step/2;
      },

      //функция рисовании линии по двум точкам
      drawLine:function(ctx,x1,y1,x2,y2){
        ctx.beginPath();
        ctx.moveTo(x1,y1);
        ctx.lineTo(x2,y2);
        ctx.stroke();
      },

      //функция отрисовки всех путей, лежащих в listOfPaths
      drawPaths:function(ctx){
        for (let value of this.listOfPaths) {
          console.log(value);
          this.drawLine(ctx,value.xbegin,value.ybegin,value.xend,value.yend);
        }
      },



      //функция рисования точек на канвасе
      drawDots:function(canvas){
        for (let i=this.step/2; i<canvas.width; i+=this.step){
          for (let j=this.step/2; j<canvas.height; j+=this.step){
            canvas.ctx.fillRect(i,j,1,1)
          }
        }
      },

      //функция обработки одинарного нажатия при записи пути
      isValidPath:function(path){
        if ((path.xbegin===path.xend)&&(path.ybegin ===path.yend))
          return false;
        else return true;
      },




      //функции работающие с бд

      //функция отправки в базу данных новой линии и получения из базы сгенерированного id для нового пути
      setPath:function(){

      },

      //функция получения всех путей из базы данных и их записи во фронт
      getPaths:function(){
        //временная функция создания тестовых путей
      },

      //функции возвращающие canvas
      getCanvas:function(){
        this.canvas.width = document.getElementById("canvas").width;
        this.canvas.height =  document.getElementById("canvas").height;
        this.canvas.ctx =  document.getElementById("canvas").getContext("2d");
      },
      getICanvas:function () {
        this.icanvas.width = document.getElementById("interactive-canvas").width;
        this.icanvas.height =  document.getElementById("interactive-canvas").height;
        this.icanvas.ctx =  document.getElementById("interactive-canvas").getContext("2d");
      },



      //тестовые функции
      createListOfPaths:function(){

      }


     /* align:function(val, st){
        return val - (val%st) + st/2;
      },
      getPaths: function(){
        axios.get('http://localhost:8081/api/path')
          .then(function (response) {
            console.log(response.data);
            this.listOfPaths = response.data;
          })
          .catch(function (error) {
            console.log(error);
          })
      },
      drawPaths:function(){
        this.getPaths();
        console.log(this.listOfPaths);
      },
      //deletePath
      //findPath
      //drawPaths
      drawDots: function () {
        //let ctx = document.getElementById("canvas").getContext("2d");
        for (let i = this.step/2; i < this.canvas.width; i+=this.step){
          for (let j = this.step/2; j < this.canvas.height; j+=this.step){
            this.canvas.ctx.fillRect(i,j,1,1);
          }
        }

      },
      drawPath: function () {
        // let ctx = document.getElementById("canvas").getContext("2d");
        this.canvas.ctx.clearRect(0,0,1000,1000);
        this.drawDots();
        this.canvas.ctx.lineTo(this.align(this.mouse.current.x,this.step), this.align(this.mouse.current.y,this.step));
        this.canvas.ctx.strokeStyle ="#F63E02";
        this.canvas.ctx.lineWidth = 2;
        this.canvas.ctx.stroke();
      },
      handleMouseDown: function (event) {
        this.mouse.down = true;
        this.mouse.current = {
          x: event.offsetX,
          y: event.offsetY
        };
        this.canvas.ctx.moveTo(this.align(this.mouse.current.x,this.step), this.align(this.mouse.current.y,this.step));
        this.path.xbegin = this.align(this.mouse.current.x,this.step)+'';
        this.path.ybegin = this.align(this.mouse.current.y,this.step)+'';
      },
      handleMouseUp: function (event) {
        this.mouse.down = false;
        this.mouse.current = {
          x: event.offsetX,
          y: event.offsetY
        };
        this.drawPath();
        this.path.xend = this.align(this.mouse.current.x,this.step)+'';
        this.path.yend = this.align(this.mouse.current.y,this.step)+'';
        axios.post('http://localhost:8081/api/path', this.path)
          .then(function (response) {
            console.log(response);
          })
      }*/
    },
    mounted: function () {
      //получаем данные с канваса при загрузке
      this.getCanvas();
      this.getICanvas();
      this.drawDots(this.canvas);
      //this.drawPaths();
    }
  }
</script>

<style scoped>
  #canvas{
    position: absolute;
    top: 0;
    left: 0;
    border:1px solid #d3d3d3;
  }
  #interactive-canvas{
    position: absolute;
    top: 0;
    left: 0;
    z-index:2;
    border:1px solid #d3d3d3;
  }
</style>
