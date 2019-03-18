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
        this.possiblePath.xbegin = this.align(this.mouse.current.x, this.step);
        this.possiblePath.ybegin = this.align(this.mouse.current.y, this.step);
        //console.log('Нажато в точке '+ this.mouse.current.x +' ' +this.mouse.current.y);
        //console.log('Возможное начало пути: ' + this.possiblePath.xbegin +' ' + this.possiblePath.ybegin);
      },
      iHandleMouseUp:function (event) {
        //добавить привязку к состоянию редактора
       /* this.possiblePath.xend = this.align(event.offsetX, this.step);
        possiblePath.y2 = align(e.offsetY, step);
        drawLine(ctx,possiblePath.x1,possiblePath.y1, possiblePath.x2, possiblePath.y2);
        //функция отправки в базу данных новой линии и прием из базы сгенерированного id для нового пути
        console.log(pathsArray);
        pathsArray.push(Object.assign({},possiblePath));
        console.log(pathsArray);*/
      },
      align:function (val, step) {
        return val -(val%step)+step/2;
      },
      getCanvas:function () {

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
      this.canvas.width = document.getElementById("canvas").width;
      this.canvas.height =  document.getElementById("canvas").height;
      this.canvas.ctx =  document.getElementById("canvas").getContext("2d");
     // this.drawDots();
      //this.drawPaths();
    }
  }
</script>

<style scoped>

</style>
