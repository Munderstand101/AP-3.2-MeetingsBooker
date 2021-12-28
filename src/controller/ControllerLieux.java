package controller;

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
import model.DAO.LieuDAO;
import model.DAO.UtilisateurDAO;
import model.DTO.*;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ControllerLieux {


    @FXML private TableView<Lieu> tableLieux;
    @FXML private TableColumn<Lieu, Integer> colIdVille;
    @FXML private TableColumn<Lieu, Integer> colIdLieu;
    @FXML private TableColumn<Lieu, Integer> colIdEntreprise;
    @FXML private TableColumn<Lieu, String> colLibelleLieu;
    @FXML private TableColumn<Lieu, String> colAdresseLieu;
    @FXML private TableColumn<Lieu, String> colDescriptifLieu;

    @FXML private Button btnAjtLieu;

    @FXML private Button btnGestionSalle;

//    @FXML private TableView<Salle> tableSalles;
//    @FXML private TableColumn<Salle, Integer> colIdLieuS;
//    @FXML private TableColumn<Salle, String> colNomSalle;
//    @FXML private TableColumn<Salle, Integer> colLargeur;
//    @FXML private TableColumn<Salle, Integer> colLongueur;
//    @FXML private TableColumn<Salle, Integer> colSurface;
//    @FXML private TableColumn<Salle, Integer> colHauteur;
//    @FXML private TableColumn<Salle, Integer> colCapacite;
//    @FXML private TableColumn<Salle, Double> colTarif;
//    @FXML private TableColumn<Salle, Integer> colIdSalle;
//
//    private Lieu lieuActif;

    private ObservableList<Lieu> data = FXCollections.observableArrayList();

    private void remplissagetableViewLieu() {
        try {

            ResultSet rsLieux = LieuDAO.lesLieu();

            rsLieux.beforeFirst();
            while (rsLieux.next()) {

                Lieu thelieu = new Lieu(rsLieux.getString(1),rsLieux.getString(2),rsLieux.getString(3),rsLieux.getString(4)
                        ,rsLieux.getString(5),rsLieux.getString(6));

                data.add(thelieu);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        colIdVille.setCellValueFactory(new PropertyValueFactory<Lieu,Integer>("idVille"));
        colIdEntreprise.setCellValueFactory(new PropertyValueFactory<Lieu,Integer>("idEntreprise"));
        colLibelleLieu.setCellValueFactory(new PropertyValueFactory<Lieu,String>("libelleLieu"));
        colAdresseLieu.setCellValueFactory(new PropertyValueFactory<Lieu,String>("adresseLieu"));
        colDescriptifLieu.setCellValueFactory(new PropertyValueFactory<Lieu,String>("descriptif"));
        colIdLieu.setCellValueFactory(new PropertyValueFactory<Lieu, Integer>("idLieu"));

        tableLieux.setItems(data);
    }

    private void remplissagetableViewLieux() {
        try {
            ArrayList<Lieu> lesLieux = new ArrayList<>();
            lesLieux = LieuDAO.lesLieux();

            for (Lieu derLieu : lesLieux) {

                Lieu thelieu = new Lieu(derLieu.getIdVille(), derLieu.getIdLieu(), derLieu.getLibelleLieu(), derLieu.getAdresseLieu()
                    , derLieu.getDescriptif(), derLieu.getIdEntreprise());

            data.add(thelieu);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        colIdVille.setCellValueFactory(new PropertyValueFactory<Lieu,Integer>("idVille"));
        colIdEntreprise.setCellValueFactory(new PropertyValueFactory<Lieu,Integer>("idEntreprise"));
        colLibelleLieu.setCellValueFactory(new PropertyValueFactory<Lieu,String>("libelleLieu"));
        colAdresseLieu.setCellValueFactory(new PropertyValueFactory<Lieu,String>("adresseLieu"));
        colDescriptifLieu.setCellValueFactory(new PropertyValueFactory<Lieu,String>("descriptif"));
        colIdLieu.setCellValueFactory(new PropertyValueFactory<Lieu, Integer>("idLieu"));

        tableLieux.setItems(data);
    }

   @FXML private void btnOuvrirGestionSalle(ActionEvent e){
        int index = tableLieux.getSelectionModel().getSelectedIndex();


        if(index >= 0) {

            Lieu unLieu = tableLieux.getSelectionModel().getSelectedItem();

            try {

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("../view/viewGestionSalle.fxml"));


                Parent gestionSalleLayout = (Parent) loader.load();

                ControllerGestionSalle setController= loader.getController();

                //appel de la methode de transfert vers le controleur "ControllerComptableFiche"
                setController.transfertFunction(unLieu);

                Stage gestionSalleStage = new Stage();

                gestionSalleStage.setScene(new Scene(gestionSalleLayout));
                gestionSalleStage.setTitle("Gestion des salles");
                gestionSalleStage.initModality(Modality.APPLICATION_MODAL);
                gestionSalleStage.show();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Sélectionnez un Lieu");
            alert.getDialogPane().setContentText("Vous devez sélectionner un lieu afin gérer ses salles");
            alert.showAndWait();
        }
   }

    private void remplissagetableViewSalles(){

    }

    @FXML	private void buttonOuvrirFicheComptableClick(ActionEvent e) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../view/viewAjouterLieu.fxml"));

            Parent ajouterLieuLayout = (Parent) loader.load();

            ControllerAjouterLieu setController = loader.getController();

            Stage ajouterLieuStage = new Stage();

            ajouterLieuStage.setScene(new Scene(ajouterLieuLayout));
            ajouterLieuStage.setTitle("Gestion des salles");
            ajouterLieuStage.initModality(Modality.APPLICATION_MODAL);
            ajouterLieuStage.show();
        }catch (IOException e1) {
            e1.printStackTrace();
        }

    }

    public void buttonAjouterLieuClick(ActionEvent e) {

    }

    public void initialize() {

        remplissagetableViewLieux();
    }


}
