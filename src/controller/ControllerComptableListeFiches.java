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
import model.DAO.FicheFraisDAO;
import model.DAO.UtilisateurDAO;
import model.DTO.FicheFrais;

import model.DTO.LigneFrais;
import model.DTO.Utilisateur;

public class ControllerComptableListeFiches {

	/**
	 * Les variables du fichier FXML associé
	 */
	 @FXML 	private TableView<FicheFrais> tableListeFichesComptable;
	 @FXML 	private TableColumn<FicheFrais , Integer > colIdFiche;
	 @FXML 	private TableColumn<FicheFrais , String > colNomVisiteur;
	 @FXML 	private TableColumn<FicheFrais , Integer > colMoisFiche;
	 @FXML  private TableColumn<FicheFrais , String > colEtatFiche;
	 @FXML  private Button closeButtonListeFichesComptable;
	 
	
	 
	 //Déclaration de l'ObservableList nécessaire au remplissage de la tableView
	 private ObservableList<FicheFrais> data = FXCollections.observableArrayList();
	 
	 
	 /**
	  * Ouverture de la fiche sélectionnée
	  * Click sur le bouton "Ouvrir fiche sélectionnée"
	  * @param e
	  */
		@FXML	private void buttonOuvrirFicheComptableClick(ActionEvent e) {
			
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
				alert.setHeaderText("Sélectionnez une fiche de frais");
				alert.getDialogPane().setContentText("Vous devez sélectionner une fiche de frais afin de la visualiser");
				alert.showAndWait();
			}
		
				 		
		}
	 
	 
			
	 /**
	  * Remplissage le la tableView "liste des fiches de frais"
	  */
	 private void remplissagetableViewListeFichesComptable() {
		 try {
			 			 
			 ResultSet rsListeFichesComptable = FicheFraisDAO.lesFichesFrais();
			 
			
			 ArrayList<LigneFrais> lesLignesFrais;

			 
			 rsListeFichesComptable.beforeFirst();
			 while (rsListeFichesComptable.next()) {
				 
				 
			 
				 ResultSet rsUnVisiteur = UtilisateurDAO.unUtilisateur(rsListeFichesComptable.getString(2));
				 
				 Utilisateur utilisateur = new Utilisateur(rsUnVisiteur.getString(1), rsUnVisiteur.getString(2)  , rsUnVisiteur.getString(3)   , rsUnVisiteur.getString(4)  , rsUnVisiteur.getString(5) , rsUnVisiteur.getString(6) , rsUnVisiteur.getString(7) , rsUnVisiteur.getString(8)  , rsUnVisiteur.getString(9), rsUnVisiteur.getDate(10)) ;
					
				 FicheFrais uneFicheFrais = new FicheFrais(rsListeFichesComptable.getInt(1) ,rsListeFichesComptable.getInt(3) ,rsListeFichesComptable.getInt(4)  ,rsListeFichesComptable.getDate(5)  ,rsListeFichesComptable.getDate(6)  ,rsListeFichesComptable.getString(7) , rsListeFichesComptable.getFloat(8), utilisateur);
				 
				 
				 ResultSet rsLesLignes = FicheFraisDAO.lesLignesFicheFrais(rsListeFichesComptable.getInt(1));
				 
				 
			
				 lesLignesFrais = new ArrayList<LigneFrais>();
				
				 if(rsLesLignes != null){
					
					 rsLesLignes.beforeFirst();
					 while (rsLesLignes.next()) {
						 LigneFrais uneLigneFrais = new LigneFrais(rsLesLignes.getInt(1),rsLesLignes.getString(2) ,rsLesLignes.getInt(3), rsLesLignes.getString(4), rsLesLignes.getFloat(5));
						 lesLignesFrais.add(uneLigneFrais);
					 }
				 }
				 uneFicheFrais.setLesLignes(lesLignesFrais); 
				 
				 
				 data.add(uneFicheFrais);
				 

				 
			 }
			 
			 
			 
		 }
		 catch (Exception e) {
			 e.printStackTrace();
		 }
		 
		 
		colIdFiche.setCellValueFactory(new PropertyValueFactory<FicheFrais,Integer>("idFiche"));
		colMoisFiche.setCellValueFactory(new PropertyValueFactory<FicheFrais,Integer>("moisAnnee"));
		colNomVisiteur.setCellValueFactory(new PropertyValueFactory<FicheFrais,String>("nomPrenomUtilisateur"));
		colEtatFiche.setCellValueFactory(new PropertyValueFactory<FicheFrais,String>("etatLong"));
		
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
