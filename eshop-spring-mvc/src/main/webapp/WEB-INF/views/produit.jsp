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
	  <h2>Détail du produit</h2>
	  <div class="mt-4 p-5 bg-primary text-white rounded">
	    <h1>Id: ${id} 
	    	Libellé : ${libelle} 
	    	Prix : ${prix}</h1> 

	  </div>
	  
	  <div class="container-fluid">
			<form action="<c:url value="/produit"/>" method="post">
				<div class="form-group">
					<label for="id">Identifiant:</label> <input type="number"
						class="form-control" id="id" name="id"
						value="${id}" />
				</div>
				<div class="form-group">
					<label for="libelle">Libellé:</label> <input type="text"
						class="form-control" id="libelle" name="libelle"
						value="${libelle}" />
				</div>
				<div class="form-group">
					<label for="prix">Prix:</label> <input type="number" 
						class="form-control" id="prix" name="prix" step="0.01"
						value="${prix}" />
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