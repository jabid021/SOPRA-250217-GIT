package quest.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quest.context.Singleton;
import quest.model.Admin;
import quest.model.Genre;

@WebServlet("/admin")
public class AdminController extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("id")==null) 
		{
			request.setAttribute("admins", Singleton.getInstance().getDaoUtilisateur().findAllAdmin());
			request.getRequestDispatcher("/WEB-INF/admins.jsp").forward(request, response);
		}
		else
		{
			Integer id = Integer.parseInt(request.getParameter("id"));

			if(request.getParameter("delete")==null) 
			{
				request.setAttribute("admin", Singleton.getInstance().getDaoUtilisateur().findById(id));
				request.getRequestDispatcher("/WEB-INF/updateAdmin.jsp").forward(request, response);
			}
			else 
			{
				Singleton.getInstance().getDaoUtilisateur().delete(id);
				response.sendRedirect("admin");
			}
		}




	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id")==null) 
		{
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			
			Admin admin = new Admin(login,password);
			Singleton.getInstance().getDaoUtilisateur().save(admin);
		
			response.sendRedirect("admin");
		}
		else 
		{
			Integer id = Integer.parseInt(request.getParameter("id"));
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			
			Admin admin = new Admin(id,login,password);
			Singleton.getInstance().getDaoUtilisateur().save(admin);
		
			response.sendRedirect("admin");
		}
	}

}
