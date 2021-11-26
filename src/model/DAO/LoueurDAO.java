package model.DAO;


import java.sql.ResultSet;
public class LoueurDAO {
	
	/**
	 * M�thode permettant de r�cup�rer les fiches de frais
	 * @return ResultSet (la liste des fiches de frais
	 */
	 public static ResultSet lesFichesFrais()
     {
		 		 
	     String requete = "SELECT *  FROM fichefrais order by annee desc , mois desc";
                 
         return DBConnex.getRS(requete, DBConnex.connexion());
 		
 		
     }
	 

	 
	 /**
	  * M�thode permettant de r�cup�rer les lignes d'une fiche de frais
	  * @param unIdFiche
	  * @return ResultSet (la liste des lignes d'une fiche de frais
	  */
	 public static ResultSet lesLignesFicheFrais(int unIdFiche)
     {
		 		 
	     String requete = "SELECT lignefrais.*, libelle , montant  FROM lignefrais join typefrais on lignefrais.idTypeFrais = typeFrais.id  where idFiche = " + unIdFiche ;
                 
         return DBConnex.getRS(requete, DBConnex.connexion());
 		
     }
	
	 
	 /**
	  * M�thode permettant de modifier l'�tat d'une fiche de frais
	  * @param unIdFiche
	  * @param nouvelEtat (code �tat)
	  * @return Interger 
	  */
	 public static Integer changerEtat(int unIdFiche , String nouvelEtat)
     {
		 		 
	     String requete = "update ficheFrais set idEtat = '" + nouvelEtat + "' where idFiche = " + unIdFiche ;
                 
         return DBConnex.noQuery(requete, DBConnex.connexion());
 		
 		
     }
	 
	 
}
