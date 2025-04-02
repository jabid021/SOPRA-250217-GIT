//1) saisir le nom du pokemon et valider avec le bouton (le nom ne doit pas etre vide !)
//2) Masquer la div formStart, Afficher la div grass, mettre le nom du pokemon en title sur la div pikachu
//3) Gerer les deplacements, pouvoir bouger dans toutes les directions (haut,bas,gauche,droite) => les fleches et / ou zqsd
//4) Modifier la position de la div pikachu en fonction de la direction (+-30px par deplacement) et changer l'image
//5) Verifier que pikachu ne sort pas de la div grass

var posX=0;
var posY=0;
var mouvement=30;
var pokemon="pikachu";
var direction="Down";

grass.style.setProperty("display", "none");
gifEclair.style.setProperty("display", "none");

imgPikachu.setAttribute("src","assets/img/"+pokemon+direction+".png");

inputName.onkeyup=verifInput;
btnStart.onclick = start;


function verifInput()
{
  if(event.key=="Enter")
  {
    start();
  }

  else
  {
    let content = inputName.value;
    if(content=="")
    {
      btnStart.disabled=true;
    }
    else
    {
      btnStart.disabled=false;
    }
  }
}

function start()
{
  let content = inputName.value;
  if (inputName.value != "")
  {
    pikachu.setAttribute("title", inputName.value)
    formStart.style.setProperty("display", "none");
    grass.style.removeProperty("display");
    alert("x pour lancer un éclair");
    document.onkeydown=deplacement;
  }
}



function deplacement(event)
{
  if(event.key=="ArrowDown" || event.key=="s" )
  {
    direction="Down";
    if(posY+mouvement < 670)
    {
      posY+=mouvement;
    }
  }
  else if(event.key=="ArrowRight" || event.key=="d" )
  {
    direction="Right";
    if(posX+mouvement < 670)
    {
      posX+=mouvement;
    }
  }

  else if(event.key=="ArrowLeft" || event.key=="q")
  {
    direction="Left";
    if(posX-mouvement >= 0)
    {
      posX-=mouvement;
    }

  }

  else if(event.key=="ArrowUp" || event.key=="z")
  {
    direction="Up";
    if(posY-mouvement >= 0)
    {
      posY-=mouvement;
    }
  }

  else if(event.key=="x")
  {
    if (direction == "Up")
    {
      eclair("-150", "-50");
    }
    else if (direction == "Down")
    {
      eclair("-40", "-50");
    }
    else if (direction == "Left")
    {
      eclair("-80", "-110");
    }
    else if (direction == "Right")
    {
      eclair("-80", "10");
    }

  }

  function eclair(top, left)
  {
    gifEclair.style.removeProperty("display");
    gifEclair.style.setProperty("top", top);
    gifEclair.style.setProperty("left", left);
    setTimeout(function () {gifEclair.style.setProperty("display", "none");}, 500);

  }

  pikachu.style.top=posY+"px";
  pikachu.style.left=posX+"px";
  imgPikachu.setAttribute("src","assets/img/"+pokemon+direction+".png");

}
