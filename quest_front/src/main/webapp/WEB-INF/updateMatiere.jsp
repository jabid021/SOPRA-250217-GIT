<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Matiere</title>


</head>
<body>

<div id="content">

  <h3>Modifier Matiere ${matiere.id}</h3>
  <form action="matiere" method="post">
  <input type="hidden" name="id" value="${matiere.id}">
  Libelle :<input value="${matiere.libelle}" name="libelle" type="text" placeholder="Saisir le libelle"><br>


    <input class ="btn btn-warning" type="submit" value="Modifier">
    <a href="matiere"><input type="button" class ="btn btn-info" value="Retour"></a>
  </form>
</div>
</body>
</html>

<script>
document.querySelectorAll("ul.navbar-nav li")[4].classList.add("active");
</script>