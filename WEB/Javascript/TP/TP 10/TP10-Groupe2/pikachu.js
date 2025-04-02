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
imgPikachu.setAttribute("src","assets/img/"+pokemon+direction+".png");

inputName.onkeyup=verifInput;
btnStart.onclick=apparitionGrass;
function verifInput(event)
{
  if(event.key=="Enter")
  {
    var nom = imputName.value;
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

function apparitionGrass()
{
  document.getElementById("pikaShoot").style.display = "none";
  document.getElementById("formStart").style.display = "none";
  document.getElementById("grass").style.display = "block";
  document.onkeydown=deplacement;
}

function deplacement(event)
{
  if(event.key=="ArrowDown" || event.key=="s" )
  {
    posY += mouvement;
    direction="Down";

  }
  else if(event.key=="ArrowRight" || event.key=="d" )
  {
    posX += mouvement;
    direction="Right";

  }

  else if(event.key=="ArrowLeft" || event.key=="q")
  {
    posX -= mouvement;
    direction="Left";

  }

  else if(event.key=="ArrowUp" || event.key=="z")
  {
    posY -= mouvement;
    direction="Up";
  }
  if (posX<0) {
    posX = 0;
  }
  if (posY<0) {
    posY = 0;
  }
  if (posX>=660) {
    posX = 660;
  }
  if (posY>=660) {
    posY = 660;
  }

  pikaShoot.style.top=posY+"px";
  pikaShoot.style.left=posX+"px";
  pikachu.style.top=posY+"px";
  pikachu.style.left=posX+"px";
  imgPikachu.setAttribute("src","assets/img/"+pokemon+direction+".png");
  console.log(posX);

  if (330<=posX  && posX<=360 && 330<=posY && posY<=360)
  {
    document.getElementById("canabis").style.display = "none";
    document.getElementById("sd").style.display = "block";
    document.getElementById("pikaShoot").style.display = "block";
    document.getElementById("pikachu").style.display = "none";

    sound.play();
    mouvement = 90;
  }

}
