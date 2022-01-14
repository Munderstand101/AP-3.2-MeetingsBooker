package controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.DAO.LieuDAO;
import model.DAO.ReservationDAO;
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
    @FXML private TableColumn<Lieu, Double> colCoordx;
    @FXML private TableColumn<Lieu, Double> colCoordy;
    @FXML private TableColumn<Lieu, Integer> colAnnul;
    @FXML private TableColumn<Lieu, Integer> colNbEtoiles;

    @FXML private Label lblResaMois;
    @FXML private Label lblResaAnn;
    @FXML private Label lblCAMois;
    @FXML private Label lblCAAnn;


    @FXML private Button btnAjtLieu;

    @FXML private Button btnSupprLieu;

    @FXML private Button btnRafraichir;

    @FXML private Button btnGestionSalle;

    @FXML private ComboBox cmbBilResMois;

    @FXML private ComboBox cmbBilResAnn;

    @FXML private ComboBox cmbCAMois;

    @FXML private ComboBox cmbCAAnn;





    private ObservableList<Lieu> data = FXCollections.observableArrayList();

    private ObservableList<Integer> moisR = FXCollections.observableArrayList();

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
                    , derLieu.getDescriptif(), derLieu.getIdEntreprise(), derLieu.getAnnulationGratuite(),
                        derLieu.getNbEtoiles(), derLieu.getCoordx(), derLieu.getCoordy());

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

        colAnnul.setCellValueFactory(new PropertyValueFactory<Lieu, Integer>("annulationGratuite"));
        colNbEtoiles.setCellValueFactory(new PropertyValueFactory<Lieu, Integer>("nbEtoiles"));
        //colCoordx.setCellValueFactory(new PropertyValueFactory<Lieu, Double>("coordX"));
        //colCoordy.setCellValueFactory(new PropertyValueFactory<Lieu, Double>("coordY"));

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
            alert.setHeaderText("Selectionnez un Lieu");
            alert.getDialogPane().setContentText("Vous devez selectionner un lieu afin gerer ses salles");
            alert.showAndWait();
        }
   }



    @FXML	private void buttonAjouterLieuClick(ActionEvent e) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../view/viewAjouterLieu.fxml"));

            Parent ajouterLieuLayout = (Parent) loader.load();

            ControllerAjouterLieu setController = loader.getController();

            Stage ajouterLieuStage = new Stage();

            ajouterLieuStage.setScene(new Scene(ajouterLieuLayout));
            ajouterLieuStage.setTitle("Ajouter un Lieu");
            ajouterLieuStage.initModality(Modality.APPLICATION_MODAL);
            ajouterLieuStage.show();
        }catch (IOException e1) {
            e1.printStackTrace();
        }

    }

    private void viderTableView(){
        tableLieux.getItems().clear();
    }

    @FXML private void rafraichirClick(ActionEvent e){
        viderTableView();
        remplissagetableViewLieux();
    }

    @FXML private void supprimerLieuClick(ActionEvent e){
        String id = tableLieux.getSelectionModel().getSelectedItem().getIdLieu();

        if(id!=null){
            LieuDAO.supprimerLieu(id);
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Selectionnez un Lieu");
            alert.getDialogPane().setContentText("Vous devez selectionner un lieu afin de pouvoir le supprimer");
            alert.showAndWait();
        }
    }

    @FXML private void bilResaMoisClick(ActionEvent e){
        int index = tableLieux.getSelectionModel().getSelectedIndex();

        if(index >= 0) {


            Lieu unLieu = tableLieux.getSelectionModel().getSelectedItem();

            int mois = cmbBilResMois.getSelectionModel().getSelectedIndex();



            int item = ReservationDAO.nbReservationM(unLieu.getIdLieu(), mois+1);

            lblResaMois.setText("Nombre de reservations : " + String.valueOf(item));


        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Selectionnez un Lieu");
            alert.getDialogPane().setContentText("Vous devez selectionner un lieu afin d'affcher son nombre de reservations");
            alert.showAndWait();
        }
    }

    @FXML private void bilResaAnnClick(ActionEvent e){
        int index = tableLieux.getSelectionModel().getSelectedIndex();

        if(index >= 0) {


            Lieu unLieu = tableLieux.getSelectionModel().getSelectedItem();

            int annee = (int) cmbBilResAnn.getSelectionModel().getSelectedItem();



            int item = ReservationDAO.nbReservationA(unLieu.getIdLieu(), annee);

            lblResaAnn.setText("Nombre de reservations : " + String.valueOf(item));



        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Selectionnez un Lieu");
            alert.getDialogPane().setContentText("Vous devez selectionner un lieu afin d'affcher son nombre de reservations");
            alert.showAndWait();
        }
    }

    @FXML private void bilCAMoisClick(ActionEvent e){
        int index = tableLieux.getSelectionModel().getSelectedIndex();

        if(index >= 0) {


            Lieu unLieu = tableLieux.getSelectionModel().getSelectedItem();

            int mois = cmbCAMois.getSelectionModel().getSelectedIndex();



            Double item = ReservationDAO.caReservationM(unLieu.getIdLieu(), mois+1);

            lblCAMois.setText("Chiffre d'affaire du lieu : " + String.valueOf(item));


        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Selectionnez un Lieu");
            alert.getDialogPane().setContentText("Vous devez selectionner un lieu afin d'afficher son chiffre d'affaire");
            alert.showAndWait();
        }
    }

    @FXML private void bilCAAnnClick(ActionEvent e){
        int index = tableLieux.getSelectionModel().getSelectedIndex();

        if(index >= 0) {


            Lieu unLieu = tableLieux.getSelectionModel().getSelectedItem();

            int annee = (int) cmbCAAnn.getSelectionModel().getSelectedItem();



            Double item = ReservationDAO.caReservationA(unLieu.getIdLieu(), annee);

            lblCAAnn.setText("Chiffre d'affaire du lieu : " + String.valueOf(item));


        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Selectionnez un Lieu");
            alert.getDialogPane().setContentText("Vous devez selectionner un lieu afin d'afficher son chiffre d'affaire");
            alert.showAndWait();
        }
    }

    @FXML private void modifierLieuClick(ActionEvent e){

        int index = tableLieux.getSelectionModel().getSelectedIndex();


        if(index >= 0) {

            Lieu unLieu = tableLieux.getSelectionModel().getSelectedItem();
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("../view/viewModifierLieu.fxml"));

                Parent modifierLieuLayout = (Parent) loader.load();

                ControllerModifierLieu setController = loader.getController();

                setController.transfertFunction(unLieu);

                Stage modifierLieuStage = new Stage();

                modifierLieuStage.setScene(new Scene(modifierLieuLayout));
                modifierLieuStage.setTitle("Modifier un Lieu");
                modifierLieuStage.initModality(Modality.APPLICATION_MODAL);
                modifierLieuStage.show();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Selectionnez un Lieu");
            alert.getDialogPane().setContentText("Vous devez selectionner un lieu afin de le modifier");
            alert.showAndWait();
        }
    }


    public void initialize() {


        remplissagetableViewLieux();

        cmbBilResMois.getItems().addAll("Janvier","Fevrier","Mars","Avril","Mai","Juin","Juillet","Aout","Septembre","Octobre","Novembre","Decembre");
        cmbBilResAnn.getItems().addAll(2019,2020,2021,2022,2023,2024,2025,2026,2027,2028,2029,2030);
        cmbCAMois.getItems().addAll("Janvier","Fevrier","Mars","Avril","Mai","Juin","Juillet","Aout","Septembre","Octobre","Novembre","Decembre");
        cmbCAAnn.getItems().addAll(2019,2020,2021,2022,2023,2024,2025,2026,2027,2028,2029,2030);
    }


}
