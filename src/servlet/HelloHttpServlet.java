package servlet;
import java.io.*;

import bean.MonBean;
import dao.UserDAO;

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




@WebServlet("/home")
public class HelloHttpServlet extends HttpServlet{
	
	ArrayList urlList = new ArrayList<MonBean>();
	MonBean userBean = new MonBean();
	
	   public void doGet(HttpServletRequest request, HttpServletResponse response)
	               throws IOException, ServletException {
	      
		   request.setAttribute( "erreurLog", "" );
		   this.getServletContext().getRequestDispatcher( "/WEB-INF/home.jsp" ).forward( request, response );

		   
	   }
	   
	   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		   String dispatcher = null;
		   HttpSession session = request.getSession();
	        String login = request.getParameter("username");
	        String password = request.getParameter("password");
	        ServletContext context = getServletContext();
	        UserDAO daouser;
			try {
				daouser = new UserDAO();
				if(daouser.exist(login)) {
					if(daouser.getPassword(daouser.getID(login)).equals(password)) {
						userBean.setId(daouser.getID(login));
						userBean.setName(login);
						dispatcher = "/WEB-INF/index.jsp";
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        /*if(storedUser==null || !password.equals("22")) {
	            session.setAttribute("hasErrors", true);
	            session.setAttribute("isConnected", false);
	            //redirect to login page
	            dispatcher = "/WEB-INF/index.jsp";
	            
	            
	        }*/
		   
	        
		   
		   /* Connexion à la base de données */
					    

		    
		    //urlBean.setUrlLongue(request.getParameter("url"));
		    //urlBean.setUrlCourte(UUID.randomUUID().toString().replaceAll("-", ""));
		    //urlList.add(urlBean);
			      /* int isOK =0;
			       */
				   
			   	
		   request.setAttribute("userBean", userBean);
		   //dispatcher = "/WEB-INF/inscription.jsp";
	       this.getServletContext().getRequestDispatcher(dispatcher).include(request, response);

	    }

}