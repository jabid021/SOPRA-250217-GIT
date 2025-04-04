<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion des ordinateurs</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link rel="stylesheet" href="style.css">

</head>
<body>

<div id="content">
  <h1>Liste des Ordinateurs</h1>
  <input id="btnAddOrdi" type="button" class ="btn btn-success" value="Ajouter">
  <a href="index.html"><input type="button" class ="btn btn-info" value="Retour"></a>

  <table class="table table-striped">
    <thead>
      <tr>
        <th>Numero</th>
        <th>Marque</th>
        <th>Ram</th>
        <th>Stagiaire</th>
        <th>Actions</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${ordinateurs}" var="ordinateur">
      <tr>
        <td>${ordinateur.numero}</td>
        <td>${ordinateur.marque}</td>
        <td>${ordinateur.ram}Go</td>
        <td>${ordinateur.stagiaire.id}-${ordinateur.stagiaire.prenom} ${ordinateur.stagiaire.nom}</td>
        <td>
          <a href="ordinateur?numero=${ordinateur.numero}"><input type="button" class ="btn btn-warning" value="Modifier"></a>
          <a href="ordinateur?numero=${ordinateur.numero}&delete"><input type="button" class ="btn btn-danger" value="Supprimer"></a>
        </td>
      </tr>
	</c:forEach>
    </tbody>
  </table>





  <div id="addFormOrdi" class="formAjout">
    <h3>Ajouter Ordinateur</h3>
    <form action="ordinateur" method="post">
      Marque :<input name="marque" type="text" placeholder="Saisir votre marque"><br>
      RAM :<input name="ram" type="number" placeholder="Saisir votre RAM"><br>
      Stagiaire
      <select required name="stagiaire.id">
      <c:forEach items="${stagiaires}" var="stagiaire">
    	  <option value="${stagiaire.id}" >${stagiaire.id} - ${stagiaire.prenom} ${stagiaire.nom}</option>
      </c:forEach>
      </select><br>

      <input class ="btn btn-success" type="submit" value="Ajouter">
    </form>
  </div>

</div>

</body>
</html>

<script>

  btnAddOrdi.onclick=function()
  {
    addFormOrdi.style.display="block";
  }

</script>
