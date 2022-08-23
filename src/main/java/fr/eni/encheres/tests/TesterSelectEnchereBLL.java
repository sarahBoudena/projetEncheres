package fr.eni.encheres.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bll.EnchereManager;
import fr.eni.encheres.bll.utilisateurManager;
import fr.eni.encheres.bo.ArticleVendu;

/**
 * Servlet implementation class TesterSelectEnchereBLL
 */
@WebServlet("/TesterSelectEnchereBLL")
public class TesterSelectEnchereBLL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TesterSelectEnchereBLL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message="";
		EnchereManager mng = EnchereManager.getInstance();
		List<ArticleVendu> listeEncheres = new ArrayList<ArticleVendu>();
		try {
			listeEncheres = mng.getListeEncheres();
			message = "La liste a bien été récupérée";
			System.out.println(listeEncheres);
		} catch (BLLException e) {
			message = "Problème lors de la récupération de la liste";
			e.printStackTrace();
		}
		response.getWriter().append("Test d'insertion BLL : " + message);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
