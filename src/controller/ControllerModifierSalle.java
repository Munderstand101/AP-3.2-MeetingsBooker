package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.DAO.LieuDAO;
import model.DAO.SalleDAO;
import model.DTO.Lieu;
import model.DTO.Salle;

public class ControllerModifierSalle {

    @FXML private TextField nomSalleTxt;
    @FXML private TextField longueurTxt;
    @FXML private TextField largeurTxt;
    @FXML private TextField surfaceTxt;
    @FXML private TextField hauteurTxt;
    @FXML private TextField capaciteTxt;
    @FXML private TextField tarifTxt;

    @FXML private Button btnModifier;


    private Salle salleActive;

    public void transfertFunction(Salle uneSalle) {

        nomSalleTxt.setText(uneSalle.getNomSalle());
        longueurTxt.setText(String.valueOf(uneSalle.getLongueur()));
        largeurTxt.setText(String.valueOf(uneSalle.getLargeur()));
        surfaceTxt.setText(String.valueOf(uneSalle.getSurface()));
        hauteurTxt.setText(String.valueOf(uneSalle.getHauteur()));
        capaciteTxt.setText(String.valueOf(uneSalle.getCapacite()));
        tarifTxt.setText(String.valueOf(uneSalle.getTarifDemiJournee()));

        salleActive=uneSalle;
    }

    @FXML private void modifierSalle(ActionEvent e){
        int largeur=Integer.parseInt(largeurTxt.getText());
        int longueur=Integer.parseInt(longueurTxt.getText());
        int surface=Integer.parseInt(surfaceTxt.getText());
        int hauteur=Integer.parseInt(hauteurTxt.getText());
        int capacite=Integer.parseInt(capaciteTxt.getText());
        Double tarif=Double.parseDouble(tarifTxt.getText());

        SalleDAO.modifierSalle(salleActive.getIdSalle(),nomSalleTxt.getText(),largeur,longueur,surface,hauteur,capacite,tarif);

        Stage stage = (Stage) btnModifier.getScene().getWindow();
        stage.close();
    }
}
