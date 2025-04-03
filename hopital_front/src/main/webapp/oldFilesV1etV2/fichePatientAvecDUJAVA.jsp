<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="hopital.model.Patient"%>
<%@ page import="hopital.context.Singleton"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%="<title>Ficheee du patient "+request.getParameter("id")+"</title>" %>
</head>
<body>

<%

Integer id = Integer.parseInt(request.getParameter("id"));

out.println("<h1>Fiche du patient "+id+"</h1>");

Patient p = Singleton.getInstance().getDaoPatient().findById(id);


out.println(p);


%>




</body>
</html>