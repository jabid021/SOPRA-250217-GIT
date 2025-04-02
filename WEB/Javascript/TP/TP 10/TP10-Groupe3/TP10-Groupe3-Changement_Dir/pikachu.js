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
btnStart.onclick=startGame;

var mode = 0; // 0 = mode normal, 1 = mode inverse

document.onkeydown = getMode; // Écouteur d'événement pour la pression d'une touche

function getMode(event) {

  if (posX == 330 && posY == 330) {
    mode++;
  }


  if (mode % 2 == 0) {
    pokemon="pikachu";
    deplacementNormal(event);
    document.getElementById('beer').style.display = 'block';
    document.getElementById('water').style.display = 'none'
  } else {
    pokemon="coincoin";
    deplacementInverse(event);
    document.getElementById('beer').style.display = 'none';
    document.getElementById('water').style.display = 'block';
  }
}


function verifInput(event) {
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

function startGame() {
  formStart.style.display = "none";
  grass.style.display = "block";
}


function deplacementNormal(event)
{
  if (event.key === "ArrowDown" || event.key === "s") {
    if (posY + mouvement <= 660){
      posY += mouvement;
      direction = "Down";
    }
  }
  else if (event.key === "ArrowRight" || event.key === "d") {
    if (posX + mouvement <= 660){
      posX += mouvement;
      direction = "Right";
    }
  }
  else if (event.key === "ArrowLeft" || event.key === "q") {
    if (posX - mouvement >= 0){
      posX -= mouvement;
      direction = "Left";
    }
  }
  else if (event.key === "ArrowUp" || event.key === "z") {
    if (posY - mouvement >= 0) {
      posY -= mouvement;
      direction = "Up";
    }
  }
  pikachu.style.top = posY + "px";
  pikachu.style.left = posX + "px";
  imgPikachu.setAttribute("src", "assets/img/" + pokemon + direction + ".png");
};

function deplacementInverse(event)
{
  if (event.key === "ArrowUp" || event.key === "s") {
    if (posY + mouvement <= 660) {
      posY += mouvement;
      direction = "Down";
    }
  }
  else if (event.key === "ArrowLeft" || event.key === "d") {
    if (posX + mouvement <= 660) {
      posX += mouvement;
      direction = "Right";
    }
  }
  else if (event.key === "ArrowRight" || event.key === "q") {
    if (posX - mouvement >= 0) {
      posX -= mouvement;
      direction = "Left";
    }
  }
  else if (event.key === "ArrowDown" || event.key === "z") {
    if (posY - mouvement >= 0) {
      posY -= mouvement;
      direction = "Up";
    }
  }

  pikachu.style.top = posY + "px";
  pikachu.style.left = posX + "px";
  imgPikachu.setAttribute("src", "assets/img/" + pokemon + direction + ".png");
};
