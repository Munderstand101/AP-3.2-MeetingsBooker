package model.DAO;

import java.sql.ResultSet;

public class LieuDAO {


    public static ResultSet lesLieux(){
        String requete = "SELECT idVille, idEntreprise, libelleLieu, adresseLieu, descriptif  FROM lieu order by idEntreprise";

        return DBConnex.getRS(requete, DBConnex.connexion());
    }
}
