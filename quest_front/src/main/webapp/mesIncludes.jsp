<!--<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous"> -->


<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<link rel="stylesheet" href="style.css">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

  
<nav id="navbar" class="navbar navbar-expand-lg navbar-dark bg-info fixed-top">
	<a class="navbar-brand" href="home">Quest</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNav" aria-controls="navbarNav"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNav">
		<c:if test="${connected!=null}">
			<ul class="navbar-nav ml-auto">
		
		<c:choose>
			<c:when test="${connected.getClass().getSimpleName()=='Admin'}">
					<li class="nav-item"><a class="nav-link" href="home">Bonjour ${connected.login}</a></li>
					<li class="nav-item"><a class="nav-link" href="home">Accueil</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="stagiaire">Stagiaires</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="formateur">Formateurs</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="matiere">Matières</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="filiere">Filieres</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="ordinateur">Ordinateurs</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="home?deconnecter">Se deconnecter</a>
					</li>
			</c:when>
			<c:otherwise>
				<li class="nav-item active"><a class="nav-link" href="home">Bonjour ${connected.prenom} ${connected.nom}</a></li>
				<li class="nav-item"><a class="nav-link" href="home?deconnecter">Se deconnecter</a>
					</li>
			</c:otherwise>
		</c:choose>	
		
			
				
			</ul>
			</c:if>
	</div>
</nav>
  
  
<!--
Permet de fixer le debut des tous les url "src"/ "href" sur notre site
<base href="/quest_front/">
  -->
  

<base href="${pageContext.request.contextPath}/">

