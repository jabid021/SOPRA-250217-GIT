<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion des formateurs</title>

<style>
.civilite-homme td{color:blue !important;}
.civilite-femme td{color:pink !important;}
.civilite-nb td{color:green !important;}

</style>
</head>
<body>

<div id="content">
  <h1>Liste des Formateursss</h1>
  <input id="btnAddFormateur" type="button" class ="btn btn-success" value="Ajouter">
  <a href="index.html"><input type="button" class ="btn btn-info" value="Retour"></a>

  <table class="table table-striped">
    <thead>
      <tr>
        <th>Id</th>
        <th>Login</th>
        <th>Password</th>
        <th>Nom</th>
        <th>Prenom</th>
        <th>Civilite</th>
        <th>Actions</th>
      </tr>
    </thead>
    <tbody>
    
    <c:forEach items="${formateurs}" var="formateur">
   	 <tr class="civilite-${formateur.genre}">
        <td>${formateur.id}</td>
        <td>${formateur.login}</td>
        <td>${formateur.password}</td>
        <td>${formateur.nom}</td>
        <td>${formateur.prenom}</td>
        <td>${formateur.genre}</td>
        <td>
          <a href="formateur?id=${formateur.id}"><input type="button" class ="btn btn-warning" value="Modifier"></a>
          <a href="formateur?id=${formateur.id}&delete"><input type="button" class ="btn btn-danger" value="Supprimer"></a>
        </td>
      </tr>
    
    </c:forEach>
      
    </tbody>
  </table>





  <div id="addFormFormateur" class="formAjout">
    <h3>Ajouter Formateur</h3>
    <form action="formateur" method="post">
   	  Login :<input name="login" type="text" placeholder="Saisir votre login"><br>
      Password :<input name="password" type="password" placeholder="Saisir votre password"><br>
      Nom :<input name="nom" type="text" placeholder="Saisir votre nom"><br>
      Prenom :<input name="prenom" type="text" placeholder="Saisir votre prenom"><br>
      Civilite:  
      <c:forEach items="${genres}" var="genre">
        <input type="radio" id="checkbox-genre-${genre}" name="genre" value="${genre}"> <label for="checkbox-genre-${genre}">${genre}</label>
      </c:forEach>
     <br>
      <input class ="btn btn-success" type="submit" value="Ajouter">
    </form>
  </div>

</div>


</body>
</html>


<script>

  btnAddFormateur.onclick=function()
  {
    addFormFormateur.style.display="block";
  }

</script>
