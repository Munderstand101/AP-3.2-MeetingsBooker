package model.DAO;

import java.sql.ResultSet;

public class SalleDAO {

    public static ResultSet lesSalles(){
        String requete = "SELECT idLieu, nomSalle, largeur, longueur, surface, hauteur, capacité, tarifDemiJournée, idSalle  FROM salle order by idLieu";

        return DBConnex.getRS(requete, DBConnex.connexion());
    }

}
