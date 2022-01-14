package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.DAO.LieuDAO;
import model.DAO.SalleDAO;
import model.DTO.Lieu;

public class ControllerAjouterSalle {

    @FXML private Slider sLargeur;
    @FXML private Slider sLongueur;
    @FXML private Slider sSurface;
    @FXML private Slider sHauteur;
    @FXML private Slider sCapacite;
    @FXML private Slider sTarif;

    @FXML private Label lblLargeur;
    @FXML private Label lblLongueur;
    @FXML private Label lblSurface;
    @FXML private Label lblHauteur;
    @FXML private Label lblCapacite;
    @FXML private Label lblTarif;

    @FXML private Label nomLieu;

    @FXML private TextField nomSalleTxt;

    @FXML private Button btnAjouter;

    String idLieu;


    public void transfertFunction(Lieu unLieu) {
        nomLieu.setText("Le nom du lieu : " +unLieu.getLibelleLieu());
        if(unLieu.getIdLieu()!=null) {

            idLieu=unLieu.getIdLieu();

        }
    }

    @FXML	private void ajouterSalleClick(ActionEvent e){
        int largeur= (int) sLargeur.getValue();
        int longueur = (int) sLongueur.getValue();
        int surface = (int) sSurface.getValue();
        int hauteur = (int) sHauteur.getValue();
        int capacite = (int) sCapacite.getValue();

        SalleDAO.ajouterSalle(idLieu,nomSalleTxt.getText(),largeur,
                longueur,surface, hauteur,
                capacite, sTarif.getValue());

        Stage stage = (Stage) btnAjouter.getScene().getWindow();
        stage.close();
    }

    public void initialize(){

        sLargeur.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, //
                                Number oldValue, Number newValue) {

                lblLargeur.setText(String.valueOf(newValue));
            }
        });

        sLongueur.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, //
                                Number oldValue, Number newValue) {

                lblLongueur.setText(String.valueOf(newValue));
            }
        });

        sSurface.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, //
                                Number oldValue, Number newValue) {

                lblSurface.setText(String.valueOf(newValue));
            }
        });

        sHauteur.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, //
                                Number oldValue, Number newValue) {

                lblHauteur.setText(String.valueOf(newValue));
            }
        });

        sCapacite.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, //
                                Number oldValue, Number newValue) {

                lblCapacite.setText(String.valueOf(newValue));
            }
        });

        sTarif.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, //
                                Number oldValue, Number newValue) {

                lblTarif.setText(String.valueOf(newValue));
            }
        });
    }
}
