package fr.eni.encheres.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConnecterServlet
 */
@WebServlet("/accueil/login")
public class ConnecterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnecterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/connection.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		récupération des données du formulaire
		
		String userName = request.getParameter("username")!=null ?request.getParameter("username"):null ;
		String password = request.getParameter("password")!=null ? (String)request.getParameter("password"):null ;
		
		
		//		gestion de la case se souvenir par cookie : 
//		Cookie cookie = new Cookie("identite", userName);
//		if (request.getParameter("memoriser")!=null) {
//			//création du Cookie
//
//			cookie.setHttpOnly(true);
//			cookie.setMaxAge(-1); 
//			response.addCookie(cookie);
//		} else {
//			//sinon forcer la destruction du cookie côté client
//
//			cookie.setMaxAge(0);
//			response.addCookie(cookie);
//		}
		
		Cookie cookie = new Cookie("identite", userName);
		if (request.getParameter("memoriser")!=null) {
			cookie.setHttpOnly(true);
			cookie.setMaxAge(-1);
			cookie.setComment("nom utilisateur");
			response.addCookie(cookie);
		} else {
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/accueil.jsp");
		rd.forward(request, response);
		
	}

}
