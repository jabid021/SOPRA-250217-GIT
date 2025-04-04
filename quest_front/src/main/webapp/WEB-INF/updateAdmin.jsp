<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Admin</title>

</head>
<body>
<div id="content">

  <h3>Modifier Admin ${admin.id}</h3>
  <form action="admin" method="post">
  <input type="hidden" name="id" value="${admin.id}">
  Login :<input value="${admin.login}" name="login" type="text" placeholder="Saisir votre login"><br>
  Password :<input value="${admin.password}" name="password" type="password" placeholder="Saisir votre password"><br>

    <input class ="btn btn-warning" type="submit" value="Modifier">
    <a href="admin"><input type="button" class ="btn btn-info" value="Retour"></a>
  </form>
</div>

</body>
</html>