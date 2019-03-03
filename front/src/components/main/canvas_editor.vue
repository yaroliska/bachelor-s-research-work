<template>
  <canvas id="canvas" v-on:mousedown="handleMouseDown" v-on:mouseup="handleMouseUp" width="1000px" height="1000px">

  </canvas>
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
          path:{

          }
        }
      },
      methods: {
        align:function(val, st){
          return val - (val%st) + st/2;
          },
        drawDots: function () {
          console.log(this.canvas.width);
          console.log(this.canvas.height);
          //let ctx = document.getElementById("canvas").getContext("2d");
          for (let i = this.step/2; i < this.canvas.width; i+=this.step){
            for (let j = this.step/2; j < this.canvas.height; j+=this.step){
              this.canvas.ctx.fillRect(i,j,1,1);
            }
          }

        },
        draw: function () {
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
        },
        handleMouseUp: function (event) {
          this.mouse.down = false;
          this.mouse.current = {
            x: event.offsetX,
            y: event.offsetY
          };
          this.draw();
         /* axios.post('http://localhost:8081/api/path', this.student)
            .then(function (response) {
              console.log(response);
              self.getStudents();
              self.student.firstName = '';
              self.student.lastName = '';
              self.student.age = '';
              self.student.department = '';
            })*/
        }
      },
      mounted: function () {
        //alert('hi');
        this.canvas.width = document.getElementById("canvas").width;
        this.canvas.height =  document.getElementById("canvas").height;
        this.canvas.ctx =  document.getElementById("canvas").getContext("2d");
        this.drawDots();
        // var c = document.getElementById("canvas");
        // var ctx = c.
        // ctx.translate(0.5, 0.5);
        // ctx.imageSmoothingEnabled= false;
        // this.draw();
      }
    }

</script>

<style scoped>

</style>
