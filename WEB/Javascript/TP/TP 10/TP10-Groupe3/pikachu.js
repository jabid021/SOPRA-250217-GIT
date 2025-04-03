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
var pikachu = document.getElementById(pokemon);
var pikachu2 = document.getElementById(pokemon+"2");
var themePokemon = document.getElementById("themePokemon");
var champiAudio= document.getElementById("mushroom");
var teleportAudio = document.getElementById("teleport");
var princessAudio = document.getElementById("princess");
var princessAudio2 = document.getElementById("magic");
var cloneAudio = document.getElementById("pop");
var drinkAudio = document.getElementById("drinking");
var inputName = document.getElementById("inputName");
var inputStart = document.getElementById("btnStart");
var divStart = document.getElementById("formStart");
var grass = document.getElementById("grass");
var champignon = document.getElementById("champignon");
var crown = document.getElementById("crown");
var diamond = document.getElementById("diamond");
var clone = document.getElementById("clone");
var biere = document.getElementById("beer");
var eau = document.getElementById("bottle");
eau.style.display = "none";
var nom;
imgPikachu.setAttribute("src","assets/img/"+pokemon+direction+".png");



function toogle(){
  inputStart.disabled = false;
  nom = inputName.value;
}

function run(){
  pikachu.setAttribute("title",nom);
  divStart.style.display = "none";
  grass.style.display = "flex";
  themePokemon.play();
}


document.addEventListener("keydown",deplacement);


  function deplacement(event)
  {
    if(event.key=="ArrowDown" || event.key=="s" )
    {
      direction = "Down";
      if(posY!=660){
        posY+=30;
      }


    }
    else if(event.key=="ArrowRight" || event.key=="d" )
    {
      direction = "Right";
      if(posX!=660){
        posX+=30
      }
    }

    else if(event.key=="ArrowLeft" || event.key=="q")
    {
      direction = "Left";
      if(posX!=0){
        posX-=30;
      }
    }

    else if(event.key=="ArrowUp" || event.key=="z")
    {
      direction = "Up";
      if(posY!=0){
        posY-=30;
      }
    }

    if((posX==60 && posY==90) && champignon.style.display!="none"){
      pikachu.style.scale ="2";
      champignon.style.display ="none";
      champiAudio.play();
    }
    if((posX==390 && posY==600)&& teleporteur.style.display!="none"){
      posX = 0;
      posY = 0;
      teleporteur.style.display = "none";
      teleportAudio.play();
    }
    if((posX==60 && posY==360)&& crown.style.display!="none"){
      pokemon = "peach";
      imgPikachu.style.width = "30px";
      imgPikachu2.style.width = "30px";
      crown.style.display = "none";
      princessAudio.play();
    }
    if((posX==240 && posY==480)&& diamond.style.display!="none"){
      pokemon = "princess";
      imgPikachu.style.width = "30px";
      imgPikachu2.style.width = "30px";
      diamond.style.display = "none";
      princessAudio2.play();
    }
    if((posX==570 && posY==240)&& clone.style.display!="none"){
      imgPikachu2.setAttribute("src","assets/img/"+pokemon+direction+".png");
      pikachu2.style.top=posY-50+"px";
      pikachu2.style.left=posX-50+"px";
      pikachu2.style.display = "block";
      clone.style.display = "none";
      cloneAudio.play();
    }
    if((posX==330 && posY==330)&& biere.style.display!="none"){
      biere.style.display = "none";
      eau.style.display = "block";
      pokemon = "coincoin";
      drinkAudio.play();
      document.removeEventListener("keydown",deplacement);
      document.addEventListener("keydown",deplacementInverse);

    }

    pikachu.style.top=posY+"px";
    pikachu.style.left=posX+"px";
    imgPikachu.setAttribute("src","assets/img/"+pokemon+direction+".png");
    if(pikachu2.style.display != "none"){


      pikachu2.style.top=posY-50+"px";
      pikachu2.style.left=posX-50+"px";

      imgPikachu2.setAttribute("src","assets/img/"+pokemon+direction+".png");
    }
  };



    function deplacementInverse(event)
    {
      if (event.key === "ArrowUp" || event.key === "s") {
        direction = "Down";
        if(posY!=660){
          posY+=30;
        }
      }
      else if (event.key === "ArrowLeft" || event.key === "d") {
        direction = "Right";
        if(posX!=660){
          posX+=30
        }
      }
      else if (event.key === "ArrowRight" || event.key === "q") {
        direction = "Left";
        if(posX!=0){
          posX-=30;
        }
      }
      else if (event.key === "ArrowDown" || event.key === "z") {
        direction = "Up";
        if(posY!=0){
          posY-=30;
        }
      }

      if((posX==60 && posY==90) && champignon.style.display!="none"){
        pikachu.style.scale ="2";
        champignon.style.display ="none";
        champiAudio.play();
      }
      if((posX==390 && posY==600)&& teleporteur.style.display!="none"){
        posX = 0;
        posY = 0;
        teleporteur.style.display = "none";
        teleportAudio.play();
      }
      if((posX==60 && posY==360)&& crown.style.display!="none"){
        pokemon = "peach";
        imgPikachu.style.width = "30px";
        imgPikachu2.style.width = "30px";
        crown.style.display = "none";
        princessAudio.play();
      }
      if((posX==240 && posY==480)&& diamond.style.display!="none"){
        pokemon = "princess";
        imgPikachu.style.width = "30px";
        imgPikachu2.style.width = "30px";
        diamond.style.display = "none";
        princessAudio2.play();
      }
      if((posX==570 && posY==240)&& clone.style.display!="none"){
        imgPikachu2.setAttribute("src","assets/img/"+pokemon+direction+".png");
        pikachu2.style.top=posY-50+"px";
        pikachu2.style.left=posX-50+"px";
        pikachu2.style.display = "block";
        clone.style.display = "none";
        cloneAudio.play();
      }
      if((posX==330 && posY==330)&& eau.style.display!="none"){
        eau.style.display = "none";
        drinkAudio.play();
        pokemon = "pikachu";
        document.removeEventListener("keydown",deplacementInverse);
        document.addEventListener("keydown",deplacement);
      }

        pikachu.style.top = posY + "px";
        pikachu.style.left = posX + "px";
        imgPikachu.setAttribute("src", "assets/img/" + pokemon + direction + ".png");
      };

    setTimeout(function(){
      themePokemon.pause();
    },50000);
