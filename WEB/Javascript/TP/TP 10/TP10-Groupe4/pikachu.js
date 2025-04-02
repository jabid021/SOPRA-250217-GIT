//1) saisir le nom du pokemon et valider avec le bouton (le nom ne doit pas etre vide !)
//2) Masquer la div formStart, Afficher la div grass, mettre le nom du pokemon en title sur la div pikachu
//3) Gerer les deplacements, pouvoir bouger dans toutes les directions (haut,bas,gauche,droite) => les fleches et / ou zqsd
//4) Modifier la position de la div pikachu en fonction de la direction (+-30px par deplacement) et changer l'image
//5) Verifier que pikachu ne sort pas de la div grass


var nomPokemon, randomX, randomY, randomIndex, randomCouleur;
var couleurs = ["bleue", "jaune"];
var posX=0;
var posY=0;
var mouvement=30;
var pokemon="pikachu";
var direction="Down";
var taille = 1;
imgPikachu.setAttribute("src","assets/img/"+pokemon+direction+".png");

inputName.onkeyup = verifInput;
btnStart.onclick = startGame;

function verifInput(event) {
  nomPokemon = inputName.value;
  if(nomPokemon == "") {
    btnStart.disabled=true;
  } else {
    btnStart.disabled=false;
    
    if(event.key=="Enter") {
      startGame();
    }
  }
}

function startGame(event) {
  
  formStart.style.display = "none";
  grass.style.display = "block";
  pikachu.setAttribute("title", nomPokemon);

  generateBerry();

  document.onkeydown = deplacement;

}

function deplacement(event) {
  
  if(event.key=="ArrowDown" || event.key=="s" )
  {
    if (posY < 660) { 
      posY = posY + 30;
    }
    direction = "Down";
  }
  else if(event.key=="ArrowRight" || event.key=="d" )
  {
    if (posX < 660) {
      posX = posX + 30;
    }
    direction = "Right";
  }

  else if(event.key=="ArrowLeft" || event.key=="q")
  {
    if (posX > 0) {
      posX = posX - 30;
    }
    direction = "Left";
  }

  else if(event.key=="ArrowUp" || event.key=="z")
  {
    if (posY > 0) {
      posY = posY - 30;
    }
    direction = "Up";
  }

  pikachu.style.top=posY+"px";
  pikachu.style.left=posX+"px";

  if (posX + 15 === randomX && posY + 15 === randomY) {
    eatBerry();
  }

  imgPikachu.setAttribute("src","assets/img/"+pokemon+direction+".png");
}

function generateBerry() {
  randomX = (Math.floor(Math.random() * 22) * 30) + 15;
  randomY = (Math.floor(Math.random() * 22) * 30) + 15;
  randomIndex = Math.round(Math.random());
  randomCouleur = couleurs[randomIndex];

  let baie = `<img id="baie${randomCouleur}" style="position: absolute; top: ${randomY}; left: ${randomX}" src="assets/img/baie_${randomCouleur}.png" />`;
  grass.innerHTML += baie;
}

function eatBerry() {
  document.getElementById(`baie${randomCouleur}`).remove();

  if (randomCouleur === "bleue") {
    if (pokemon === "raichu") {
      taille = taille / 1.3;
    }

    pokemon = "pikachu";

    if (taille > 0.6) {
      taille = taille - 0.1;
    }
    pikachu.style.transform = `scale(${taille})`;
  } else {
    if (pokemon === "pikachu") {
      taille = taille * 1.3;
    }

    pokemon = "raichu";

    if (taille <= 2.2) {
      taille = taille + 0.3;
    }
    pikachu.style.transform = `scale(${taille})`;
  } 
  
  

  generateBerry();
}
