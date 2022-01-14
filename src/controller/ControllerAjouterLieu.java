package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
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
    @FXML private Label coordx;
    @FXML private Label coordy;
    @FXML private Slider slidCoordx;
    @FXML private Slider slidCoordy;






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


        slidCoordx.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, //
                                Number oldValue, Number newValue) {

                coordx.setText(String.valueOf(newValue));
            }
        });

        slidCoordy.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, //
                                Number oldValue, Number newValue) {

                coordy.setText(String.valueOf(newValue));
            }
        });


    }

    @FXML	private void ajouterLieuClick(ActionEvent e){
        int idVille = (int) cmbIdVille.getValue();
        int idEntreprise = (int) cmbIdEntreprise.getValue();
        int Annul = (int) cmbAnnul.getValue();
        int nbEtoiles = (int) cmbNbEtoile.getValue();
        LieuDAO.ajouterLieu(idVille,idEntreprise,libLieuTxt.getText(),
                adrLieuTxt.getText(),slidCoordx.getValue(),slidCoordy.getValue(),Annul,
                nbEtoiles,descriptifTxt.getText());

        Stage stage = (Stage) btnAjouter.getScene().getWindow();
        stage.close();
    }





}
