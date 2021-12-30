package model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReservationDAO {

    public static int nbReservationM(String idLieu, int mois){
        try {
            PreparedStatement stmt = DBConnex.connexxion("SELECT COUNT(*) as nbResa FROM salle, reservation WHERE idLieu=? AND MONTH(dateResa) =? AND salle.idSalle=reservation.idSalle ");
            ResultSet rs = stmt.executeQuery();
            int nbResa;
            nbResa= rs.getInt("nbResa");
            return nbResa;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }
    }

    public static int nbReservationA(String idLieu){
        try {
            PreparedStatement stmt = DBConnex.connexxion("SELECT COUNT(*) as nbResa FROM salle, reservation WHERE idLieu=? AND YEAR(dateResa) =? AND salle.idSalle=reservation.idSalle ");
            ResultSet rs = stmt.executeQuery();
            int nbResa;
            nbResa= rs.getInt("nbResa");
            return nbResa;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }
    }
}
