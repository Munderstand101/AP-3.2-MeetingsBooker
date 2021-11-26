package controller;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import application.Main;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.DAO.DBConnex;


public class ControllerIdentification implements Initializable {
	

	/**
	 * Les variables du fichier FXML associ�
	 */
	@FXML private Label messageConnexionLabel;
	@FXML private TextField serveurTextField;
	@FXML private TextField portTextField;
	@FXML private TextField loginTextField;
	@FXML private PasswordField mdpPasswordField;
	
	
	/**
	 * Methode associee a l'evenement click sur le bouton valider
	 * @param e
	 */
	@FXML	protected void buttonValiderIdentificationClick(ActionEvent e) {
			
		//Appel de la m�tode statique authentification de la classe DBConnex
		//En param�tre le login et mdp saisis et la d�claration de connexion.
		//Le ResultSet r�cup�re la r�ponse du serveur SGBD.
		ResultSet rs = DBConnex.authentification(loginTextField.getText() , mdpPasswordField.getText(), DBConnex.connexion() );
		
		
		//Traitement de la r�ponse du SGBD
		//Chargement des diff�rentes vues en fonction du statut de la personne authentifi�e.
		try {
	
			if(rs != null) {
				
				
			 FXMLLoader loader = new FXMLLoader();
			 messageConnexionLabel.setText("");
			 

			 /*
			 TODO
			 COMMERCIAL
			 commerciaux et administrateur
			 commercial
			 ControllerClientsFiche
ControllerFicheClient

viewClientsFiche
			  */

			 if(rs.getNString("statut").equals("commerciaux") || rs.getNString("statut").equals("administrateur") ) {
			 		loader.setLocation(Main.class.getResource("../view/viewListeFichesClients.fxml"));
			 		Pane comptableListeFichesLayout = (Pane) loader.load();
	            	Stage comptableListeFichesStage = new Stage();
			 		Scene comptableListeFichesScene = new Scene(comptableListeFichesLayout);
			 		comptableListeFichesStage.setScene(comptableListeFichesScene);
	           		
			 		comptableListeFichesStage.setTitle("MeetingsBooker - commerciaux");
			 		comptableListeFichesStage.initModality(Modality.APPLICATION_MODAL);		 		
			 		comptableListeFichesStage.show();
			 	}   
/*
			 if(rs.getNString("statut").equals("loueurs") || rs.getNString("statut").equals("administrateur")) {
			 		loader.setLocation(Main.class.getResource("../view/viewLoueurs.fxml"));
			 		Pane comptableListeFichesLayout = (Pane) loader.load();
	            	Stage comptableListeFichesStage = new Stage();
			 		Scene comptableListeFichesScene = new Scene(comptableListeFichesLayout);
			 		comptableListeFichesStage.setScene(comptableListeFichesScene);
	           		
			 		comptableListeFichesStage.setTitle("MeetingsBooker - loueurs");
			 		comptableListeFichesStage.initModality(Modality.APPLICATION_MODAL);		 		
			 		comptableListeFichesStage.show();
			 	}   

			 if(rs.getNString("statut").equals("réservants")) {
			 		loader.setLocation(Main.class.getResource("../view/viewRéservants.fxml"));
			 		Pane reservantsLayout = (Pane) loader.load();
	            	Stage reservantsStage = new Stage();
			 		Scene reservantsScene = new Scene(reservantsLayout);
					 reservantsStage.setScene(reservantsScene);

					 reservantsStage.setTitle("MeetingsBooker - réservants");
					 reservantsStage.initModality(Modality.APPLICATION_MODAL);
					 reservantsStage.show();
			 	}   
*/
			 
			 
			}
			else {
				messageConnexionLabel.setText("Login ou mot de passe incorrect !");
			}
	        
		} catch(Exception e1) {
			e1.printStackTrace();
		}
		
			
	}

	/**
	 * Methode associee a l'evenement click sur le bouton valider
	 * @param e
	 */
	@FXML	protected void buttonOuvrirLaConfigurationClick(ActionEvent e) {

	/*	FXMLLoader loader = new FXMLLoader();

		loader.setLocation(Main.class.getResource("../view/viewConfiguration.fxml"));
		Pane configurationLayout = (Pane) loader.load();
		Stage configurationStage = new Stage();
		Scene configurationScene = new Scene(configurationLayout);
		configurationStage.setScene(configurationScene);

		configurationStage.setTitle("MeetingsBooker - configuration");
		configurationStage.initModality(Modality.APPLICATION_MODAL);
		configurationStage.show();*/

	}


	/**
	 * Fermeture de l'application associée au clic sur le bouton quitter
	 * @param e
	 */
	@FXML
	protected void buttonQuitterIdentificationClick(ActionEvent e) {
		Platform.exit();
	}

	/**
	 * Valeurs par défaut pour la connexion au SGBD
	 * A l'initialisation du controleur
	 ***/
	@Override
	public void initialize(URL location , ResourceBundle ressources) {
//		serveurTextField.setText("127.0.0.1");
//		portTextField.setText("3306");
	}
	
	

}
