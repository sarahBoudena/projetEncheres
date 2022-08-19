package fr.eni.encheres.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bll.utilisateurManager;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class SupprimerServlet
 */
@WebServlet("/enchere/delete")
public class SupprimerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/supressionUtilisateur.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		utilisateurManager mng = utilisateurManager.getInstance();
		HttpSession session = request.getSession();
		Utilisateur user =(Utilisateur) session.getAttribute("user");
		int id = user.getNoUtilisateur();
		RequestDispatcher rd;
		System.out.println(user.toString());
		
		try {
			mng.delete(id);
			request.getSession().invalidate();
			rd = request.getRequestDispatcher("/WEB-INF/jsp/accueil.jsp");
		} catch(BLLException e) {
			rd = request.getRequestDispatcher("/WEB-INF/jsp/supressionUtilisateur.jsp");
			request.setAttribute("erreur", e);
		}	
			rd.forward(request, response);
	}

}
