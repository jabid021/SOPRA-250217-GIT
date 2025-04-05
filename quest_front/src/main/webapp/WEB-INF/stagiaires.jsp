<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion des Stagiaire</title>

</head>
<body>


<div id="content">
  <h1>Liste des Stagiaires</h1>
  <input id="btnAddStagiaire" type="button" class ="btn btn-success" value="Ajouter">
  <a href="home"><input type="button" class ="btn btn-info" value="Retour"></a>

  <table class="table table-striped">
    <thead>
      <tr>
        <th>Id</th>
        <th>Login</th>
        <th>Password</th>
        <th>Nom</th>
        <th>Prenom</th>
        <th>Civilite</th>
        <th>Email</th>
        <th>Adresse</th>
        <th>Filiere</th>
        <th>Actions</th>
      </tr>
    </thead>
    <tbody>
    
    <c:forEach items="${stagiaires}" var="stagiaire">
    <tr>
        <td>${stagiaire.id}</td>
        <td>${stagiaire.login}</td>
        <td>${stagiaire.password}</td>
        <td>${stagiaire.nom}</td>
        <td>${stagiaire.prenom}</td>
        <td>${stagiaire.genre}</td>
        <td>${stagiaire.email}</td>
        <td>${stagiaire.adresse.numero} ${stagiaire.adresse.voie}, ${stagiaire.adresse.ville} ${stagiaire.adresse.cp}</td>
        <td>${stagiaire.filiere.id} - ${stagiaire.filiere.libelle}</td>
        <td>
          <a href="stagiaire?id=${stagiaire.id}"><input type="button" class ="btn btn-warning" value="Modifier"></a>
          <a href="stagiaire?id=${stagiaire.id}&delete"><input type="button" class ="btn btn-danger" value="Supprimer"></a>
        </td>
      </tr>
    </c:forEach>

    </tbody>
  </table>

  <div id="addFormStagiaire" class="formAjout">
    <h3>Ajouter Stagiaire</h3>
    <form action="stagiaire" method="post">
   	  Login :<input name="login" type="text" placeholder="Saisir votre login"><br>
      Password :<input name="password" type="password" placeholder="Saisir votre password"><br>
      Nom :<input name="nom" type="text" placeholder="Saisir votre nom"><br>
      Prenom :<input name="prenom" type="text" placeholder="Saisir votre prenom"><br>
       Civilite:  
      <c:forEach items="${genres}" var="genre">
        <input type="radio" id="checkbox-genre-${genre}" name="genre" value="${genre}"> <label for="checkbox-genre-${genre}">${genre}</label>
      </c:forEach>
     <br>
      Email :<input name="email" type="email" placeholder="Saisir votre email"><br>
      Adresse : <input type="text" name="adresse.numero" placeholder="Saisir le numero"><input type="text" name="adresse.voie" placeholder="Saisir la voie"><input type="text" name="adresse.ville" placeholder="Saisir la ville"><input type="text" name="adresse.cp" placeholder="Saisir le cp"><br>
      Filiere
      <select name="filiere.id">
      <c:forEach items="${filieres}" var="filiere">
     	 <option value="${filiere.id}" >${filiere.id} - ${filiere.libelle}</option>
      </c:forEach>
        
      </select><br>
      <input class ="btn btn-success" type="submit" value="Ajouter">
    </form>
  </div>

</div>

</body>
</html>



<script>

  btnAddStagiaire.onclick=function()
  {
    addFormStagiaire.style.display="block";
  }
  document.querySelectorAll("ul.navbar-nav li")[2].classList.add("active");
</script>