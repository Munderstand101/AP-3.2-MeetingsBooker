package controller;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.DAO.FicheClientDAO;
import model.DAO.ReservationsLieuxDAO;
import model.DTO.FicheClient;
import model.DTO.ReservationsLieux;

public class ControllerListeFichesClients implements Initializable {

    /**
     * Les variables du fichier FXML associe
     */
    @FXML
    private TableView<FicheClient> tableListeFichesClients;
    @FXML
    private TableColumn<FicheClient, String> colNomEntreprise;
    @FXML
    private TableColumn<FicheClient, String> colAdresseEntreprise;
    @FXML
    private TableColumn<FicheClient, String> colVilePays;
    @FXML
    private TableColumn<FicheClient, String> colTelEntreprise;
    @FXML
    private TableColumn<FicheClient, String> colEmailEntreprise;
    @FXML
    private TableColumn<FicheClient, String> colNomPrenomContact;
    @FXML
    private TableColumn<FicheClient, Boolean> colEtatContact;
    @FXML
    private TableColumn<FicheClient, String> colMailContact;
    @FXML
    private TableColumn<FicheClient, String> colTelContact;
    @FXML
    private Button closeButtonListeFichesClient;
    @FXML
    private Button buttonValiderFicheClientClick;


    /**
     * Ajouter une fiche
     * Click sur le bouton "Ajouter une fiche"
     *
     * @param e
     */
    @FXML
    private void buttonAjouterFicheClientClick(ActionEvent e) {
        try {
            FXMLLoader loader = new FXMLLoader();
            Stage ajouterFicheClientStage = new Stage();

            loader.setLocation(Main.class.getResource("../view/viewAjouterFicheClient.fxml"));
            Pane ajouterFicheClientLayout = (Pane) loader.load();
            Scene ajouterFicheClientScene = new Scene(ajouterFicheClientLayout);
            ajouterFicheClientStage.setScene(ajouterFicheClientScene);

            ajouterFicheClientStage.setTitle("MeetingsBooker - Ajouter une Fiche client");
            ajouterFicheClientStage.initModality(Modality.APPLICATION_MODAL);
            ajouterFicheClientStage.showAndWait();
            refresh();

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    /**
     * modifier la fiche selectionnee
     * Click sur le bouton "modifier fiche selectionnee"
     *
     * @param e
     */
    @FXML
    private void buttonModifierFicheClientClick(ActionEvent e) {

        int index = tableListeFichesClients.getSelectionModel().getSelectedIndex();

        if (index >= 0) {

            FicheClient uneFiche = tableListeFichesClients.getSelectionModel().getSelectedItem();

            try {

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("../view/viewModifierFicheClient.fxml"));
                Parent modifierFicheClientLayout = (Parent) loader.load();
                ControllerModifierFicheClient setController = loader.getController();

                //appel de la methode de transfert vers le controleur "ControllerFicheClient"
                setController.transfertFunction(uneFiche);

                Stage modifierFicheClientStage = new Stage();

                modifierFicheClientStage.setScene(new Scene(modifierFicheClientLayout));
                modifierFicheClientStage.setTitle("MeetingsBooker - Fiche client");
                modifierFicheClientStage.initModality(Modality.APPLICATION_MODAL);
                modifierFicheClientStage.showAndWait();
                refresh();

            } catch (IOException e1) {
                e1.printStackTrace();
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Selectionnez une fiche client");
            alert.getDialogPane().setContentText("Vous devez selectionner une fiche client afin de la modifier");
            alert.showAndWait();
        }

    }

    /**
     * suprimer la fiche selectionnee
     * Click sur le bouton "suprimer fiche selectionnee"
     *
     * @param e
     */
    @FXML
    public void buttonSupprimerFicheClientClick(ActionEvent e) throws IOException {

        int index = tableListeFichesClients.getSelectionModel().getSelectedIndex();

        if (index >= 0) {

            FicheClient uneFiche = tableListeFichesClients.getSelectionModel().getSelectedItem();
            String idLoueur = uneFiche.getIdLoueur();

            ButtonType yes = new ButtonType("Oui", ButtonBar.ButtonData.OK_DONE);
            ButtonType non = new ButtonType("Non", ButtonBar.ButtonData.CANCEL_CLOSE);
            Alert alert = new Alert(Alert.AlertType.WARNING,
                    "Etes vous sure de vouloir supprimer cette fiche cleint ?",
                    yes,
                    non);

            alert.setTitle("Confirmation suppresion fiche client");
            Optional<ButtonType> result = alert.showAndWait();

            if (result.orElse(non) == yes) {
                FicheClientDAO.supprimerFicheClient(idLoueur);
                refresh();
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                alert1.setHeaderText("Suppresion d'une fiche client");
                alert1.getDialogPane().setContentText("La fiche cleint a bien ete supprimer !");
                alert1.showAndWait();
            }


        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Selectionnez une fiche client");
            alert.getDialogPane().setContentText("Vous devez selectionner une fiche client afin de la visualiser");
            alert.showAndWait();
        }
    }

    /**
     * Vlaider la fiche selectionnee
     * Click sur le bouton "Vlaider le contact de la fiche selectionnee"
     *
     * @param e
     */
    @FXML
    private void buttonValiderFicheClientClick(ActionEvent e) throws IOException {

        int index = tableListeFichesClients.getSelectionModel().getSelectedIndex();


        if(index >= 0) {
            FicheClient uneFiche = tableListeFichesClients.getSelectionModel().getSelectedItem();
            String id = uneFiche.getIdLoueur();
            if (uneFiche.getEtatContact() == true)
            {
                FicheClientDAO.changerEtatFiche(id, "0");
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                alert1.setHeaderText("Modification etat contact");
                alert1.getDialogPane().setContentText("La fiche client n'as pas encore ete contacter !");
                alert1.showAndWait();
            }else {
                FicheClientDAO.changerEtatFiche(id, "1");
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                alert1.setHeaderText("Modification etat contact");
                alert1.getDialogPane().setContentText("La fiche client a bien ete contacter !");
                alert1.showAndWait();
            }
            refresh();
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Selectionnez une fiche client");
            alert.getDialogPane().setContentText("Vous devez selectionner une fiche client afin de la valider");
            alert.showAndWait();
        }

    }

    /**
     * Fermeture de la vue
     *
     * @param e
     */
    @FXML
    public void buttonCloseListeFichesClientClick(ActionEvent e) {
        Stage stage = (Stage) closeButtonListeFichesClient.getScene().getWindow();
        stage.close();
    }

    /**
     * Remplissage le la tableView "liste des fiches clients"
     */
    private void remplissageFicheCliente() {

        try {
            ObservableList<FicheClient> data = FXCollections.observableArrayList();

            ArrayList<FicheClient> lesFicheClient = FicheClientDAO.lesFichesClients();

            for(FicheClient uneFicheClient: lesFicheClient){
                data.add(uneFicheClient);
            }

            colNomEntreprise.setCellValueFactory(new PropertyValueFactory<FicheClient, String>("nomEntreprise"));
            colAdresseEntreprise.setCellValueFactory(new PropertyValueFactory<FicheClient, String>("adresseEntreprise"));
            colVilePays.setCellValueFactory(new PropertyValueFactory<FicheClient, String>("vilePays"));
            colTelEntreprise.setCellValueFactory(new PropertyValueFactory<FicheClient, String>("telEntreprise"));
            colEmailEntreprise.setCellValueFactory(new PropertyValueFactory<FicheClient, String>("emailEntreprise"));
            colNomPrenomContact.setCellValueFactory(new PropertyValueFactory<FicheClient, String>("nomPrenomContact"));
            colEtatContact.setCellValueFactory(new PropertyValueFactory<FicheClient, Boolean>("etatContact"));
            colMailContact.setCellValueFactory(new PropertyValueFactory<FicheClient, String>("mailContact"));
            colTelContact.setCellValueFactory(new PropertyValueFactory<FicheClient, String>("telContact"));


            tableListeFichesClients.setItems(data);
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    /**
     * Rafraîchit le la tableView "liste des fiches clients"
     */
    public void refresh() {
        tableListeFichesClients.getItems().clear();
        remplissageFicheCliente();
    }

    /**
     * Appel de la fonction de remplissage de la tableView "liste des fiches clients"
     * initialisation de la vue
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        remplissageFicheCliente();
    }

    public void buttonListeLieuxClientClick(ActionEvent actionEvent) {
        int index = tableListeFichesClients.getSelectionModel().getSelectedIndex();

        if(index >= 0) {

            FicheClient uneFiche = tableListeFichesClients.getSelectionModel().getSelectedItem();

            try {

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("../view/viewListeLieuxClient.fxml"));
                Parent comptableFicheLayout = (Parent) loader.load();
                ControllerListeLieuxClient setController= loader.getController();

                //appel de la methode de transfert vers le controleur "ControllerFicheClient"
                setController.transfertFunction(uneFiche);

                Stage ficheClientStage = new Stage();

                ficheClientStage.setScene(new Scene(comptableFicheLayout));
                ficheClientStage.setTitle("MeetingsBooker - Liste lieux client");
                ficheClientStage.initModality(Modality.APPLICATION_MODAL);
                ficheClientStage.show();


            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Selectionnez une fiche client");
            alert.getDialogPane().setContentText("Vous devez selectionner une fiche client afin de la visualiser");
            alert.showAndWait();
        }
    }
}
