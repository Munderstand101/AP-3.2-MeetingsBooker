package model.DAO;

import java.sql.ResultSet;

public class SalleDAO {

    public static ResultSet lesSalles(String idLieu){
        String requete = "SELECT idLieu, nomSalle, largeur, longueur, surface, hauteur, capacite, tarifDemiJournee, idSalle  FROM salle WHERE idLieu="+
                idLieu+ " order by idLieu";

        return DBConnex.getRS(requete, DBConnex.connexion());
    }

}
