<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des produits</title>
<link rel="stylesheet"
	href="<c:url value="/css/bootstrap.min.css"/>">
<link rel="stylesheet"
	href="<c:url value="/css/bootstrap-icons.css"/>">
</head>
<body>


	<div class="container-fluid">
		<div class="card mt-3">
			<div class="card-header bg-primary text-white display-6">Liste des produits</div>
			<div class="card-body">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Identifiant</th>
							<th>Libellé</th>
							<th>Prix</th>
							<th></th>
						</tr>
					</thead>

					<tbody>					
						<tr>
							<td>5</td>
							<td>IPhone 13</td>
							<td>325.50</td>
							<td><div class="btn-group btn-group-sm">
									<a class="btn btn-primary"><i class="bi bi-pencil-square"></i></a> 
									<a class="btn btn-danger"><i class="bi bi-trash"></i></a>
								</div></td>
						</tr>
					</tbody>

				</table>
			</div>
			<div class="card-footer">
				<a class="btn btn-success btn-lg"><i
					class="bi bi-plus-square"></i></a>
			</div>
		</div>
	</div>
	  
	


	<script src="<c:url value="/js/bootstrap.bundle.js"/>"></script>
</body>
</html>