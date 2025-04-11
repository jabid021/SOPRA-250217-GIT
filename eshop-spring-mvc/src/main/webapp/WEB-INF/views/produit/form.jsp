<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edition d'un produit</title>
<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
<link rel="stylesheet" href="<c:url value="/css/bootstrap-icons.css"/>">
</head>
<body>

	<div class="container">
		<div class="card mt-3">
			<form action="<c:url value="/produit/save"/>" method="post">
				<div class="card-header bg-primary text-white display-6">Edition
					d'un produit</div>
				<div class="card-body">
					<div class="form-group">
						<label for="id">Identifiant:</label> <input type="number"
							class="form-control" id="id" name="id" value="${produit.id}" readonly />
					</div>
					<div class="form-group">
						<label for="libelle">Libellé:</label> <input type="text"
							class="form-control" id="libelle" name="libelle"
							value="${produit.libelle}" />
					</div>
					<div class="form-group">
						<label for="prix">Prix:</label> <input type="number"
							class="form-control" id="prix" name="prix" step="0.01"
							value="${produit.prix}" />
					</div>
				</div>
				<div class="card-footer">
					<div class="btn-group btn-group-lg float-right">
						<button type="submit" class="btn btn-success">
							<i class="bi bi-check-square-fill"></i>
						</button>
						<c:url value="/produit/cancel" var="cancelUrl" />

						<a class="btn btn-warning" href="${cancelUrl}"><i
							class="bi bi-backspace-fill"></i></a>
					</div>
				</div>
			</form>
		</div>
	</div>

	<script src="<c:url value="/js/bootstrap.bundle.js"/>"></script>
</body>
</html>