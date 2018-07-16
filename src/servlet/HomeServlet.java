package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.MonBean;
import dao.urlDAO;

/**
 * Servlet implementation class HomeServlet
 */

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   request.setAttribute( "erreurLog", "" );
		   this.getServletContext().getRequestDispatcher( "/WEB-INF/index.jsp" ).forward( request, response );
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		HttpSession session = request.getSession();
		MonBean userBean = new MonBean();
		String dispatcher = "/WEB-INF/urlCourte.jsp";
		urlDAO daourl;
		try {
			daourl = new urlDAO();
			daourl.newUrl(request.getParameter("url"), UUID.randomUUID().toString().replaceAll("-", ""));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		userBean.setUrlLongue(request.getParameter("url"));
	    userBean.setUrlCourte(UUID.randomUUID().toString().replaceAll("-", ""));
	    
	    request.setAttribute("userBean", userBean);
		this.getServletContext().getRequestDispatcher(dispatcher).include(request, response);
	}

}
