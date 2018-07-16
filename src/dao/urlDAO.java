package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.User;

public class urlDAO {

	Statement statement;
	Connection connexion;
	
	public urlDAO () throws SQLException {
		try {
		    Class.forName( "com.mysql.jdbc.Driver" );
		   
			
		} catch ( ClassNotFoundException e ) {
		}
		String url = "jdbc:mysql://localhost:3307/jee_intro";
		String utilisateur = "root";
		String motDePasse = "root";
		connexion = null;
		connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
	    statement = connexion.createStatement();
	}
	

	
	public void newUrl (String urlLongue, String urlCourte) throws SQLException {
		
		int resUser = statement.executeUpdate("INSERT INTO URL (urlLongue, urlCourte) VALUES ('"+urlLongue+"','"+urlCourte+"')");
		
	}
    
}