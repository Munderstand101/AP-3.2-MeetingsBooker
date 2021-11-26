package model.DAO;


import java.sql.ResultSet;
public class LoueurDAO {

	/**
	 * Méthode dpoure récupération les loueurs
	 * @return ResultSet (la liste des loueurs)
	 **/
	public static ResultSet lesLoueurs()
	{
		String requete = "SELECT * FROM `loueur`";
		return DBConnex.getRS(requete, DBConnex.connexion());
	}

	/**
	 * Méthode utilisée pour récupérer un loueur
	 * @param unIdLoueur
	 * @return ResultSet (la liste des lignes d'une feuille de dépenses
	 */
	public static ResultSet leLoueur(int unIdLoueur)
	{
		String requete = "SELECT * FROM `loueur` WHERE `loueur`.`idLoueur` = "+ unIdLoueur;
		return DBConnex.getRS(requete, DBConnex.connexion());
	}


	/**
	 * Méthode permettant de modifier l'état d'une fiche de frais
	 * @param unIdLoueur
	 * @param nouvelEtat (code �tat)
	 * @return Interger
	 */
	public static Integer changerEtatContact(int unIdLoueur , String nouvelEtat)
	{
		String requete = "UPDATE `loueur` SET `contact?` = '" + nouvelEtat + "' WHERE `loueur`.`idLoueur` = " + unIdLoueur ;
		return DBConnex.noQuery(requete, DBConnex.connexion());
	}

}
