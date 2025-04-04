<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page Accueil</title>
</head>
<body>

<div id="content">
	<h1>Page Acceuil QUEST !</h1>
	<form action="home" method="post">
		
	Login : <input required type="text" name="login" placeholder="Saisir login"><br>
	Password : <input required type="password" name="password" placeholder="Saisir password"><br>
	<div style="color:red">${error}</div>
	<input type="submit" value="Se connecter">
	
	
	</form>

</div>
</body>
</html>