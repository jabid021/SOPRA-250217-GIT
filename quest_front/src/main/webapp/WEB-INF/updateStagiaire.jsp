<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Stagiaire</title>

</head>
<body>


<div id="content">

  <h3>Modifier Stagiaire ${stagiaire.id}</h3>
  <form action="stagiaire" method="post">
  <input type="hidden" name="id" value="${stagiaire.id}">
  Login :<input value="${stagiaire.login}" name="login" type="text" placeholder="Saisir votre login"><br>
  Password :<input value="${stagiaire.password}" name="password" type="password" placeholder="Saisir votre password"><br>
  Nom :<input value="${stagiaire.nom}" name="nom" type="text" placeholder="Saisir votre nom"><br>
  Prenom :<input value="${stagiaire.prenom}" name="prenom" type="text" placeholder="Saisir votre prenm"><br>
  Civilite:<c:forEach items="${genres}" var="genre">
 	<c:choose>
 		<c:when test="${genre==stagiaire.genre}">
 			<input type="radio" checked id="checkbox-genre-${genre}" name="genre" value="${genre}"> <label for="checkbox-genre-${genre}">${genre}</label>
 		</c:when>
 		<c:otherwise>
 			<input type="radio" id="checkbox-genre-${genre}" name="genre" value="${genre}"> <label for="checkbox-genre-${genre}">${genre}</label>
 		</c:otherwise>
 	</c:choose>
        
</c:forEach>
  <br>
  Email :<input value="${stagiaire.email}" name="email" type="email" placeholder="Saisir votre email"><br>
  Adresse : 
  <input value="${stagiaire.adresse.numero}" type="text" name="adresse.numero" placeholder="Saisir le numero">
  <input value="${stagiaire.adresse.voie}" type="text" name="adresse.voie" placeholder="Saisir la voie">
  <input value="${stagiaire.adresse.ville}" type="text" name="adresse.ville" placeholder="Saisir la ville">
  <input value="${stagiaire.adresse.cp}" type="text" name="adresse.cp" placeholder="Saisir le cp"><br>
  Filiere
    <select name="filiere.id">
       <c:forEach items="${filieres}" var="filiere">
     	 <option <c:if test="${filiere.id==stagiaire.filiere.id}">selected</c:if> value="${filiere.id}" >${filiere.id} - ${filiere.libelle}</option>
      </c:forEach>
    </select><br>

    <input class ="btn btn-warning" type="submit" value="Modifier">
    <a href="stagiaire"><input type="button" class ="btn btn-info" value="Retour"></a>
  </form>
</div>
</body>
</html>
<script>
document.querySelectorAll("ul.navbar-nav li")[2].classList.add("active");

</script>