package model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReservationDAO {

    public static int nbReservationM(String idLieu, int mois){
        try {
            PreparedStatement stmt = DBConnex.getConnexion().prepareStatement("SELECT COUNT(*) as nbResa FROM salle, reservation WHERE idLieu=? AND MONTH(dateResa) =? AND salle.idSalle=reservation.idSalle ");
            stmt.setString(1,idLieu);
            stmt.setInt(2,mois);
            ResultSet rs = stmt.executeQuery();
            int nbResa = 0;
            while(rs.next()){
                nbResa = rs.getInt(1);
            }
            return nbResa;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }
    }

    public static int nbReservationA(String idLieu, int annee){
        try {
            PreparedStatement stmt = DBConnex.getConnexion().prepareStatement("SELECT COUNT(*) as nbResa FROM salle, reservation WHERE idLieu=? AND YEAR(dateResa) =? AND salle.idSalle=reservation.idSalle ");
            stmt.setString(1,idLieu);
            stmt.setInt(2,annee);
            ResultSet rs = stmt.executeQuery();
            int nbResa=0;
            while(rs.next()){
                nbResa = rs.getInt(1);
            }

            return nbResa;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }
    }

    public static Double caReservationM(String idLieu, int mois){
        try {
            PreparedStatement stmt = DBConnex.getConnexion().prepareStatement("SELECT tarifDemiJournee FROM salle, reservation WHERE idLieu=? AND MONTH(dateResa) =? AND salle.idSalle=reservation.idSalle ");
            stmt.setString(1,idLieu);
            stmt.setInt(2,mois);
            ResultSet rs = stmt.executeQuery();
            Double caResa = 0.0;
            while(rs.next()){
                caResa = caResa+rs.getDouble("tarifDemiJournee");
            }
            return caResa;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0.0;
        }
    }

    public static Double caReservationA(String idLieu, int annee){
        try {
            PreparedStatement stmt = DBConnex.getConnexion().prepareStatement("SELECT tarifDemiJournee FROM salle, reservation WHERE idLieu=? AND YEAR(dateResa) =? AND salle.idSalle=reservation.idSalle ");
            stmt.setString(1,idLieu);
            stmt.setInt(2,annee);
            ResultSet rs = stmt.executeQuery();
            Double caResa = 0.0;
            while(rs.next()){
                caResa = caResa+rs.getDouble("tarifDemiJournee");
            }
            return caResa;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0.0;
        }
    }
}
