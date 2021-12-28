package model.DAO;

import java.sql.ResultSet;

public class EntrepriseDAO {
    /**
     * Méthode pour récupération les entreprises
     * @return ResultSet (la liste des entreprise)
     **/
    public static ResultSet lesEntreprises()
    {
        String requete = "SELECT * FROM `entreprise`";
        return DBConnex.getRS(requete, DBConnex.connexion());
    }

    /**
     * M�tode permettant de r�cup�rer les informations relatives � un utilisateur
     * @param id (id utilidsateur)
     * @return ResultSet
     */
    public static ResultSet uneEntreprise(int id)
    {

        String requete = "SELECT *  FROM entreprise where  idEntreprise = '" + id + "'";

        return DBConnex.getRS(requete, DBConnex.connexion());


    }
}
