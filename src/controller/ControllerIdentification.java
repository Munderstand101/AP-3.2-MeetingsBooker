package controller;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.IOException;
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
import javafx.stage.Window;
import model.DAO.DBConnex;
import model.Settings;


public class ControllerIdentification implements Initializable {
	

	/**
	 * Les variables du fichier FXML associ�
	 */
	@FXML private Label messageConnexionLabel;
	@FXML private TextField serveurTextField;
	@FXML private TextField portTextField;
	@FXML private TextField loginTextField;
	@FXML private PasswordField mdpPasswordField;
	@FXML private Button btnValiderIdentification;


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

			 if(rs.getNString("statut").equals("commerciaux") || rs.getNString("statut").equals("administrateur") ) {
//			 		loader.setLocation(Main.class.getResource("../view/viewListeFichesClients.fxml"));
			 		loader.setLocation(Main.class.getResource("../view/viewMenuComerciaux.fxml"));
			 		Pane comptableListeFichesLayout = (Pane) loader.load();
	            	Stage comptableListeFichesStage = new Stage();
			 		Scene comptableListeFichesScene = new Scene(comptableListeFichesLayout);
			 		comptableListeFichesStage.setScene(comptableListeFichesScene);
	           		
			 		comptableListeFichesStage.setTitle("MeetingsBooker - commerciaux");
			 		comptableListeFichesStage.initModality(Modality.APPLICATION_MODAL);		 		
			 		comptableListeFichesStage.show();

			 }

				if(rs.getNString("statut").equals("gerant")) {
					loader.setLocation(Main.class.getResource("../view/viewLieux.fxml"));
					Pane lieuxLayout = (Pane) loader.load();
					Stage lieuxStage = new Stage();
					Scene lieuxScene = new Scene(lieuxLayout);
					lieuxStage.setScene(lieuxScene);

					lieuxStage.setTitle("GSB Gestion des frais - visiteur");
					lieuxStage.initModality(Modality.APPLICATION_MODAL);
					lieuxStage.show();
				}


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
	@FXML	protected void buttonOuvrirLaConfigurationClick(ActionEvent event) {


		try {
			FXMLLoader loader = new FXMLLoader();
			;
			Stage configurationStage = new Stage();

			loader.setLocation(Main.class.getResource("../view/viewConfiguration.fxml"));
			Pane configurationLayout = (Pane) loader.load();
			Scene configurationScene = new Scene(configurationLayout);
			configurationStage.setScene(configurationScene);

			configurationStage.setTitle("MeetingsBooker - configuration");
			configurationStage.initModality(Modality.APPLICATION_MODAL);
			configurationStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}



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
		//loginTextField.setText("valentin");
		//mdpPasswordField.setText("valentin");

		Settings.db_host = "localhost:3306";
		Settings.db_name = "meetingsBooker";
		Settings.db_user = "root";
		Settings.db_password = "";
	}



}
