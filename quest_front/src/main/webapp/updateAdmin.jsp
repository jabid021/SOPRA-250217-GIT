<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Admin</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link rel="stylesheet" href="style.css">
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