package model.DAO;

import model.DTO.ListeLieux;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ListeLieuxDAO {

    public static ArrayList<ListeLieux> listeLieuxClient(int id){
        ListeLieux uneListeLieu = null;
        ArrayList<ListeLieux> lesFichesClient = new ArrayList<ListeLieux>();
        int i = 0;
        try(PreparedStatement statement = DBConnex.getConnexion().prepareStatement("SELECT * FROM `listelieux` WHERE idEntreprise = ?")){
            statement.setInt(1, id);
            try (ResultSet result = statement.executeQuery()) {
                while (result.next()) {
                    uneListeLieu = new ListeLieux(
                            result.getString("idEntreprise"),
                            result.getString("nomEntreprise"),
                            result.getString("idLieu"),
                            result.getString("libelleLieu"),
                            result.getString("adresseLieu"),
                            result.getString("coordX"),
                            result.getString("coordY"),
                            result.getString("annulationGratuite"),
                            result.getString("nbEtoiles"),
                            result.getString("descriptif"),
                            result.getString("vilePays"));

                    lesFichesClient.add(uneListeLieu);
                }
                return lesFichesClient;
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return null;
    }

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

}
