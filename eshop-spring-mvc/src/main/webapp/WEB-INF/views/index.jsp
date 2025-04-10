<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
<link rel="stylesheet"
	href="<c:url value="/css/bootstrap.min.css"/>">
<link rel="stylesheet"
	href="<c:url value="/css/bootstrap-icons.css"/>">
</head>
<body>


	<div class="container mt-3">
	  <h2>Ma page d'accueil</h2>
	  <div class="mt-4 p-5 bg-primary text-white rounded">
	    <h1>Bonjour ${prenom} ${nom} (${age} an(s))</h1> 

	  </div>
	  
	  <div class="container-fluid">
			<form action="<c:url value="/accueil"/>" method="post">
				<div class="form-group">
					<label for="nom">Nom:</label> <input type="text"
						class="form-control" id="nom" name="nom"
						value="${nom}" />
				</div>
				<div class="form-group">
					<label for="prenom">Prénom:</label> <input type="text"
						class="form-control" id="prenom" name="prenom"
						value="${prenom}" />
				</div>
				<div class="form-group">
					<label for="age">Age:</label> <input type="number"
						class="form-control" id="age" name="age"
						value="${age}" />
				</div>
					<div class="btn-group btn-group-lg float-right">
					<button type="submit" class="btn btn-success">
						<i class="bi bi-check-square-fill"></i>
					</button>
				</div>
			</form>
		</div>
	</div>
	  
	


	<script src="<c:url value="/js/bootstrap.bundle.js"/>"></script>
</body>
</html>