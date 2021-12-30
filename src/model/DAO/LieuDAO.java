package model.DAO;

import model.DTO.Lieu;

import java.sql.*;
import java.util.ArrayList;

public class LieuDAO {


    public static ResultSet lesLieu(){
        String requete = "SELECT idVille, idLieu, libelleLieu, adresseLieu, descriptif, idEntreprise  FROM lieu order by idEntreprise";

        return DBConnex.getRS(requete, DBConnex.connexion());
    }

    public static ArrayList<Lieu> lesLieux(){
        try {
            PreparedStatement stmt = DBConnex.connexxion("SELECT * FROM lieu order by idEntreprise");
            ResultSet rs = stmt.executeQuery();
            ArrayList<Lieu> lieux = new ArrayList<Lieu>();
            while(rs.next()){
                lieux.add(new Lieu(rs.getString("idVille"),rs.getString("idLieu"),rs.getString("libelleLieu"),rs.getString("adresseLieu")
                        ,rs.getString("descriptif"),rs.getString("idEntreprise"), rs.getInt("annulationGratuite"),
                        rs.getString("nbEtoiles"), rs.getDouble("coordX") ,rs.getDouble("coordY")));
            }
            return lieux;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

    }



    public static ArrayList<Integer> lesidEntreprises(){
        try {
            PreparedStatement stmt = DBConnex.connexxion("SELECT idEntreprise FROM entreprise");
            ResultSet rs = stmt.executeQuery();
            ArrayList<Integer> idEntreprises = new ArrayList<>();
            while(rs.next()){
                idEntreprises.add(rs.getInt("idEntreprise"));
            }
            return idEntreprises;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Integer> lesidVilles(){
        try {
            PreparedStatement stmt = DBConnex.connexxion("SELECT idVille FROM ville");
            ResultSet rs = stmt.executeQuery();
            ArrayList<Integer> idVilles = new ArrayList<>();
            while(rs.next()){
                idVilles.add(rs.getInt("idVille"));
            }
            return idVilles;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public static void ajouterLieu(int idVille, int idEntreprise, String libelleLieu,
                                   String adresseLieu, Double coordX, Double coordY, int annulationGratuite,
    int nbEtoiles, String descriptif){
        try {
            PreparedStatement stmt = DBConnex.connexxion("INSERT INTO lieu (idVille, idEntreprise, libelleLieu, adresseLieu, coordX, coordY, annulationGratuite, nbEtoiles, descriptif) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, idVille);
            stmt.setInt(2, idEntreprise);
            stmt.setString(3,libelleLieu);
            stmt.setString(4,adresseLieu);
            stmt.setDouble(5,coordX);
            stmt.setDouble(6,coordY);
            stmt.setInt(7, annulationGratuite);
            stmt.setInt(8, nbEtoiles);
            stmt.setString(9,descriptif);
            stmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void supprimerLieu(String idLieu){
        try {
            PreparedStatement stmt = DBConnex.connexxion("DELETE FROM lieu WHERE idLieu=?");
            stmt.setString(1, idLieu);
            stmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
