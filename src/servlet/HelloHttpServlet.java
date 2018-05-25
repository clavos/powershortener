package servlet;
import java.io.*;

import bean.MonBean;
import java.util.ResourceBundle;
import java.util.ArrayList;
import java.util.UUID;


import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




@WebServlet("/tutu")
public class HelloHttpServlet extends HttpServlet{
	
	ArrayList urlList = new ArrayList<MonBean>();
	
	
	   public void doGet(HttpServletRequest request, HttpServletResponse response)
	               throws IOException, ServletException {
	      
		   request.setAttribute( "erreurLog", "" );
		   this.getServletContext().getRequestDispatcher( "/WEB-INF/index.jsp" ).forward( request, response );

		   
	   }
	   
	   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		   
		   try {
			    Class.forName( "com.mysql.jdbc.Driver" );
			} catch ( ClassNotFoundException e ) {
			}
			
			/* Connexion à la base de données */
			String url = "jdbc:mysql://localhost:3307/jee_intro";
			String utilisateur = "root";
			String motDePasse = "root";
			Connection connexion = null;
		    String dispatcher = "/WEB-INF/index.jsp";
		    MonBean urlBean = new MonBean();

		    
		    urlBean.setUrlLongue(request.getParameter("url"));
		    urlBean.setUrlCourte(UUID.randomUUID().toString().replaceAll("-", ""));
		    urlList.add(urlBean);
			      /* int isOK =0;
			       
			       
			       try {
					    connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
					    Statement statement = connexion.createStatement();
					    
					    ResultSet resUser = statement.executeQuery( "SELECT name, COUNT(name) AS isOK FROM USER;");
					    
					    while ( resUser.next() ) {
					        
					        isOK = resUser.getInt( "isOK" );
					        
					    }
					} catch ( SQLException e ) {
						System.out.println("Erreur SQL : "+e);
					} finally {
					    if ( connexion != null )
					        try {
					            connexion.close();
					        } catch ( SQLException ignore ) {
					        }
					}
				   
			       if(isOK == 1) {
			    	   dispatcher = "/WEB-INF/admin.jsp";
			    	   request.setAttribute("nom", urlBean.getUrlLongue());
			       }else {
			    	   request.setAttribute("erreurLog", "Votre requête ne peut aboutir :(");
			       }
			   
			*/
	
		    request.setAttribute("urlBean", urlBean);
		   dispatcher = "/WEB-INF/inscription.jsp";
	       this.getServletContext().getRequestDispatcher(dispatcher).include(request, response);

	    }

}
