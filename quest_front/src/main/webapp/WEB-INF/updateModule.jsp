<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Module</title>

</head>
<body>

<div id="content">

  <h3>Modifier Module ${module.id} de la Filiere ${module.filiere.libelle}</h3>
  <form action="module" method="post">
   <input type="hidden" name="filiere.id" value="${module.filiere.id}">
   <input type="hidden" name="id" value="${module.id}">
      Duree :<input value="${module.duree}" name="duree" type="number" placeholder="Saisir la duree en jour"><br>
      Code Quest :<input value="${module.quest}" name="quest" type="number" placeholder="Saisir le code quest xxxx"><br>
      Matiere
      <select name="matiere.id">
      <c:forEach items="${matieres}" var="matiere">
    	  <option <c:if test="${matiere.id==module.matiere.id}">selected</c:if>  value="${matiere.id}" >${matiere.id} - ${matiere.libelle}</option>
      </c:forEach>
      </select><br>

      <input class ="btn btn-warning" type="submit" value="Modifier">
       <a href="module?filiere=${module.filiere.id}"><input type="button" class ="btn btn-info" value="Retour filiere ${module.filiere.id}"></a>
    </form>
</div>

</body>
</html>

<script>
document.querySelectorAll("ul.navbar-nav li")[5].classList.add("active");
</script>