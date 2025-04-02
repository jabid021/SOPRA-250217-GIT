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

// JEU POKE DOLLAR
var score = 0;
var dollarInterval;
var dollar = document.createElement("div");

imgPikachu.setAttribute("src","assets/img/"+pokemon+direction+".png");

document.getElementById("inputName").addEventListener("keypress", function(event){
  if(event.key === "Enter" && !document.getElementById("btnStart").disabled){
    document.getElementById("btnStart").click();
  }
})

document.getElementById("inputName").addEventListener("input",function(){
  document.getElementById("btnStart").disabled = this.value.trim() === "";
});

document.getElementById("btnStart").addEventListener("click", function(){
  var inputName = document.getElementById("inputName").value.trim();
  if(inputName !== ""){
    document.getElementById("formStart").style.display = "none";
    document.getElementById("grass").style.display = "block";
    document.getElementById("pikachu").title = inputName.toLowerCase();
      document.getElementById("themePokemon").controls = true;
  }
});

document.addEventListener("keydown",deplacement);

function deplacement(event)
{
  if(event.key=="ArrowDown" || event.key=="s" )
  {
    if(posY + mouvement <= grass.clientHeight - mouvement ){
      posY += mouvement;
    }
      direction = "Down";
  }
  else if(event.key=="ArrowRight" || event.key=="d" )
  {
    if(posX + mouvement <= grass.clientWidth - mouvement ){
      posX += mouvement;
    }
    direction = "Right";
  }
  else if(event.key=="ArrowLeft" || event.key=="q")
  {
    if(posX - mouvement >= 0){
      posX -= mouvement;
    }
    direction = "Left";
  }
  else if(event.key=="ArrowUp" || event.key=="z")
  {
    if(posY - mouvement >= 0 ){
      posY -= mouvement;
    }
    direction = "Up";
  }
  pikachu.style.top=posY+"px";
  pikachu.style.left=posX+"px";
  imgPikachu.setAttribute("src","assets/img/"+pokemon+direction+".png");

  checkCollision();
}

function spawnDollar(){
  var grass = document.getElementById("grass");

  var maxX = grass.clientWidth - mouvement;
  var maxY = grass.clientHeight - mouvement ;

  var randX = Math.floor(Math.random()  * maxX / 30) * mouvement;
  var randY = Math.floor(Math.random() * maxY / 30) * mouvement;

  dollar.style.width  = "44px";
  dollar.style.height = "46px";
  dollar.style.backgroundImage = "url('assets/img/pokedollar.png')";
  dollar.style.backgroundSize = "cover";
  dollar.style.position = "absolute";
  dollar.style.left = randX + "px";
  dollar.style.top = randY +"px";
  dollar.style.display = "block";
  if(!grass.contains(dollar)){
    grass.appendChild(dollar);
  }
}

function checkCollision(){
  if(posX === parseInt(dollar.style.left) && posY === parseInt(dollar.style.top)){
    score++;
    document.getElementById("score").textContent = "Score: " + score;
    dollar.style.display = "none";
    dollar.style.left = "-1";
    dollar.style.top = "-1";
  }

  if(score === 5){
    window.alert("GG WP !");
    location.reload();
  }
}
dollarInterval = setInterval(spawnDollar, 6000);
