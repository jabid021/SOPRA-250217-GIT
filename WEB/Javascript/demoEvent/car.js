
carColor = "red";
var posX = 0;
var posY = 0;

btnVoiture.onclick=function()
{
  document.onkeydown=moveCar;
};


typeCar.ondblclick=function()
{
  carColor= (carColor=="red") ? "blue" : "red";
  typeCar.setAttribute("src",`${carColor}.gif`);
}



function moveCar(event)
{
    let changement=30;
  if(event.ctrlKey==true){changement=60 ;}

  if(event.key=="ArrowUp" || event.keyCode==90)
  {
    posY += changement;
    car.style.transform = "rotate(90deg)";
  }
  else if(event.key=="ArrowDown" || event.keyCode==83)
  {
    posY -= changement;
    car.style.transform = "rotate(-90deg)";
  }
  else if(event.key=="ArrowLeft" || event.keyCode==81)
  {
    posX += changement;
    car.style.transform="scaleX(1)";
  }
  else if(event.key=="ArrowRight" || event.keyCode==68)
  {
    posX -= changement;
    car.style.transform = "scaleX(-1)";
  }


  car.style.bottom=posY+"px";
  car.style.right=posX+"px";
}
