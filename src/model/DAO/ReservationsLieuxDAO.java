package model.DAO;

import model.DTO.ListeLieux;
import model.DTO.ReservationsLieux;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReservationsLieuxDAO {

    public static ArrayList<ReservationsLieux> lesReservationsLieux(int id1, int id2) throws SQLException {
        ReservationsLieux uneReservationsLieux = null;
        ArrayList<ReservationsLieux> lesReservationsLieux = new ArrayList<ReservationsLieux>();
        int i = 0;
        try(PreparedStatement statement = DBConnex.getConnexion().prepareStatement("SELECT * FROM `listereservationslieux` WHERE `idLieu` = ? AND `idEntreprise` = ?")){
            statement.setInt(1, id1);
            statement.setInt(2, id2);
            try (ResultSet result = statement.executeQuery()) {
                while (result.next()) {
                    uneReservationsLieux = new ReservationsLieux(
                            result.getString("idLieu"),
                            result.getString("libelleLieu"),
                            result.getString("idResa"),
                            result.getString("idEntreprise"),
                            result.getString("nomEntreprise"),
                            result.getString("nomSalle"),
                            result.getString("tarifDemiJournee"),
                            result.getString("dateResa"),
                            result.getString("nbPersonnes"),
                            result.getString("vilePays"),
                            result.getString("dateDebut"));

                    lesReservationsLieux.add(uneReservationsLieux);
                }
                return lesReservationsLieux;
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static String totalReservClient(int id) {
        String montantTotal = null;
        try (PreparedStatement statement = DBConnex.getConnexion().prepareStatement("SELECT montantTotal FROM `montanttotalclient` WHERE `idEntreprise` =  ?")) {
            statement.setInt(1, id);
            try (ResultSet result = statement.executeQuery()) {
                while (result.next()) {
                    montantTotal = result.getString("montantTotal");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return montantTotal;
    }

}
