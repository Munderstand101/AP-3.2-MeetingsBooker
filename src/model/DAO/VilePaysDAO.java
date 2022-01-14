package model.DAO;

import model.DTO.ListeLieux;
import model.DTO.VilePays;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VilePaysDAO {

    /**
     * Méthode pour récupération les Vile Pays
     * @return ArrayList (la liste des VilePays)
     **/
    public static ArrayList<VilePays> lesVilePays(){
        VilePays uneVilePays= null;
        ArrayList<VilePays> listeVilePays = new ArrayList<>();
        try (PreparedStatement statement = DBConnex.getConnexion().prepareStatement("SELECT * FROM `vilepays`")){
            try(ResultSet result = statement.executeQuery()){
                while(result.next()){
                    uneVilePays = new VilePays(result.getInt("idVille"), result.getString("vilepays"));
                    listeVilePays.add(uneVilePays);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listeVilePays;
    }
}
