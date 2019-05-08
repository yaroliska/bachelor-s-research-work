import Painter from './Painter'
import GeometricHelper from './GeometricHelper'

export default class Path {

  constructor(xbegin,ybegin,xend,yend) {
    this.xbegin = xbegin;
    this.ybegin =ybegin;
    this.xend = xend;
    this.yend = yend;
    this.park = null;
    this.number = null;
    this.arrows = [];
  }

  //рисует путь
  draw(painter){
    painter.drawLine(this.xbegin,this.ybegin,this.xend,this.yend);
  }

  //определяет что путь корректен
  isValidPath(){
    if ((this.xbegin===this.xend)&&(this.ybegin ===this.yend))
      return false;
    else return true;
  }

  //

}
