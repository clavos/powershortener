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
import javax.servlet.http.HttpSession;

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
		   this.getServletContext().getRequestDispatcher( "/WEB-INF/home.jsp" ).forward( request, response );

		   
	   }
	   
	   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		   String dispatcher;
		   HttpSession session = request.getSession();
	        String login = request.getParameter("username");
	        String password = request.getParameter("password");
	        ServletContext context = getServletContext();
	        //retrieval of the corresponding user, if exists
	        String storedUser = request.getParameter("username");
	 
	        /* ** FORM CHECK-OUT ** */
	        //user doesn't exist or bad password
	        if(storedUser==null || !password.equals("22")) {
	        	System.out.println("1"+storedUser);
	            session.setAttribute("hasErrors", true);
	            session.setAttribute("isConnected", false);
	            //redirect to login page
	            dispatcher = "/WEB-INF/index.jsp";
	            
	            
	        }
	       /* else if(password.equals(storedUser.getPassword())){
	            session.setAttribute("isConnected", true);
	            int hc = storedUser.getId().hashCode();
	            session.setAttribute(login, hc);
	            //redirect to the member welcome page
	            response.sendRedirect("member.jsp?id="+hc);
	        }*/
		   
		   try {
			    Class.forName( "com.mysql.jdbc.Driver" );
			   
				
			} catch ( ClassNotFoundException e ) {
			}
		   /* Connexion à la base de données */
			String url = "jdbc:mysql://localhost:3307/jee_intro";
			String utilisateur = "root";
			String motDePasse = "root";
			Connection connexion = null;
			
		    dispatcher = "/WEB-INF/index.jsp";
		    MonBean urlBean = new MonBean();

		    
		    //urlBean.setUrlLongue(request.getParameter("url"));
		    //urlBean.setUrlCourte(UUID.randomUUID().toString().replaceAll("-", ""));
		    //urlList.add(urlBean);
			      /* int isOK =0;
			       */
			       String userna;
			       try {
					    connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
					    Statement statement = connexion.createStatement();
					    
					    ResultSet resUser = statement.executeQuery( "SELECT name, COUNT(name) AS isOK FROM USER;");
					    
					    while ( resUser.next() ) {
					        
					        System.out.println("PO");
					        userna = resUser.getString( "name" );
					        System.out.println(userna);
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
				   
			   	
		   //request.setAttribute("urlBean", urlBean);
		   //dispatcher = "/WEB-INF/inscription.jsp";
	       this.getServletContext().getRequestDispatcher(dispatcher).include(request, response);

	    }

}