export default class Painter
{
  constructor(step, canvas, ctx) {
    this.step = step;
    this.canvas = canvas;
    this.ctx = ctx;
  }

  //функция рисования точек на канвасе
  drawDots(){
    for (let i=this.step/2; i<this.canvas.width; i+=this.step){
      for (let j=this.step/2; j<this.canvas.height; j+=this.step){
        this.ctx.fillRect(i,j,1,1)
      }
    }
  }
  //Функция рисования линии по 4м точкам
  drawLine(x1,y1,x2,y2){
    this.ctx.beginPath();
    this.ctx.moveTo(x1,y1);
    this.ctx.lineTo(x2,y2);
    this.ctx.stroke();
  }
}
