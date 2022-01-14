package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.DAO.FicheClientDAO;
import model.DAO.VilePaysDAO;
import model.DTO.FicheClient;
import model.DTO.VilePays;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ControllerModifierFicheClient implements Initializable {

    public Button btnModifierFicheClient;
    public Button btnAnnulerFicheClient;
    public ComboBox cbxVillePays;
    public TextField nomEntreprise;
    public TextField adresseEntreprise;
    public TextField telEntreprise;
    public TextField emailEntreprise;
    public TextField nomContact;
    public TextField prenomContact;
    public TextField telContact;
    public TextField mailContact;
    public ComboBox estContacter;
    public int idLoueur;

    @FXML
    private void buttonModifierFicheClientClick(ActionEvent e) throws SQLException {
        if (cbxVillePays.getValue() != null && nomEntreprise.getText() != "" && adresseEntreprise.getText() != "" && telEntreprise.getText() != "" && emailEntreprise.getText() != "" && nomContact.getText() != "" && prenomContact.getText() != "" && estContacter.getValue() != null && mailContact.getText() != "" && telContact.getText() != "") {

            int cbxVillePaysId = cbxVillePays.getSelectionModel().getSelectedIndex();
            String nomEntrepriseTxt = nomEntreprise.getText();
            String adresseEntrepriseTxt = adresseEntreprise.getText();
            String telEntrepriseTxt = telEntreprise.getText();
            String emailEntrepriseTxt = emailEntreprise.getText();

            String nomContactTxt = nomContact.getText();
            String prenomContactTxt = prenomContact.getText();

            String estContacterId = (String) estContacter.getValue();

            String mailContactTxt = mailContact.getText();
            String telContactTxt = telContact.getText();

            String estContacter = "0";

            if (estContacterId.equals("Oui")) {
                estContacter = "1";
            }


            FicheClientDAO.modifierFicheClient(idLoueur, cbxVillePaysId, nomEntrepriseTxt, adresseEntrepriseTxt, telEntrepriseTxt, emailEntrepriseTxt, nomContactTxt, prenomContactTxt, estContacter, mailContactTxt, telContactTxt);


            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Modification reusit");
            alert.getDialogPane().setContentText("La fiche client a bien ete modifier");
            alert.showAndWait();


            Stage stage = (Stage) btnAnnulerFicheClient.getScene().getWindow();
            stage.close();

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Modification impossible");
            alert.getDialogPane().setContentText("remplissez touts les champs");
            alert.showAndWait();
        }
    }

    @FXML
    private void buttonAnnulerFicheClientClick(ActionEvent e) {
        Stage stage = (Stage) btnAnnulerFicheClient.getScene().getWindow();
        stage.close();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //remplit le combobox : cbxVillePays
        try {
            for(VilePays uneVilePays: VilePaysDAO.lesVilePays()){
                cbxVillePays.getItems().add(uneVilePays.getIdVille(), uneVilePays.getVilepays());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void transfertFunction(FicheClient uneFiche) {
        idLoueur = Integer.parseInt(uneFiche.getIdLoueur());
        cbxVillePays.getSelectionModel().select(uneFiche.getVilePays());
        nomEntreprise.setText(uneFiche.getNomEntreprise());
        adresseEntreprise.setText(uneFiche.getAdresseEntreprise());
        telEntreprise.setText(uneFiche.getTelEntreprise());
        emailEntreprise.setText(uneFiche.getEmailEntreprise());
        String[] splitString = uneFiche.getNomPrenomContact().split(" ");
        nomContact.setText(splitString[0]);
        prenomContact.setText(splitString[1]);
        telContact.setText(uneFiche.getTelContact());
        mailContact.setText(uneFiche.getMailContact());
        if (uneFiche.getEtatContact()==true)
        {
            estContacter.getSelectionModel().select(1);
        }
        else
        {
            estContacter.getSelectionModel().select(0);
        }
    }

}
