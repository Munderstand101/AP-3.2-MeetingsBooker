package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.DAO.LieuDAO;
import model.DTO.Lieu;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ControllerModifierLieu {

    @FXML
    private ComboBox cmbIdEntreprise;
    @FXML private ComboBox cmbIdVille;
    @FXML private ComboBox cmbAnnul;
    @FXML private ComboBox cmbNbEtoile;

    @FXML private TextField libelleLieuTxt;
    @FXML private TextField  adresseLieuTxt;
    @FXML private TextField  descriptifLieuTxt;
    @FXML private TextField  idEntrepriseTxt;
    @FXML private TextField  idVilleTxt;
    @FXML private TextField  annulGratuiteTxt;
    @FXML private TextField  nbEtoileTxt;

    @FXML private TextField  coordxTxt;
    @FXML private TextField  coordyTxt;

    @FXML private Button btnModifLieu;





    private Lieu lieuActif;

    public void transfertFunction(Lieu unLieu) {

        libelleLieuTxt.setText(unLieu.getLibelleLieu());
        adresseLieuTxt.setText(unLieu.getAdresseLieu());
        descriptifLieuTxt.setText(unLieu.getDescriptif());
        idEntrepriseTxt.setText(unLieu.getIdEntreprise());
        idVilleTxt.setText(unLieu.getIdVille());
        annulGratuiteTxt.setText(String.valueOf(unLieu.getAnnulationGratuite()));
        nbEtoileTxt.setText(unLieu.getNbEtoiles());

        //coordxTxt.setText(String.valueOf(unLieu.getCoordx()));
        //coordyTxt.setText(String.valueOf(unLieu.getCoordy()));

        lieuActif = unLieu;

    }

    @FXML private void idE(ActionEvent e){
        idEntrepriseTxt.setText(String.valueOf(cmbIdEntreprise.getValue()));
    }

    @FXML private void idV(ActionEvent e){
        idVilleTxt.setText(String.valueOf(cmbIdVille.getValue()));
    }
    @FXML private void aGr(ActionEvent e){
        annulGratuiteTxt.setText(String.valueOf(cmbAnnul.getValue()));
    }
    @FXML private void nbE(ActionEvent e){
        nbEtoileTxt.setText(String.valueOf(cmbNbEtoile.getValue()));
    }

    @FXML private void modifLieu(ActionEvent e){
        int annul=Integer.parseInt(annulGratuiteTxt.getText());

        int nbEt=Integer.parseInt(nbEtoileTxt.getText());

        LieuDAO.modifierLieu(idVilleTxt.getText(),idEntrepriseTxt.getText(),libelleLieuTxt.getText(),
                adresseLieuTxt.getText(),annul,
                nbEt,descriptifLieuTxt.getText(), lieuActif.getIdLieu());

        Stage stage = (Stage) btnModifLieu.getScene().getWindow();
        stage.close();
    }

    public void initialize() throws SQLException {
        cmbNbEtoile.getItems().addAll(1,2,3,4,5);
        cmbAnnul.getItems().addAll(1,0);


        ObservableList<Integer> lesidEntreprises = FXCollections.observableArrayList();
        ArrayList<Integer> idEntreprises =new ArrayList<>();
        idEntreprises= LieuDAO.lesidEntreprises();
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
