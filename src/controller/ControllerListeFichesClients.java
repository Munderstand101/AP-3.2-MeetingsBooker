package controller;

import java.io.IOException;
import java.sql.ResultSet;

import java.util.ArrayList;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.DAO.EntrepriseDAO;
import model.DAO.FicheClientDAO;
import model.DAO.LoueurDAO;
import model.DAO.UtilisateurDAO;
import model.DTO.Entreprise;
import model.DTO.FicheClient;
import model.DTO.Loueur;

//import model.DTO.LigneFrais;
import model.DTO.Utilisateur;

public class ControllerListeFichesClients {

    /**
     * Les variables du fichier FXML associe
     */
    @FXML 	private TableView<FicheClient> tableListeFichesClients;
    @FXML  private TableColumn<FicheClient , String > colNomEntreprise;
    @FXML  private TableColumn<FicheClient , String > colAdresseEntreprise;
    @FXML  private TableColumn<FicheClient , String > colVilePays;
    @FXML  private TableColumn<FicheClient , String > colTelEntreprise;
    @FXML  private TableColumn<FicheClient , String > colEmailEntreprise;
    @FXML  private TableColumn<FicheClient , String > colNomPrenomContact;
    @FXML  private TableColumn<FicheClient , Boolean > colEtatContact;
    @FXML  private TableColumn<FicheClient , String > colMailContact;
    @FXML  private TableColumn<FicheClient , String > colTelContact;
    @FXML  private Button closeButtonListeFichesClient;




    private FicheClient ficheActive ;
    //Declaration de l'ObservableList necessaire au remplissage de la tableView
    private ObservableList<FicheClient> data = FXCollections.observableArrayList();


