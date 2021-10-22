package model.DAO;

import java.sql.ResultSet;

public class UtilisateurDAO {
	
	/**
	 * Métode permettant de récupérer les informations relatives à un utilisateur
	 * @param id (id utilidsateur)
	 * @return ResultSet
	 */
	public static ResultSet unUtilisateur(String id)
     {
		 	 
	     String requete = "SELECT *  FROM utilisateur where  id = '" + id + "'";
                 
         return DBConnex.getRS(requete, DBConnex.connexion());
 		
 			
     }
}
