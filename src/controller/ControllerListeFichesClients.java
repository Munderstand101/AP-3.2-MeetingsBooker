package controller;

import java.io.IOException;
import java.sql.ResultSet;

import java.util.ArrayList;
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
     * Les variables du fichier FXML associ�
     */
//    @FXML 	private TableView<Loueur> tableListeFichesClients;
    @FXML 	private TableView<FicheClient> tableListeFichesClients;
//    @FXML 	private TableColumn<Loueur , Integer > colIdLoueur;
//    @FXML 	private TableColumn<Loueur , Integer > colIdEntreprise;
//    @FXML 	private TableColumn<Utilisateur , String > colNom;
//    @FXML 	private TableColumn<Loueur , String > colNom;
//    @FXML 	private TableColumn<Entreprise , String > colNom;
//    @FXML 	private TableColumn<Loueur , String > colPrenom;
//    @FXML 	private TableColumn<Loueur , Boolean > colContact;
//    @FXML 	private TableColumn<Loueur , String > colTelContact;
//    @FXML  private TableColumn<Loueur , String > colMailContact;
    @FXML  private TableColumn<FicheClient , String > colMailContact;
    @FXML  private Button closeButtonListeFichesClient;



    //D�claration de l'ObservableList n�cessaire au remplissage de la tableView
//    private ObservableList<Loueur> data = FXCollections.observableArrayList();
    private ObservableList<FicheClient> data = FXCollections.observableArrayList();


    /**
     * Ouverture de la fiche s�lectionn�e
     * Click sur le bouton "Ouvrir fiche s�lectionn�e"
     * @param e
     */
    @FXML	private void buttonOuvrirFicheClientClick(ActionEvent e) {
/*
        int index = tableListeFichesComptable.getSelectionModel().getSelectedIndex();


        if(index >= 0) {

            FicheFrais uneFiche = tableListeFichesComptable.getSelectionModel().getSelectedItem();

            try {

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("../view/viewComptableFiche.fxml"));


                Parent comptableFicheLayout = (Parent) loader.load();

                ControllerComptableFiche setController= loader.getController();

                //appel de la methode de transfert vers le controleur "ControllerComptableFiche"
                setController.transfertFunction(uneFiche);

                Stage comptableFicheStage = new Stage();

                comptableFicheStage.setScene(new Scene(comptableFicheLayout));
                comptableFicheStage.setTitle("GSB Gestion des frais - Compta Fiche de frais");
                comptableFicheStage.initModality(Modality.APPLICATION_MODAL);
                comptableFicheStage.show();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("S�lectionnez une fiche de frais");
            alert.getDialogPane().setContentText("Vous devez s�lectionner une fiche de frais afin de la visualiser");
            alert.showAndWait();
        }
*/

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
                            rsListeFichesClients.getString(7),
                            rsListeFichesClients.getString(8));

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
        colMailContact.setCellValueFactory(new PropertyValueFactory<FicheClient,String>("mailContact"));

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
