package model.DAO;

import model.DTO.Lieu;
import model.DTO.Salle;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SalleDAO {

    public static ResultSet lesSalle(String idLieu){
        String requete = "SELECT idLieu, nomSalle, largeur, longueur, surface, hauteur, capacite, tarifDemiJournee, idSalle  FROM salle WHERE idLieu="+
                idLieu+ " order by idLieu";

        return DBConnex.getRS(requete, DBConnex.connexion());
    }

    public static ArrayList<Salle> lesSalles(String idLieu){
        try {
            PreparedStatement stmt = DBConnex.getConnexion().prepareStatement("SELECT idLieu, nomSalle, largeur, longueur, surface, hauteur, capacite, tarifDemiJournee, idSalle  FROM salle WHERE idLieu=? order by idLieu");
            stmt.setString(1, idLieu);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Salle> salles = new ArrayList<>();
            while(rs.next()){
                salles.add(new Salle(rs.getString("idSalle"), rs.getString("nomSalle")
                         ,rs.getString("idLieu") ,rs.getInt("largeur"),
                        rs.getInt("longueur"),rs.getInt("surface")
                        ,rs.getInt("hauteur"),rs.getInt("capacite")
                        ,rs.getDouble("tarifDemiJournee")));
            }
            return salles;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }


    }

    public static void supprimerSalle(String idSalle){
        try {
            PreparedStatement stmt = DBConnex.getConnexion().prepareStatement("DELETE FROM salle WHERE idSalle=?");
            stmt.setString(1, idSalle);
            stmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void ajouterSalle(String idLieu, String nomSalle, int largeur,
                                   int longueur, int surface, int hauteur, int capacite,
                                   Double tarif){
        try {
            PreparedStatement stmt = DBConnex.getConnexion().prepareStatement("INSERT INTO salle (idLieu, nomSalle, largeur, longueur, surface, hauteur, capacite, tarifDemiJournee) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, idLieu);
            stmt.setString(2, nomSalle);
            stmt.setInt(3,largeur);
            stmt.setInt(4,longueur);
            stmt.setInt(5,surface);
            stmt.setInt(6,hauteur);
            stmt.setInt(7, capacite);
            stmt.setDouble(8, tarif);
            stmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void modifierSalle(String idSalle, String nomSalle, int largeur,
                                    int longueur, int surface, int hauteur, int capacite,
                                    Double tarif){
        try {
            PreparedStatement stmt = DBConnex.getConnexion().prepareStatement("UPDATE salle SET nomSalle=?, largeur=?, longueur=?, surface=?, hauteur=?, capacite=?, tarifDemiJournee=? WHERE idSalle=?");
            stmt.setString(1, nomSalle);
            stmt.setInt(2,largeur);
            stmt.setInt(3,longueur);
            stmt.setInt(4,surface);
            stmt.setInt(5,hauteur);
            stmt.setInt(6, capacite);
            stmt.setDouble(7, tarif);
            stmt.setString(8, idSalle);
            stmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
