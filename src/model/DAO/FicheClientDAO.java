package model.DAO;

import model.DTO.FicheClient;
import model.DTO.VilePays;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FicheClientDAO {


    /**
     *  Méthode pour récupération les FichesClients
     * @return ArrayList (la liste des FicheClient
     **/
    public static ArrayList<FicheClient> lesFichesClients(){
        FicheClient uneFicheClient= null;
        ArrayList<FicheClient> listeFicheClient = new ArrayList<>();
        try (PreparedStatement statement = DBConnex.getConnexion().prepareStatement("SELECT * FROM `fichesclients3`")){
            try(ResultSet result = statement.executeQuery()){
                while(result.next()){
                    uneFicheClient = new FicheClient(
                            result.getString("idLoueur"),
                            result.getString("idEntreprise"),
                            result.getString("nomEntreprise"),
                            result.getString("adresseEntreprise"),
                            result.getString("vilePays"),
                            result.getString("telEntreprise"),
                            result.getString("emailEntreprise"),
                            result.getString("nomPrenomContact"),
                            result.getBoolean("etatContact"),
                            result.getString("mailContact"),
                            result.getString("telContact"));
                    listeFicheClient.add(uneFicheClient);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listeFicheClient;
    }
    /**
     *
     */
    public static void ajouterFicheClient(int unIdVille, String nomEntreprise, String adresseEntreprise, String telEntreprise, String emailEntreprise, String nomContact, String prenomContact, String etatContact, String mailContact, String telContact) throws SQLException {

        try (PreparedStatement statement = DBConnex.getConnexion().prepareStatement("CALL `AjouterFicheClient`(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);")) {
            statement.setString(1, String.valueOf(unIdVille));
            statement.setString(2, nomEntreprise);
            statement.setString(3, adresseEntreprise);
            statement.setString(4, telEntreprise);
            statement.setString(5, emailEntreprise);
            statement.setString(6, nomContact);
            statement.setString(7, prenomContact);
            statement.setString(8, etatContact);
            statement.setString(9, mailContact);
            statement.setString(10, telContact);
            statement.executeUpdate();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

    }

    /**
     *
     */
    public static void modifierFicheClient(int unIdLoueur, int unIdVille, String nomEntreprise, String adresseEntreprise, String telEntreprise, String emailEntreprise, String nomContact, String prenomContact, String etatContact, String mailContact, String telContact) throws SQLException {

        try (PreparedStatement statement = DBConnex.getConnexion().prepareStatement("CALL `ModifierFicheClient`(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);")) {
            statement.setString(1, String.valueOf(unIdLoueur));
            statement.setString(2, String.valueOf(unIdVille));
            statement.setString(3, nomEntreprise);
            statement.setString(4, adresseEntreprise);
            statement.setString(5, telEntreprise);
            statement.setString(6, emailEntreprise);
            statement.setString(7, nomContact);
            statement.setString(8, prenomContact);
            statement.setString(9, etatContact);
            statement.setString(10, mailContact);
            statement.setString(11, telContact);
            statement.executeUpdate();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

    }

    public static void supprimerFicheClient(String idLoueur){
        try {
            PreparedStatement stmt = DBConnex.getConnexion().prepareStatement("CALL `SupprimerFicheClient`(?);");
            stmt.setString(1, idLoueur);
            stmt.executeUpdate();

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public static void changerEtatFiche(String idLoueur, String i) {
        try (PreparedStatement statement = DBConnex.getConnexion().prepareStatement("UPDATE `loueur` SET `contact?` = ? WHERE `loueur`.`idLoueur` = ?;")) {
            statement.setString(1, i);
            statement.setString(2, idLoueur);
            statement.executeUpdate();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
}
