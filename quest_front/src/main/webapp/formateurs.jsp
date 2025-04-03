<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion des formateurs</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link rel="stylesheet" href="style.css">

</head>
<body>

${formateurs}
<div id="content">
  <h1>Liste des Formateurs</h1>
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
      <tr>
        <td>1</td>
        <td>log</td>
        <td>pass</td>
        <td>Abid</td>
        <td>Jordan</td>
        <td>homme</td>
        <td>
          <a href="formateur?id=1"><input type="button" class ="btn btn-warning" value="Modifier"></a>
          <a href="formateur?id=1&delete"><input type="button" class ="btn btn-danger" value="Supprimer"></a>
        </td>
      </tr>
    </tbody>
  </table>





  <div id="addFormFormateur" class="formAjout">
    <h3>Ajouter Formateur</h3>
    <form action="formateur" method="post">
   	  Login :<input name="login" type="text" placeholder="Saisir votre login"><br>
      Password :<input name="password" type="password" placeholder="Saisir votre password"><br>
      Nom :<input name="nom" type="text" placeholder="Saisir votre nom"><br>
      Prenom :<input name="prenom" type="text" placeholder="Saisir votre prenom"><br>
      Civilite:  <input type="radio" id="checkbox-genre-homme" name="genre" value="homme" checked> <label for="checkbox-genre-homme">homme</label><input type="radio" id="checkbox-genre-femme" name="genre" value="femme"> <label for="checkbox-genre-femme">femme</label><input type="radio" id="checkbox-genre-nb" name="genre" value="nb"> <label for="checkbox-genre-nb">nb</label><br>
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
