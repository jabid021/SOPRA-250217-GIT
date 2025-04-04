<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="/mesIncludes.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion des admins</title>

</head>
<body>
<div id="content">
  <h1>Liste des Admins</h1>
  <input id="btnAddAdmin" type="button" class ="btn btn-success" value="Ajouter">
  <a href="index.html"><input type="button" class ="btn btn-info" value="Retour"></a>

  <table class="table table-striped">
    <thead>
      <tr>
        <th>Id</th>
        <th>Login</th>
        <th>Password</th>
        <th>Actions</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${admins}" var="admin">
    	<tr>
	        <td>${admin.id}</td>
	        <td>${admin.login}</td>
	        <td>${admin.password}</td>
	        <td>
	          <a href="admin?id=${admin.id}"><input type="button" class ="btn btn-warning" value="Modifier"></a>
	          <a href="admin?id=${admin.id}&delete"><input type="button" class ="btn btn-danger" value="Supprimer"></a>
	        </td>
      </tr>
    </c:forEach>
     
    </tbody>
  </table>





  <div id="addFormAdmin" class="formAjout">
    <h3>Ajouter Admin</h3>
    <form action="admin" method="post">
   	  Login :<input name="login" type="text" placeholder="Saisir votre login"><br>
      Password :<input name="password" type="password" placeholder="Saisir votre password"><br>
      <input class ="btn btn-success" type="submit" value="Ajouter">
    </form>
  </div>

</div>
</body>
</html>


<script>

  btnAddAdmin.onclick=function()
  {
    addFormAdmin.style.display="block";
  }

</script>
