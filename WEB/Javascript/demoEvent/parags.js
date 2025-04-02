
var couleurP = "#000000";
couleurText.onchange = changeColorParag;


paragPrinci.onmouseover = mouvementParag;

paragPrinci.onmouseout = mouvementParag;

/*paragPrinci.onmousemove = function(){console.log("move")}
paragPrinci.onclick = function(){console.log("click")}
paragPrinci.ondblclick = function(){console.log("dbl click")}
paragPrinci.onmousedown = function(){console.log("down")}
paragPrinci.onmouseup = function(){console.log("up")}
*/

function mouvementParag(event)
{

  if(event.type=="mouseover")
  {
    parag2.style.color="red";
    parag2.style.fontSize="30px";
  }
  else if(event.type=="mouseout")
  {
    parag2.style.color=couleurP;
    parag2.style.fontSize="17px";
  }

}



resetCouleur.onclick=function()
{
  couleurText.value="#000000";
  changeColorParag();
}


function changeColorParag()
{
  couleurP = couleurText.value;
  parag2.style.color=couleurP;
}
