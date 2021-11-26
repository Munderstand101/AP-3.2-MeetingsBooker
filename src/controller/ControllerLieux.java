package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.DAO.FicheFraisDAO;
import model.DAO.LieuDAO;
import model.DAO.UtilisateurDAO;
import model.DTO.FicheFrais;
import model.DTO.Lieu;
import model.DTO.LigneFrais;
import model.DTO.Utilisateur;

import java.sql.ResultSet;
import java.util.ArrayList;

public class ControllerLieux {


    @FXML private TableView<Lieu> tableLieux;
    @FXML private TableColumn<Lieu, Integer> colIdVille;
    @FXML private TableColumn<Lieu, Integer> colIdEntreprise;
    @FXML private TableColumn<Lieu, String> colLibelleLieu;
    @FXML private TableColumn<Lieu, String> colAdresseLieu;
    @FXML private TableColumn<Lieu, String> colDescriptifLieu;

    private ObservableList<Lieu> data = FXCollections.observableArrayList();

    private void remplissagetableViewLieux() {
        try {

            ResultSet rsLieux = LieuDAO.lesLieux();


            rsLieux.beforeFirst();
            while (rsLieux.next()) {

                Lieu thelieu = new Lieu(rsLieux.getString(1),rsLieux.getString(2),rsLieux.getString(3),rsLieux.getString(4),rsLieux.getString(5));



                data.add(thelieu);

            }



        }
        catch (Exception e) {
            e.printStackTrace();
        }


        colIdVille.setCellValueFactory(new PropertyValueFactory<Lieu,Integer>("idVille"));
        colIdEntreprise.setCellValueFactory(new PropertyValueFactory<Lieu,Integer>("idEntreprise"));
        colLibelleLieu.setCellValueFactory(new PropertyValueFactory<Lieu,String>("libelleLieu"));
        colAdresseLieu.setCellValueFactory(new PropertyValueFactory<Lieu,String>("adresseLieu"));
        colDescriptifLieu.setCellValueFactory(new PropertyValueFactory<Lieu,String>("DescriptifLieu"));

        tableLieux.setItems(data);

    }

    public void initialize() {

        remplissagetableViewLieux();
    }


}
