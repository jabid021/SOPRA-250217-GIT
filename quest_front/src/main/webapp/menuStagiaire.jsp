<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <c:if test="${connected.getClass().getSimpleName()!='Stagiaire'}"> 
 	<c:redirect url="/home"/>  
 </c:if>


<div id="content">
	<h1 align="center">Tableau de bord :</h1>

	<p>Pages Stagiaire en construction</p>
</div>

<script>
	document.querySelectorAll("ul.navbar-nav li")[0].classList.add("active");
</script>