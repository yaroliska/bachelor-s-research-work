<template>
  <div>
    <canvas id="canvas" v-on:mousedown="handleMouseDown" v-on:mouseup="handleMouseUp" width="1000px" height="1000px">
  </canvas>
  <canvas id="interactive-canvas" v-on:mousedown="iHandleMouseDown" v-on:mouseup="iHandleMouseUp" v-on:mousemove="iHandleMouseMove" width="1000px" height="1000px">
  </canvas>

  </div>
</template>

<script>
  const axios = require('axios');

    export default {
      props: {
        state:{
          editMode:String,
          required: true,
          default: 'default'
        }
      },
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
          path:{
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
      computed:{

      },
      methods:{
        iHandleMouseMove:function(event){

        },
        iHandleMouseDown:function (event) {

        },
        iHandleMouseUp:function (event) {

        }
      },
      mounted: function () {
        //получаем данные с канваса при загрузке
       // this.getCanvas();
        //this.getICanvas();
        //выполняем все необходимые запросы к бд и отрисовки перед началом работы
        //this.toStart();
      }
    }

</script>

<style scoped>
  #canvas{
    position: relative;
    float: left;
    border:1px solid #d3d3d3;
  }
  #interactive-canvas{
    position: relative;
    float:left;
    margin-left: -1002px;
    z-index:2;
    border:1px solid #d3d3d3;
  }
</style>
