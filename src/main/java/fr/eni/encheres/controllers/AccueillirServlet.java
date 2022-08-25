package fr.eni.encheres.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bll.EnchereManager;
import fr.eni.encheres.bo.ArticleVendu;

/**
 * Servlet implementation class AccueillirServlet
 */
@WebServlet("/accueil")
public class AccueillirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccueillirServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ArticleVendu> listeEncheresEC = new ArrayList<ArticleVendu>();
		try {
			EnchereManager mng = EnchereManager.getInstance();
			listeEncheresEC = mng.getListeEncheres();
			request.setAttribute("listeEncheresEC", listeEncheresEC);
		} catch (BLLException e) {
			request.setAttribute("error", e);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/accueil.jsp");
		rd.forward(request, response);
	}

}
