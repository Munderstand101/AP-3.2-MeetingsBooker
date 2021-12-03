package model.DAO;

import java.sql.ResultSet;

public class UtilisateurDAO {
	
	/**
	 * M�tode permettant de r�cup�rer les informations relatives � un utilisateur
	 * @param id (id utilidsateur)
	 * @return ResultSet
	 */
	public static ResultSet unUtilisateur(int id)
     {
		 	 
	     String requete = "SELECT *  FROM utilisateur where  idUtilisateur = '" + id + "'";
                 
         return DBConnex.getRS(requete, DBConnex.connexion());
 		
 			
     }
}
