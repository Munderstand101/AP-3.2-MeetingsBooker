package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import model.DTO.FicheClient;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

public class ControllerFicheClient implements Initializable {

    /**
     * Les variables du fichier FXML associe
     */
    @FXML	private Label labelNomEntreprise;
    @FXML	private Label labelAdresseEntreprise;
    @FXML	private Label labelVilePays;
    @FXML	private Label labelTelEntreprise;
    @FXML	private Label labelEmailEntreprise;
    @FXML	private Label labelNomPrenomContact;
    @FXML	private Label labelEtatContact;
    @FXML	private Label labelMailContact;
    @FXML	private Label labelTelContact;




    /**
     * Fonction de transfert permettant d'afficher dans la vue "viewComptableFiche"
     * les informations relatives e la fiche selectionnee dans la vue "viewComptableListeFiches"
     * @param uneFiche
     */
    public void transfertFunction(FicheClient uneFiche) {

        labelNomEntreprise.setText("Nom Entrepris : " +uneFiche.getNomEntreprise());
        labelAdresseEntreprise.setText("Adresse Entreprise : " +uneFiche.getAdresseEntreprise());
        labelVilePays.setText("Vile/Pays : " +uneFiche.getVilePays());
        labelTelEntreprise.setText("Tel Entreprise : " +uneFiche.getTelEntreprise());

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
