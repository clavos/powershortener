package database;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.*;


public class main{
	
	static String url = "jdbc:mysql://localhost:3306/jee_intro";
	static String utilisateur = "jee";
	static String motDePasse = "jee_intro";
	static Connection connexion = null;
	static Statement statement = null;

	public static void main(String[] args) {

	}
	
	/*
	 * Initialisation de la connexion à la base de données
	 * True si réussite
	 * False si echec
	 */
	public boolean initdb() throws ClassNotFoundException {
		
		boolean state = false;
		try {
			Class.forName( "com.mysql.jdbc.Driver" );
		    connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
		    statement = connexion.createStatement();
		    statement.executeUpdate("CREATE TABLE  jee_intro.Link (id INT( 11 ) NOT NULL AUTO_INCREMENT ,shortLink VARCHAR ( 255 ), longLink VARCHAR( 255 ),UNIQUE ( id )) ENGINE = INNODB;");
		    state = true;
		} catch (SQLException e) {
			System.out.println("Erreur SQL : "+e);			
		} finally {
		    if ( connexion != null )
		        try {
		            connexion.close();
		        } catch ( SQLException ignore ) {
		        }
		}
		
		
		return state;
	}
	
	/*
	 * Ajout d'un couple de lien à la base de données
	 * True si réussite
	 * False si echec
	 */
	public boolean addLink(String shortLink, String longLink) throws ClassNotFoundException {
		boolean state = false;
		try {
			Class.forName( "com.mysql.jdbc.Driver" );
		    connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
		    statement = connexion.createStatement();
		    statement.executeUpdate("CREATE TABLE  jee_intro.Link (id INT( 11 ) NOT NULL AUTO_INCREMENT ,shortLink VARCHAR ( 255 ), longLink VARCHAR( 255 ),UNIQUE ( id )) ENGINE = INNODB;");
		    state = true;
		} catch (SQLException e) {
			System.out.println("Erreur SQL : "+e);			
		} finally {
		    if ( connexion != null )
		        try {
		            connexion.close();
		        } catch ( SQLException ignore ) {
		        }
		}
		
		return state;
	}
	
	/*
	 * GET d'un couple de lien
	 * Paramètre url longue
	 * Retourne un MonBean contenant les deux liens
	 */
	public MonBean getBeanLong(String urlLongue) {
		MonBean bean = new MonBean();
		String shortLink = null;
		String longLink = null;
		
		try {
			ResultSet resLink = statement.executeQuery( "SELECT shortLink, longLink FROM jee_intro.Link WHERE longlink = '"+urlLongue+"';" );
			
			while ( resLink.next() ) {
		        shortLink = resLink.getString( "shortLink" );
		        longLink = resLink.getString( "longLink" );		        
		    }
			
			
		} catch (SQLException e) {
			System.out.println("Erreur SQL : "+e);			
		} finally {
		    if ( connexion != null )
		        try {
		            connexion.close();
		        } catch ( SQLException ignore ) {
		        }
		}
		
		bean.setUrlCourte(shortLink);
		bean.setUrlLongue(longLink);
		
		return bean;
	}
	
	/*
	 * GET d'un couple de lien
	 * Paramètre url courte
	 * Retourne un MonBean contenant les deux liens
	 */
	public MonBean getBeanShort(String urlCourte) {
		MonBean bean = new MonBean();
		String shortLink = null;
		String longLink = null;
		
		try {
			ResultSet resLink = statement.executeQuery( "SELECT shortLink, longLink FROM jee_intro.Link WHERE longlink = '"+urlCourte+"';" );
			
			while ( resLink.next() ) {
		        shortLink = resLink.getString( "shortLink" );
		        longLink = resLink.getString( "longLink" );		        
		    }
			
			
		} catch (SQLException e) {
			System.out.println("Erreur SQL : "+e);			
		} finally {
		    if ( connexion != null )
		        try {
		            connexion.close();
		        } catch ( SQLException ignore ) {
		        }
		}
		
		bean.setUrlCourte(shortLink);
		bean.setUrlLongue(longLink);
		
		return bean;
	}
	
	
}
