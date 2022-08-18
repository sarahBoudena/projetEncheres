package fr.eni.encheres.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bll.utilisateurManager;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class ConnecterServlet
 */
@WebServlet("/enchere/login")
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
		RequestDispatcher rd;
		rd =request.getRequestDispatcher("/WEB-INF/jsp/connection.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		r�cup�ration des donn�es du formulaire
		
		String email = request.getParameter("email")!=null ?request.getParameter("email"):null ;
		String password = request.getParameter("password")!=null ? (String)request.getParameter("password"):null ;
		
		//		gestion de la case se souvenir par cookie : 
		Cookie cookie = new Cookie("identite", email);
		if (request.getParameter("memoriser")!=null) {
			cookie.setHttpOnly(true);
			cookie.setMaxAge(-1); 
			response.addCookie(cookie);
		} else {
			//sinon forcer la destruction du cookie c�t� client
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		
		utilisateurManager mng = utilisateurManager.getInstance();
		RequestDispatcher rd;
		Utilisateur user =null;
		try {
			user = mng.selectById(email, password);
			rd =request.getRequestDispatcher("/WEB-INF/jsp/profilUtilisateur.jsp");
		} catch (BLLException e) {
			rd =request.getRequestDispatcher("/WEB-INF/jsp/connection.jsp");
			request.setAttribute("error", e);
			for (Exception exception : e.getBLLExceptions()) {
				System.out.println(exception.getMessage());
			}
		}
		
		rd.forward(request, response);
		
	}

}
