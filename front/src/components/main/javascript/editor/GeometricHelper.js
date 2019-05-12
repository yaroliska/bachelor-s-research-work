export default class GeometricHelper {
  //функция проверки принадлежности точки к линии
  checkPointAffiliation(x1,y1,x2,y2,x,y){
    if (((x -x1)*(y2-y1) - (x2-x1)*(y-y1))===0){
      if(y1===y2){
        if(x1===x2){
          //console.log("сравнение точки с точкой");
        }
        else{
          if(x1>x2){
            if((x>=x2)&&(x<=x1))return true;
            else return false;
          }
          else { if((x>=x1)&&(x<=x2)) return true;
          else return false;
          }
        }

      }
      else{
        if(y1>y2){
          if((y>=y2)&&(y<=y1))return true;
          else return false;
        }
        else{
          if((y>=y1)&&(y<=y2))return true;
          else return false;

        }

      }

    }
    return false;
  }

  //функция рисовании линии по двум точкам
  drawLine(ctx,x1,y1,x2,y2){
    ctx.beginPath();
    ctx.moveTo(x1,y1);
    ctx.lineTo(x2,y2);
    ctx.stroke();
  }
}
