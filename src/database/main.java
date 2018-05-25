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
		    statement.executeUpdate("DROP TABLE Visites;");

		    
		    //Création de la table
		    statement.executeUpdate("CREATE TABLE  jee_intro.Visites (id INT( 11 ) NOT NULL AUTO_INCREMENT ,idPlanning INT ( 11 ) NOT NULL, nom VARCHAR( 20 ) NOT NULL ,note INT( 11 ) NOT NULL ,date VARCHAR( 20 ),PRIMARY KEY ( id ),UNIQUE ( nom )) ENGINE = INNODB;");
		    statement.executeUpdate("INSERT INTO Visites (idPlanning, nom, note, date) VALUES (9999, 'Alexandre', 14, '01/01/1995')");
		    
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
