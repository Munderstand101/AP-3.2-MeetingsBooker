package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnex {
	/**
	 * Méthode de connexion à la base de données
	 * @return  Statement
	 */
	public static Statement connexion() {
		
		Statement statement = null;
		 try {
				Connection	connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/gsb?user=root&password=");
			
				statement = connection.createStatement();
				
				
				return statement;
				
		    } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();	
				System.out.println(e.getMessage()); 
				return statement;
			}
	}
	
	/**
	 * Méthode d'authentification des l'utilisteur
	 * @param login
	 * @param mdp
	 * @param unStatement
	 * @return ResultSet
	 */
	public static ResultSet  authentification(String login , String mdp, Statement unStatement) {
		
		ResultSet rs = null ;
		try {
			String sql ="SELECT id , nom , prenom, login, statut  FROM utilisateur where login = '" + login + "' and mdp = '"+ mdp +"'";
			rs = unStatement.executeQuery(sql);
			if (!rs.next()) {
				rs =null;
			}
			
		} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(e.getMessage()); 
		}
		 return rs;
	}
	
	
	/**
	 * Méthode permettant l'envoi de requêtes "select" à la base de données
	 * @param requete
	 * @param unStatement
	 * @return ResultSet
	 */
	public static ResultSet  getRS(String requete ,Statement unStatement) {
		
		ResultSet rs = null ;
		 try {
				rs = unStatement.executeQuery(requete);		
				if (!rs.next()) {
					rs =null;
				}
								
		    } catch (SQLException e) {
				e.printStackTrace();
				System.out.println(e.getMessage()); 
				
			}
		 return rs;
	}
	
	/**
	  * Méthode permettant l'envoi de requêtes "update, insert, delete" à la base de données
	 * @param requete
	 * @param unStatement
	 * @return Integer
	 */
	public static Integer  noQuery(String requete ,Statement unStatement) {
		
		Integer reponse = -1 ;
		 try {
				reponse  = unStatement.executeUpdate(requete);		
				
								
		    } catch (SQLException e) {
				e.printStackTrace();
				System.out.println(e.getMessage()); 
				
			}
		 return reponse;
	}
	

}