    /**
     * Ouverture de la fiche selectionnee
     * Click sur le bouton "Ouvrir fiche selectionnee"
     * @param e
     */
    @FXML	private void buttonOuvrirFicheClientClick(ActionEvent e) {

        int index = tableListeFichesClients.getSelectionModel().getSelectedIndex();


        if(index >= 0) {

            FicheClient uneFiche = tableListeFichesClients.getSelectionModel().getSelectedItem();


            try {

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("../view/viewFicheClient.fxml"));
                Parent comptableFicheLayout = (Parent) loader.load();
                ControllerFicheClient setController= loader.getController();

                //appel de la methode de transfert vers le controleur "ControllerFicheClient"
                setController.transfertFunction(uneFiche);

                Stage ficheClientStage = new Stage();

                ficheClientStage.setScene(new Scene(comptableFicheLayout));
                ficheClientStage.setTitle("MeetingsBooker - Fiche client");
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


    /**
     * AjouterF une fiche
     * Click sur le bouton "AjouterF une fiche"
     * @param e
     */
    @FXML	private void buttonAjouterFicheClientClick(ActionEvent e) {
        try {
            FXMLLoader loader = new FXMLLoader();
            Stage ajouterFicheClientStage = new Stage();

            loader.setLocation(Main.class.getResource("../view/viewAjouterFicheClient.fxml"));
            Pane ajouterFicheClientLayout = (Pane) loader.load();
            Scene ajouterFicheClientScene = new Scene(ajouterFicheClientLayout);
            ajouterFicheClientStage.setScene(ajouterFicheClientScene);

            ajouterFicheClientStage.setTitle("MeetingsBooker - Ajouter une Fiche client");
            ajouterFicheClientStage.initModality(Modality.APPLICATION_MODAL);
            ajouterFicheClientStage.show();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    /**
     * modifier la fiche selectionnee
     * Click sur le bouton "modifier fiche selectionnee"
     * @param e
     */
    @FXML	private void buttonModifierFicheClientClick(ActionEvent e) {

        try {
            FXMLLoader loader = new FXMLLoader();
            Stage modifierFicheClientStage = new Stage();

            loader.setLocation(Main.class.getResource("../view/viewModifierFicheClient.fxml"));
            Pane modifierFicheClientLayout = (Pane) loader.load();
            Scene modifierFicheClientScene = new Scene(modifierFicheClientLayout);
            modifierFicheClientStage.setScene(modifierFicheClientScene);

            modifierFicheClientStage.setTitle("MeetingsBooker - Modifier une Fiche client");
            modifierFicheClientStage.initModality(Modality.APPLICATION_MODAL);
            modifierFicheClientStage.show();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }

    /**
     * Vlaider la fiche selectionnee
     * Click sur le bouton "Vlaider le contact de la fiche selectionnee"
     * @param e
     */
    @FXML	private void buttonValiderFicheClientClick(ActionEvent e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Modification impossible");
        alert.getDialogPane().setContentText("Validation de la fiche non effectuee.");
        alert.showAndWait();

       /* if( ficheActive.getEtatContact().compareTo("0")==0) {

            Integer reponse = FicheClientDAO.changerEtat(ficheActive.getIdLoueur() , "1");
            if(reponse == 1) {
                ficheActive.changerEtatFiche("VA");
                etatLabel.setText("Etat : "+ ficheActive.getEtatLong());
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Modification impossible");
                alert.getDialogPane().setContentText("Validation de la fiche non effectuee.");
                alert.showAndWait();
            }
        }*/
    }



    /**
     * Remplissage le la tableView "liste des fiches de frais"
     */
    private void remplissagetableViewListeFichesComptable() {
        try {

//            ResultSet rsListeFichesClients = LoueurDAO.lesLoueurs();
            try (ResultSet rsListeFichesClients = FicheClientDAO.lesFichesClients()) {

                //  ArrayList<Loueur> lesLignesFichesClients;
                rsListeFichesClients.beforeFirst();
                while (rsListeFichesClients.next()) {

                    FicheClient uneFicheClient = new FicheClient(
                            rsListeFichesClients.getString(1),
                            rsListeFichesClients.getString(2),
                            rsListeFichesClients.getString(3),
                            rsListeFichesClients.getString(4),
                            rsListeFichesClients.getString(5),
                            rsListeFichesClients.getString(6),
                            rsListeFichesClients.getBoolean(7),
                            rsListeFichesClients.getString(8),
                            rsListeFichesClients.getString(9));

                 /*   ResultSet rsUnUtilisateur = UtilisateurDAO.unUtilisateur(rsListeFichesClients.getInt(1));
                    Utilisateur utilisateur = new Utilisateur(
                            rsUnUtilisateur.getString(1),
                            rsUnUtilisateur.getString(2),
                            rsUnUtilisateur.getString(3),
                            rsUnUtilisateur.getString(4),
                            rsUnUtilisateur.getString(5),
                            rsUnUtilisateur.getString(6),
                            rsUnUtilisateur.getString(7),
                            rsUnUtilisateur.getString(8),
                            rsUnUtilisateur.getString(9),
                            rsUnUtilisateur.getDate(10));

                    ResultSet rsUneEntreprise = EntrepriseDAO.uneEntreprise(rsListeFichesClients.getInt(2));
                    Entreprise entreprise = new Entreprise(
                            rsUneEntreprise.getInt(1),
                            rsUneEntreprise.getInt(2),
                            rsUneEntreprise.getString(3),
                            rsUneEntreprise.getString(4),
                            rsUneEntreprise.getString(5),
                            rsUneEntreprise.getString(6));


                    Loueur uneFicheClient= new Loueur(
                            rsListeFichesClients.getInt(1),
                            rsListeFichesClients.getInt(2),
                            rsListeFichesClients.getString(3),
                            rsListeFichesClients.getString(4),
                            rsListeFichesClients.getBoolean(5),
                            rsListeFichesClients.getString(6),
                            rsListeFichesClients.getString(7),
                            utilisateur,
                            entreprise);*/

                    //    ResultSet rsLesLignes = LoueurDAO.lesLignesFicheFrais(rsListeFichesClients.getInt(1));
                    //  lesLignesFichesClients = new ArrayList<Loueur>();

                  /*  if(rsLesLignes != null){

                        rsLesLignes.beforeFirst();
                        while (rsLesLignes.next()) {
                            Loueur uneLigneFrais = new Loueur(rsLesLignes.getInt(1),rsLesLignes.getString(2) ,rsLesLignes.getInt(3), rsLesLignes.getString(4), rsLesLignes.getFloat(5));
                            lesLignesFrais.add(uneLigneFrais);
                        }
                    }*/

                    //uneFicheClient.setLesLignes(lesLignesFichesClients);


                    data.add(uneFicheClient);


                }
            }


        }
        catch (Exception e) {
            e.printStackTrace();
        }


//        colIdLoueur.setCellValueFactory(new PropertyValueFactory<Loueur,Integer>("idLoueur"));
//        colIdEntreprise.setCellValueFactory(new PropertyValueFactory<Loueur,Integer>("IdEntreprise"));
//        colNom.setCellValueFactory(new PropertyValueFactory<Utilisateur,String>("Nom"));
//        colNom.setCellValueFactory(new PropertyValueFactory<Utilisateur,String>("mdp"));
//        colNom.setCellValueFactory(new PropertyValueFactory<Entreprise,String>("nomEntreprise"));
//        colNom.setCellValueFactory(new PropertyValueFactory<Loueur,String>("Nom"));
//        colPrenom.setCellValueFactory(new PropertyValueFactory<Loueur,String>("Prenom"));
//        colContact.setCellValueFactory(new PropertyValueFactory<Loueur,Boolean>("contact"));
//        colTelContact.setCellValueFactory(new PropertyValueFactory<Loueur,String>("telContact"));
//        colMailContact.setCellValueFactory(new PropertyValueFactory<Loueur,String>("mailContact"));
        colNomEntreprise.setCellValueFactory(new PropertyValueFactory<FicheClient,String>("nomEntreprise"));
        colAdresseEntreprise.setCellValueFactory(new PropertyValueFactory<FicheClient,String>("adresseEntreprise"));
        colVilePays.setCellValueFactory(new PropertyValueFactory<FicheClient,String>("vilePays"));
        colTelEntreprise.setCellValueFactory(new PropertyValueFactory<FicheClient,String>("telEntreprise"));
        colEmailEntreprise.setCellValueFactory(new PropertyValueFactory<FicheClient,String>("emailEntreprise"));
        colNomPrenomContact.setCellValueFactory(new PropertyValueFactory<FicheClient,String>("nomPrenomContact"));
        colEtatContact.setCellValueFactory(new PropertyValueFactory<FicheClient,Boolean>("etatContact"));
        colMailContact.setCellValueFactory(new PropertyValueFactory<FicheClient,String>("mailContact"));
        colTelContact.setCellValueFactory(new PropertyValueFactory<FicheClient,String>("telContact"));

        tableListeFichesClients.setItems(data);

    }



    /**
     * Fermeture de la vue
     * @param e
     */
    public void buttonCloseListeFichesClientClick(ActionEvent e) {
        Stage stage = (Stage) closeButtonListeFichesClient.getScene().getWindow();
        stage.close();
    }


    /**
     * Appel de la fonction de remplissage de la tableView "liste des fiches"
     * initialisation de la vue
     */
    public void initialize() {
        remplissagetableViewListeFichesComptable();
    }













}
