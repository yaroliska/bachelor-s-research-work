(function(window, document, undefined){
// code that should be taken care of right away
window.onload = init;
function init(){
	runEditor();
}
})(window, document, undefined);

function runEditor(){
	let canvas = document.getElementById("canvas");
	let interactiveCanvas = document.getElementById("interactive-canvas");
	let ctx_interactive = interactiveCanvas.getContext("2d");
	let ctx = canvas.getContext("2d");
	let step=20;
	let pathsArray = [];
	let possiblePath ={};
	
	drawDots(step, canvas, ctx);//рисуем точки на канвасе
	drawPaths(ctx,pathsArray);//отобразить пути из массива
	//подсветить путь по наведению
	interactiveCanvas.onmousemove = function(e){
		highlightLine(interactiveCanvas, ctx_interactive, e.offsetX, e.offsetY, pathsArray, canvas, ctx);
	}
	interactiveCanvas.onmousedown = function(e){
		possiblePath.x1 = align(e.offsetX,step);
		possiblePath.y1 = align(e.offsetY, step);
	}
	interactiveCanvas.onmouseup = function(e){
		possiblePath.x2 = align(e.offsetX,step);
		possiblePath.y2 = align(e.offsetY, step);
		drawLine(ctx,possiblePath.x1,possiblePath.y1, possiblePath.x2, possiblePath.y2);
		//функция отправки в базу данных новой линии и прием из базы сгенерированного id для нового пути
		pathsArray.push(Object.assign({},possiblePath));
		console.log(pathsArray);
	}
}

function drawDots(step,canvas,ctx){
	for (let i=step/2; i<canvas.width; i+=step){
		for (let j=step/2; j<canvas.height; j+=step){
			ctx.fillRect(i,j,1,1)
		}
	}
}

function getPaths(pathsArray){
	//функция получения путей из бд (пока только на js)
	path1 = {};
	path1.id = 0;
	path1.x1 = 70;
	path1.x2 = 190;
	path1.y1 = 190;
	path1.y2 = 190;
	path2 = {};
	path2.id = 1;
	path2.x1 = 190;
	path2.x2 = 210;
	path2.y1 = 190;
	path2.y2 = 170;
	path3 = {};
	path3.id = 2;
	path3.x1 = 210;
	path3.x2 = 350;
	path3.y1 = 170;
	path3.y2 = 170;
	path4 = {};
	path4.id = 3;
	path4.x1 = 190;
	path4.x2 = 210;
	path4.y1 = 190;
	path4.y2 = 210;
	path5 = {};
	path5.id = 4;
	path5.x1 = 210;
	path5.x2 = 350;
	path5.y1 = 210;
	path5.y2 = 210;
	pathsArray.push(path1,path2,path3,path4,path5);
}

function drawPaths(ctx,pathsArray){
	getPaths(pathsArray);//забираем пути из БД
	for (let value of pathsArray) {
		drawLine(ctx,value.x1,value.y1,value.x2,value.y2);
	}
}

function align(val, step){
	return val - (val%step) + step/2;
}

function drawLine(ctx,x1,y1,x2,y2){
	ctx.beginPath();
	ctx.moveTo(x1,y1);
	ctx.lineTo(x2,y2);
	ctx.stroke();
}

function redrawPaths(ctx, canvas, pathsArray){
	ctx.clearRect(0, 0, canvas.width, canvas.height);
	drawPaths(ctx, pathsArray);
}

function highlightLine(interactiveCanvas, ctx_interactive, x,y, pathsArray, canvas, ctx){ 
	let b=false; 
	for (let value of pathsArray){ 
		if(checkPointАffiliation(value.x1,value.y1,value.x2,value.y2,x,y)){ 
			console.log('popali!'); 
			b=true; 
			changeColor(ctx_interactive,"green"); 
			drawLine(ctx_interactive,value.x1,value.y1,value.x2,value.y2); 
		} 
	} 
	if(!b){ctx_interactive.clearRect(0, 0, interactiveCanvas.width, interactiveCanvas.height); 
	} 
} 

function checkPointАffiliation(x1,y1,x2,y2,x,y){
	if (((x -x1)*(y2-y1) - (x2-x1)*(y-y1))==0){
		if(y1==y2){
			if(x1==x2){
				console.log("сравнение точки с точкой");
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

function changeColor(ctx,color){
	if(color == "green"){
		ctx.strokeStyle = "#3ACFAE";
		ctx.fillStyle="#3ACFAE";
	}
	if(color =="grey"){
		ctx.strokeStyle = "#707070";
		ctx.fillStyle="#707070";
	}
}