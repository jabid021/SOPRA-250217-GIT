package quest.controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import quest.config.AppConfig;
import quest.dao.IDAOUtilisateur;
import quest.model.Admin;
import quest.model.Utilisateur;

@WebServlet("/admin")
public class AdminController extends HttpServlet {

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		IDAOUtilisateur daoUtilisateur = ctx.getBean(IDAOUtilisateur.class);

		if(request.getParameter("id")==null) 
		{
			request.setAttribute("admins", daoUtilisateur.findAllAdmin());
			request.getRequestDispatcher("/WEB-INF/admins.jsp").forward(request, response);
		}
		else
		{
			Integer id = Integer.parseInt(request.getParameter("id"));

			if(request.getParameter("delete")==null) 
			{
				Optional<Utilisateur>opt= daoUtilisateur.findById(id);
				if(!opt.isEmpty()) 
				{
					request.setAttribute("admin", opt.get());
					request.getRequestDispatcher("/WEB-INF/updateAdmin.jsp").forward(request, response);
				}
			}
			else 
			{
				daoUtilisateur.deleteById(id);
				response.sendRedirect("admin");
			}
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		IDAOUtilisateur daoUtilisateur = ctx.getBean(IDAOUtilisateur.class);

		if(request.getParameter("id")==null) 
		{
			String login = request.getParameter("login");
			String password = request.getParameter("password");

			Admin admin = new Admin(login,password);
			daoUtilisateur.save(admin);

			response.sendRedirect("admin");
		}
		else 
		{
			Integer id = Integer.parseInt(request.getParameter("id"));
			String login = request.getParameter("login");
			String password = request.getParameter("password");

			Admin admin = new Admin(id,login,password);
			daoUtilisateur.save(admin);

			response.sendRedirect("admin");
		}
	}

}
