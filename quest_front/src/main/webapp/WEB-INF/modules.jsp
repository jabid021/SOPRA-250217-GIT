<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion des modules</title>


</head>
<body>

<div id="content">
  <h1>Liste des Modules de la Filiere ${filiere.libelle}</h1>
  <input id="btnAddModule" type="button" class ="btn btn-success" value="Ajouter">
  <a href="filiere"><input type="button" class ="btn btn-info" value="Retour"></a>

  <table class="table table-striped">
    <thead>
      <tr>
        <th>ID</th>
        <th>Matiere</th>
        <th>Duree</th>
        <th>Code Quest</th>
        <th>Actions</th>
      </tr>
    </thead>
    <tbody>
    
    <c:if test="${filiere.modules.isEmpty()}">
    	<tr><td align="center" colspan="5">AUCUN MODULE DANS CETTE FILIERE</td></tr>
    </c:if>
    <c:forEach items="${filiere.modules}" var="module">
      <tr>
        <td>${module.id}</td>
        <td>${module.matiere.libelle}</td>
        <td>${module.duree}</td>
        <td>${module.quest}</td>
        <td>
          <a href="module?id=${module.id}"><input type="button" class ="btn btn-warning" value="Modifier"></a>
          <a href="module?id=${module.id}&filiere=${filiere.id}&delete"><input type="button" class ="btn btn-danger" value="Supprimer"></a>
        </td>
      </tr>
	</c:forEach>
    </tbody>
  </table>





  <div id="addFormModule" class="formAjout">
    <h3>Ajouter Module</h3>
    <form action="module" method="post">
    <input type="hidden" name="filiere.id" value="${filiere.id}">
      Duree :<input name="duree" type="number" placeholder="Saisir la duree en jour"><br>
      Code Quest :<input name="quest" type="number" placeholder="Saisir le code quest xxxx"><br>
      Matiere
      <select name="matiere.id">
      <c:forEach items="${matieres}" var="matiere">
    	  <option value="${matiere.id}" >${matiere.id} - ${matiere.libelle}</option>
      </c:forEach>
      </select><br>

      <input class ="btn btn-success" type="submit" value="Ajouter">
    </form>
  </div>

</div>

</body>
</html>

<script>

  btnAddModule.onclick=function()
  {
    addFormModule.style.display="block";
  }

</script>
