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

}
