package fr.eni.encheres.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import fr.eni.encheres.bll.ArticleManager;
import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.jdbc.ArticleDAOJdbcImpl;

/**
 * Application Lifecycle Listener implementation class ActualisationBDD
 *
 */
@WebListener
public class ActualisationBDD implements ServletContextListener {
	private Thread task;
    /**
     * Default constructor. 
     */
    public ActualisationBDD() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
// --------------dès que le serveur est stoppé, la tache prend fin ---------------   	
    	if(task != null && task.isAlive()) {
        	task.interrupt();
        }
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	task = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
//-------------- tant que le serveur est en cours, la procédure stocké sur la BDD est lancée toutes les 10 secondes ------
					while(!task.isInterrupted()) {
						ArticleManager mng = ArticleManager.getInstance();
						mng.appelProcedureStockee();
						Thread.sleep(10000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BLLException e) {
					e.printStackTrace();
				}
			}
		});
         task.start();
    }
	
}
