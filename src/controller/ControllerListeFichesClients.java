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
import model.DAO.LoueurDAO;
import model.DAO.UtilisateurDAO;
import model.DTO.Loueur;

//import model.DTO.LigneFrais;
import model.DTO.Utilisateur;

public class ControllerListeFichesClients {

    /**
     * Les variables du fichier FXML associ�
     */
    @FXML 	private TableView<Loueur> tableListeFichesComptable;
    @FXML 	private TableColumn<Loueur , Integer > colIdFiche;
    @FXML 	private TableColumn<Loueur , String > colNomVisiteur;
    @FXML 	private TableColumn<Loueur , Integer > colMoisFiche;
    @FXML  private TableColumn<Loueur , String > colEtatFiche;
    @FXML  private Button closeButtonListeFichesComptable;



    //D�claration de l'ObservableList n�cessaire au remplissage de la tableView
    private ObservableList<Loueur> data = FXCollections.observableArrayList();


    /**
     * Ouverture de la fiche s�lectionn�e
     * Click sur le bouton "Ouvrir fiche s�lectionn�e"
     * @param e
     */
    @FXML	private void buttonOuvrirFicheComptableClick(ActionEvent e) {
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

            ResultSet rsListeFichesComptable = LoueurDAO.lesLoueurs();

/*
            ArrayList<Loueur> lesLignesFrais;


            rsListeFichesComptable.beforeFirst();
            while (rsListeFichesComptable.next()) {



                ResultSet rsUnVisiteur = UtilisateurDAO.unUtilisateur(rsListeFichesComptable.getString(2));

                Utilisateur utilisateur = new Utilisateur(rsUnVisiteur.getString(1), rsUnVisiteur.getString(2)  , rsUnVisiteur.getString(3)   , rsUnVisiteur.getString(4)  , rsUnVisiteur.getString(5) , rsUnVisiteur.getString(6) , rsUnVisiteur.getString(7) , rsUnVisiteur.getString(8)  , rsUnVisiteur.getString(9), rsUnVisiteur.getDate(10)) ;

                Loueur uneFicheFrais = new Loueur(rsListeFichesComptable.getInt(1) ,rsListeFichesComptable.getInt(3) ,rsListeFichesComptable.getInt(4)  ,rsListeFichesComptable.getDate(5)  ,rsListeFichesComptable.getDate(6)  ,rsListeFichesComptable.getString(7) , rsListeFichesComptable.getFloat(8), utilisateur);


                ResultSet rsLesLignes = LoueurDAO.lesLignesFicheFrais(rsListeFichesComptable.getInt(1));



                lesLignesFrais = new ArrayList<Loueur>();

                if(rsLesLignes != null){

                    rsLesLignes.beforeFirst();
                    while (rsLesLignes.next()) {
                        Loueur uneLigneFrais = new Loueur(rsLesLignes.getInt(1),rsLesLignes.getString(2) ,rsLesLignes.getInt(3), rsLesLignes.getString(4), rsLesLignes.getFloat(5));
                        lesLignesFrais.add(uneLigneFrais);
                    }
                }
                uneFicheFrais.setLesLignes(lesLignesFrais);


                data.add(uneFicheFrais);



            }

*/

        }
        catch (Exception e) {
            e.printStackTrace();
        }


//        colIdFiche.setCellValueFactory(new PropertyValueFactory<Loueur,Integer>("idFiche"));
//        colMoisFiche.setCellValueFactory(new PropertyValueFactory<Loueur,Integer>("moisAnnee"));
//        colNomVisiteur.setCellValueFactory(new PropertyValueFactory<Loueur,String>("nomPrenomUtilisateur"));
//        colEtatFiche.setCellValueFactory(new PropertyValueFactory<Loueur,String>("etatLong"));

        tableListeFichesComptable.setItems(data);

    }



    /**
     * Fermeture de la vue
     * @param e
     */
    public void buttonCloseListeFichesComptableClick(ActionEvent e) {

        Stage stage = (Stage) closeButtonListeFichesComptable.getScene().getWindow();
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
