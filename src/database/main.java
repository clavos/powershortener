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
		

		    // Remise à zéro de la BD
		    statement.executeUpdate("DROP TABLE Link;");	

		    
		    //Création de la table
		    
		    statement.executeUpdate("INSERT INTO Link (shortLink, longLink) VALUES ('"+shortLink+"','"+longLink+"')");
		    
		    // On SELECT l'ensemble des visites pour les afficher
		    ResultSet resVisites = statement.executeQuery( "SELECT id, idPlanning, nom, note, date  FROM Visites;" );
		    
		    // On affiche la table (resultat du select)
		    while ( resVisites.next() ) {
		        int idPlanning = resVisites.getInt( "idPlanning" );
		        int idVisites = resVisites.getInt( "id" );
		        String nomVisites = resVisites.getString( "nom" );
		        String noteVisites = resVisites.getString( "note" );
		        String dateVisites = resVisites.getString( "date" );
		        
		        System.out.println(idPlanning+", "+idVisites+", "+nomVisites+", "+noteVisites+", "+dateVisites);
		    }


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
	
	
}
