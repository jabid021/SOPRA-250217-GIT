package quest.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import quest.config.AppConfig;
import quest.dao.IDAOFiliere;
import quest.dao.IDAOUtilisateur;
import quest.model.Filiere;
import quest.model.Genre;
import quest.model.Stagiaire;

@WebServlet("/stagiaire")
public class StagiaireController extends HttpServlet {

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		IDAOUtilisateur daoUtilisateur = ctx.getBean(IDAOUtilisateur.class);
		IDAOFiliere daoFiliere = ctx.getBean(IDAOFiliere.class);
		if(request.getParameter("id")==null) 
		{
			request.setAttribute("stagiaires", daoUtilisateur.findAllStagiaire());
			request.setAttribute("filieres", daoFiliere.findAll());
			request.setAttribute("genres", Genre.values());
			request.getRequestDispatcher("/WEB-INF/stagiaires.jsp").forward(request, response);
		}
		else
		{
			Integer id = Integer.parseInt(request.getParameter("id"));

			if(request.getParameter("delete")==null) 
			{
				request.setAttribute("stagiaire", daoUtilisateur.findById(id).get());
				request.setAttribute("filieres",daoFiliere.findAll());
				request.setAttribute("genres", Genre.values());
				request.getRequestDispatcher("/WEB-INF/updateStagiaire.jsp").forward(request, response);
			}
			else 
			{
				daoUtilisateur.deleteById(id);
				response.sendRedirect("stagiaire");
			}
		}




	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		IDAOUtilisateur daoUtilisateur = ctx.getBean(IDAOUtilisateur.class);
		IDAOFiliere daoFiliere = ctx.getBean(IDAOFiliere.class);
		if(request.getParameter("id")==null) 
		{
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			Genre civilite = Genre.valueOf(request.getParameter("genre"));
			String email = request.getParameter("email");
			String numero = request.getParameter("adresse.numero");
			String voie = request.getParameter("adresse.voie");
			String ville = request.getParameter("adresse.ville");
			String cp = request.getParameter("adresse.cp");
			Integer idFiliere = Integer.parseInt(request.getParameter("filiere.id"));
			Filiere filiere = daoFiliere.findById(idFiliere).get();
			Stagiaire stagiaire = new Stagiaire(login, password, nom, prenom, civilite, email, numero, voie, ville, cp, filiere);
			daoUtilisateur.save(stagiaire);

			response.sendRedirect("stagiaire");
		}
		else 
		{
			Integer id = Integer.parseInt(request.getParameter("id"));
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			Genre civilite = Genre.valueOf(request.getParameter("genre"));
			String email = request.getParameter("email");
			String numero = request.getParameter("adresse.numero");
			String voie = request.getParameter("adresse.voie");
			String ville = request.getParameter("adresse.ville");
			String cp = request.getParameter("adresse.cp");
			Integer idFiliere = Integer.parseInt(request.getParameter("filiere.id"));
			Filiere filiere = daoFiliere.findById(idFiliere).get();
			Stagiaire stagiaire = new Stagiaire(id,login, password, nom, prenom, civilite, email, numero, voie, ville, cp, filiere);
			daoUtilisateur.save(stagiaire);

			response.sendRedirect("stagiaire");
		}
	}

}
