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
			 
			 
			 if(rs.getNString("statut").equals("comptable")) {
			 		loader.setLocation(Main.class.getResource("../view/viewComptableListeFiches.fxml"));
			 		Pane comptableListeFichesLayout = (Pane) loader.load();
	            	Stage comptableListeFichesStage = new Stage();
			 		Scene comptableListeFichesScene = new Scene(comptableListeFichesLayout);
			 		comptableListeFichesStage.setScene(comptableListeFichesScene);
	           		
			 		comptableListeFichesStage.setTitle("GSB Gestion des frais - Compta Fiche de frais");
			 		comptableListeFichesStage.initModality(Modality.APPLICATION_MODAL);		 		
			 		comptableListeFichesStage.show();
			 	}   
			 
			 if(rs.getNString("statut").equals("gestion")) {
			 		loader.setLocation(Main.class.getResource("../view/viewGestionaireListeFiches.fxml"));
			 		Pane comptableListeFichesLayout = (Pane) loader.load();
	            	Stage comptableListeFichesStage = new Stage();
			 		Scene comptableListeFichesScene = new Scene(comptableListeFichesLayout);
			 		comptableListeFichesStage.setScene(comptableListeFichesScene);
	           		
			 		comptableListeFichesStage.setTitle("GSB Gestion des frais - gestion");
			 		comptableListeFichesStage.initModality(Modality.APPLICATION_MODAL);		 		
			 		comptableListeFichesStage.show();
			 	}   
			 
			 if(rs.getNString("statut").equals("visiteur")) {
			 		loader.setLocation(Main.class.getResource("../view/viewVisiteurListeFiches.fxml"));
			 		Pane comptableListeFichesLayout = (Pane) loader.load();
	            	Stage comptableListeFichesStage = new Stage();
			 		Scene comptableListeFichesScene = new Scene(comptableListeFichesLayout);
			 		comptableListeFichesStage.setScene(comptableListeFichesScene);
	           		
			 		comptableListeFichesStage.setTitle("GSB Gestion des frais - visiteur");
			 		comptableListeFichesStage.initModality(Modality.APPLICATION_MODAL);		 		
			 		comptableListeFichesStage.show();
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
	 * Fermeture de l'application associ�e au click sur le boton quitter
	 * @param e
	 */
	@FXML
	protected void quitterIdentificationButton(ActionEvent e) {
		Platform.exit();
		
	}

	/**
	 * Valeurs par d�faut pour la connexion au SGBD
	 * A l'inicilisation du contr�leur 
	 ***/
	@Override
	public void initialize(URL location , ResourceBundle ressources) {
		serveurTextField.setText("127.0.0.1");
		portTextField.setText("3306");
	}
	
	

}
