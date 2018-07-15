package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.User;

public class UserDAO {

	Statement statement;
	Connection connexion;
	
	public UserDAO () throws SQLException {
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
	
	
	
	public boolean exist(String name) throws SQLException {
		
		ResultSet resUser = statement.executeQuery( "SELECT COUNT(name) AS isOK FROM USER WHERE name == "+name+";");
		boolean exist = false;
		int userna = 0;
	    while ( resUser.next() ) {
	        
	        userna = resUser.getInt( "name" );
	    }
	    if (userna == 0) {
	    	exist = false;
	    }
	    else {
	    	exist = true;
	    }
        return exist;
    }
	
	public int getID(String name) throws SQLException {
		
		ResultSet resUser = statement.executeQuery( "SELECT id FROM USER WHERE name == "+name+";");
		int id = 0;
	    while ( resUser.next() ) {
	        
	        id = resUser.getInt( "id" );
	    }
	    
		return id;
	}
	
	public String getPassword(int id) throws SQLException {
		ResultSet resUser = statement.executeQuery( "SELECT pass FROM USER WHERE id == "+id+";");
		String userna = null;
	    while ( resUser.next() ) {
	        
	        userna = resUser.getString( "pass" );
	    }
        return userna;
    }
	
	public void inscription (String name, String pass) throws SQLException {
		
		ResultSet resUser = statement.executeQuery("INSERT INTO USER name, pass ('"+name+"','"+pass+"')");
		
	}
    
}