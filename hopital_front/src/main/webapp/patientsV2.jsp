<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ page import="java.util.*" %>
<%@ page import="hopital.model.Patient" %>
<%@ page import="hopital.context.Singleton" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Liste des patients</h1>

	<table border>
		<tr>
			<th>ID</th>
			<th>Nom</th>
			<th>Prenom</th>
			<th>Actions</th>
		</tr>
	
		<%
		
		List<Patient> patients = Singleton.getInstance().getDaoPatient().findAll();
		
		for(Patient p : patients)
		{
			
			out.println("<tr><td>"+p.getId()+"</td><td>"+p.getNom()+"</td><td>"+p.getPrenom()+"</td><td><a href='patient?id="+p.getId()+"'><input type='button' value='Voir fiche'></a><a href='patient?id="+p.getId()+"&delete'><input type='button' value='Supprimer'></a></td></tr>");
		}
		
		%>

	</table>




	<form action="patient" method="POST">
	
	<input type="hidden" name="tache" value="insert">
	
	ID : <input required name="id" type="number" placeholder="Saisir votre id"><br>
	Nom : <input required name="nom" type="text" placeholder="Saisir votre nom"><br>
	Prenom : <input required name="prenom" type="text" placeholder="Saisir votre prenom">
	<input type="submit" value="Ajouter">
	
	</form>

</body>
</html>