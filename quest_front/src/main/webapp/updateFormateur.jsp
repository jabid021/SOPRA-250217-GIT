<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Formateur</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link rel="stylesheet" href="style.css">

</head>
<body>

<div id="content">

  <h3>Modifier Formateur ${formateur.id}</h3>
  <form action="formateur" method="post">
  <input type="hidden" name="id" value="${formateur.id}">
  Login :<input value="${formateur.login}" name="login" type="text" placeholder="Saisir votre login"><br>
  Password :<input value="${formateur.password}" name="password" type="password" placeholder="Saisir votre password"><br>
  Nom :<input value="${formateur.nom}" name="nom" type="text" placeholder="Saisir votre nom"><br>
  Prenom :<input value="${formateur.prenom}" name="prenom" type="text" placeholder="Saisir votre prenom"><br>
  
  Civilite: 
   <!--<c:forEach items="${genres}" var="genre">
        <input <c:if test="${genre==formateur.genre}">checked</c:if> type="radio" id="checkbox-genre-${genre}" name="genre" value="${genre}"> <label for="checkbox-genre-${genre}">${genre}</label>
      </c:forEach>
    -->
    
 <c:forEach items="${genres}" var="genre">
 	<c:choose>
 		<c:when test="${genre==formateur.genre}">
 			<input type="radio" checked id="checkbox-genre-${genre}" name="genre" value="${genre}"> <label for="checkbox-genre-${genre}">${genre}</label>
 		</c:when>
 		<c:otherwise>
 			<input type="radio" id="checkbox-genre-${genre}" name="genre" value="${genre}"> <label for="checkbox-genre-${genre}">${genre}</label>
 		</c:otherwise>
 	</c:choose>
        
</c:forEach>
  <br>
    <input class ="btn btn-warning" type="submit" value="Modifier">
    <a href="formateur"><input type="button" class ="btn btn-info" value="Retour"></a>
  </form>
</div>

</body>
</html>