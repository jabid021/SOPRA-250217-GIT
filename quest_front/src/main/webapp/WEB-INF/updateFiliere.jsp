<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Update Filiere</title>
</head>
<body>


<div id="content">

  <h3>Modifier Filiere ${filiere.id}</h3>
  <form action="filiere" method="post">
  <input type="hidden" name="id" value="${filiere.id}">
  Libelle :<input value="${filiere.libelle}" name="libelle" type="text" placeholder="Saisir le libelle"><br>
  Debut :<input value="${filiere.debut}" name="debut" type="date"><br>
  Fin :<input value="${filiere.fin}" name="fin" type="date"><br>

  <input class ="btn btn-warning" type="submit" value="Modifier">
  <a href="filiere"><input type="button" class ="btn btn-info" value="Retour"></a>

  </form>

</div>

</body>
</html>

<script>
document.querySelectorAll("ul.navbar-nav li")[5].classList.add("active");
</script>