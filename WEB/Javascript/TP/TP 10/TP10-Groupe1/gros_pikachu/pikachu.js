//1) saisir le nom du pokemon et valider avec le bouton (le nom ne doit pas etre vide !)
//2) Masquer la div formStart, Afficher la div grass, mettre le nom du pokemon en title sur la div pikachu
//3) Gerer les deplacements, pouvoir bouger dans toutes les directions (haut,bas,gauche,droite) => les fleches et / ou zqsd
//4) Modifier la position de la div pikachu en fonction de la direction (+-30px par deplacement) et changer l'image
//5) Verifier que pikachu ne sort pas de la div grass

var pikachuSize=30;
var score=0;
var posX=0;
var posY=0;
var mouvement=30;
var pokemon="pikachu";
var direction="Down";
var imgPikachu = document.getElementById("imgPikachu");
var pikachu = document.getElementById("pikachu");
var inputName = document.getElementById("inputName");
var btnStart = document.getElementById("btnStart");
var formStart = document.getElementById("formStart");
var grass = document.getElementById("grass");

imgPikachu.setAttribute("src","assets/img/"+pokemon+direction+".png");

inputName.addEventListener("input", function() {
  btnStart.disabled = inputName.value.trim() === "";
});

btnStart.addEventListener("click", startGame);

function startGame() {
  document.getElementById('Name').textContent = `Votre pseudo est : ${inputName.value}`;
  document.getElementById('score').textContent = `Votre score est de 0 / 100 points !`;
  formStart.style.display = "none";
  grass.style.display = "block";
  grass.setAttribute("title", inputName.value);
  direction = "Down";
  posX = 0;
  posY = 0;
  pikachu.style.top = posY + "px";
  pikachu.style.left = posX + "px";
  imgPikachu.setAttribute("src", "assets/img/" + pokemon + direction + ".png");

  document.addEventListener("keydown", deplacement);

  // Spawn items
  spawnItem("assets/img/mepo.png");
  spawnItem("assets/img/tamato.png");
}


function deplacement(event) {
  var newPosX = posX;
  var newPosY = posY;

  if (event.key == "ArrowDown" || event.key == "s") {
    direction = "Down";
    if (posY + mouvement <= grass.clientHeight - pikachu.clientHeight) {
      newPosY += mouvement;
    }
  } else if (event.key == "ArrowRight" || event.key == "d") {
    direction = "Right";
    if (posX + mouvement <= grass.clientWidth - pikachu.clientWidth) {
      newPosX += mouvement;
    }
  } else if (event.key == "ArrowLeft" || event.key == "q") {
    direction = "Left";
    if (posX - mouvement >= 0) {
      newPosX -= mouvement;
    }
  } else if (event.key == "ArrowUp" || event.key == "z") {
    direction = "Up";
    if (posY - mouvement >= 0) {
      newPosY -= mouvement;
    }
  }

  posX = newPosX;
  posY = newPosY;
  pikachu.style.top = posY + "px";
  pikachu.style.left = posX + "px";
  imgPikachu.setAttribute("src", "assets/img/" + pokemon + direction + ".png");

  checkCollisions();
}

function spawnItem(imageSrc) {
  var item = document.createElement("div");
  item.className = "item";

  var img = document.createElement("img");
  img.src = imageSrc;
  img.style.width = "100%";
  img.style.height = "100%";
  item.appendChild(img);

  item.style.top = Math.floor(Math.random() * (grass.clientHeight - 30)) + "px";
  item.style.left = Math.floor(Math.random() * (grass.clientWidth - 30)) + "px";

  item.style.zIndex = 10;
  item.style.position = "absolute";

  grass.appendChild(item);
}

function checkCollisions() {
  var items = document.querySelectorAll(".item");
  items.forEach(function(item) {
    var itemRect = item.getBoundingClientRect();
    var pikachuRect = pikachu.getBoundingClientRect();

    if (rectsOverlap(itemRect, pikachuRect)) {
      item.remove();
      pikachuSize += 15;

      imgPikachu.style.width = pikachuSize + "px";
      imgPikachu.style.height = pikachuSize + "px";
      score+=10;
      document.getElementById('score').textContent = `Votre score est de ${score} / 100 points !`;
      
      if (score < 100) {
        spawnItem("assets/img/mepo.png");
      } else {
        endGame();
      }
    }
  });
}

function rectsOverlap(rect1, rect2) {
  return !(
    rect1.right < rect2.left ||
    rect1.left > rect2.right ||
    rect1.bottom < rect2.top ||
    rect1.top > rect2.bottom
  );
}

function endGame() {
  var items = document.querySelectorAll(".item");

  items.forEach(function(item) {
    item.remove();
  });
  alert("Félicitations ! Vous avez gagné avec un score de 100 points !");
  document.removeEventListener("keydown", deplacement);
}