<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Ordinateur</title>

</head>
<body>

<div id="content">

  <h3>Modifier Ordinateur ${ordinateur.numero}</h3>
  <form action="ordinateur" method="post">
  <input type="hidden" name="numero" value="${ordinateur.numero}">
  Marque :<input value="${ordinateur.marque}" name="marque" type="text" placeholder="Saisir votre marque"><br>
  RAM :<input value="${ordinateur.ram}" name="ram" type="number" placeholder="Saisir votre RAM"><br>
  Stagiaire
    <select name="stagiaire.id">
    	<option selected value="${ordinateur.stagiaire.id}" >${ordinateur.stagiaire.id} - ${ordinateur.stagiaire.prenom} ${ordinateur.stagiaire.nom}</option>
       <c:forEach items="${stagiaires}" var="stagiaire">
    	  <option value="${stagiaire.id}" >${stagiaire.id} - ${stagiaire.prenom} ${stagiaire.nom}</option>
      </c:forEach>
    </select><br>

    <input class ="btn btn-warning" type="submit" value="Modifier">
    <a href="ordinateur"><input type="button" class ="btn btn-info" value="Retour"></a>
  </form>
</div>

</body>
</html>