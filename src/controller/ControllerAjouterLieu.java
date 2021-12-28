package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.DAO.EntrepriseDAO;
import model.DAO.LieuDAO;
import model.DTO.Entreprise;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControllerAjouterLieu {

    @FXML private TextField libLieuTxt;
    @FXML private TextField descriptifTxt;
    @FXML private TextArea adrLieuTxt;
    @FXML private TextField coordxTxt;
    @FXML private TextField coordyTxt;
    @FXML private ComboBox cmbIdEntreprise;
    @FXML private ComboBox cmbIdVille;
    @FXML private ComboBox cmbAnnul;
    @FXML private ComboBox cmbNbEtoile;
    @FXML private Button btnAjouter;

    public void initialize() throws SQLException {
        cmbNbEtoile.getItems().addAll(1,2,3,4,5);
        cmbAnnul.getItems().addAll(1,0);


        ObservableList<Integer> lesidEntreprises = FXCollections.observableArrayList();
        ArrayList<Integer> idEntreprises =new ArrayList<>();
        idEntreprises=LieuDAO.lesidEntreprises();
        for (Integer id: idEntreprises ){
            lesidEntreprises.add(id);
        }
        cmbIdEntreprise.setItems(lesidEntreprises);

        ObservableList<Integer> lesidVilles = FXCollections.observableArrayList();
        ArrayList<Integer> idVilles =new ArrayList<>();
        idVilles = LieuDAO.lesidVilles();
        for (Integer id: idVilles ){
            lesidVilles.add(id);
        }
        cmbIdVille.setItems(lesidVilles);


    }



}
