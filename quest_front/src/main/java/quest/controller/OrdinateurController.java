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
import quest.dao.IDAOOrdinateur;
import quest.dao.IDAOUtilisateur;
import quest.model.Ordinateur;
import quest.model.Stagiaire;

@WebServlet("/ordinateur")
public class OrdinateurController extends HttpServlet {

	public void init(ServletConfig config) throws ServletException
	 {
	 super.init(config);
	 SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	 }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		IDAOOrdinateur daoOrdinateur = ctx.getBean(IDAOOrdinateur.class);
		IDAOUtilisateur daoUtilisateur = ctx.getBean(IDAOUtilisateur.class);
		if(request.getParameter("numero")==null) 
		{
			request.setAttribute("ordinateurs", daoOrdinateur.findAll());
			request.setAttribute("stagiaires", daoUtilisateur.findAllStagiaireDisponibles());
			request.getRequestDispatcher("/WEB-INF/ordinateurs.jsp").forward(request, response);
		}
		else
		{
			Integer id = Integer.parseInt(request.getParameter("numero"));

			if(request.getParameter("delete")==null) 
			{
				request.setAttribute("ordinateur", daoOrdinateur.findById(id).get());
				request.setAttribute("stagiaires", daoUtilisateur.findAllStagiaireDisponibles());
				request.getRequestDispatcher("/WEB-INF/updateOrdinateur.jsp").forward(request, response);
			}
			else 
			{
				daoOrdinateur.deleteById(id);
				response.sendRedirect("ordinateur");
			}
		}




	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		IDAOOrdinateur daoOrdinateur = ctx.getBean(IDAOOrdinateur.class);
		IDAOUtilisateur daoUtilisateur = ctx.getBean(IDAOUtilisateur.class);

		if(request.getParameter("numero")==null) 
		{
			String marque=request.getParameter("marque");
			int ram = Integer.parseInt(request.getParameter("ram"));
			Integer idStagiaire = Integer.parseInt(request.getParameter("stagiaire.id"));
			Stagiaire stagiaire = (Stagiaire) daoUtilisateur.findById(idStagiaire).get();
			
			Ordinateur ordinateur = new Ordinateur(marque,ram,stagiaire);
			
			daoOrdinateur.save(ordinateur);
			response.sendRedirect("ordinateur");
		}
		else 
		{
			Integer id = Integer.parseInt(request.getParameter("numero"));
			String marque=request.getParameter("marque");
			int ram = Integer.parseInt(request.getParameter("ram"));
			Integer idStagiaire = Integer.parseInt(request.getParameter("stagiaire.id"));
			Stagiaire stagiaire = (Stagiaire) daoUtilisateur.findById(idStagiaire).get();
			
			Ordinateur ordinateur = new Ordinateur(id,marque,ram,stagiaire);
	
			daoOrdinateur.save(ordinateur);
			response.sendRedirect("ordinateur");
		}
	}

}
