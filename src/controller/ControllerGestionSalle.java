package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.DAO.LieuDAO;
import model.DAO.SalleDAO;
import model.DTO.Lieu;
import model.DTO.LigneFrais;
import model.DTO.Salle;

import java.io.IOException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ControllerGestionSalle {

    @FXML	private Label nomLieu;

    @FXML private TableView<Salle> tableSalles;
    @FXML private TableColumn<Salle, String> colIdLieuS;
    @FXML private TableColumn<Salle, String> colNomSalle;
    @FXML private TableColumn<Salle, Integer> colLargeur;
    @FXML private TableColumn<Salle, Integer> colLongueur;
    @FXML private TableColumn<Salle, Integer> colSurface;
    @FXML private TableColumn<Salle, Integer> colHauteur;
    @FXML private TableColumn<Salle, Integer> colCapacite;
    @FXML private TableColumn<Salle, Double> colTarif;
    @FXML private TableColumn<Salle, String> colIdSalle;

    private Lieu lieuActif;

    private ObservableList<Salle> data = FXCollections.observableArrayList();

    private void remplissagetableViewSalle(Lieu unLieu) {
        try {

            ResultSet rsSalles = SalleDAO.lesSalle(unLieu.getIdLieu());

            rsSalles.beforeFirst();
            while (rsSalles.next()) {

                Salle theSalle = new Salle(rsSalles.getString(1),rsSalles.getString(2),rsSalles.getString(9), rsSalles.getInt(3), rsSalles.getInt(4)
                        ,rsSalles.getInt(5),rsSalles.getInt(6),rsSalles.getInt(7), rsSalles.getDouble("tarifDemiJournee"));

                data.add(theSalle);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        colIdLieuS.setCellValueFactory(new PropertyValueFactory<Salle, String>("idLieu"));
        colNomSalle.setCellValueFactory(new PropertyValueFactory<Salle, String>("nomSalle"));
        colLargeur.setCellValueFactory(new PropertyValueFactory<Salle, Integer>("largeur"));
        colLongueur.setCellValueFactory(new PropertyValueFactory<Salle, Integer>("longueur"));
        colSurface.setCellValueFactory(new PropertyValueFactory<Salle, Integer>("surface"));
        colHauteur.setCellValueFactory(new PropertyValueFactory<Salle, Integer>("hauteur"));
        colCapacite.setCellValueFactory(new PropertyValueFactory<Salle, Integer>("capacite"));

        colTarif.setCellValueFactory(new PropertyValueFactory<Salle, Double>("tarifDemiJournee"));
        colIdSalle.setCellValueFactory(new PropertyValueFactory<Salle, String>("idSalle"));

        tableSalles.setItems(data);
    }

    private void remplissagetableViewSalles(Lieu unLieu) {
        try {

            ArrayList<Salle> lesSalles = new ArrayList<>();

            lesSalles = SalleDAO.lesSalles(unLieu.getIdLieu());

            for (Salle derSalle : lesSalles) {
                Salle theSalle = new Salle(derSalle.getIdSalle(),derSalle.getNomSalle(),derSalle.getIdLieu(), derSalle.getLargeur(), derSalle.getLongueur()
                        ,derSalle.getSurface(),derSalle.getHauteur(), derSalle.getCapacite(), derSalle.getTarifDemiJournee());

                data.add(theSalle);
            }



        }
        catch (Exception e) {
            e.printStackTrace();
        }

        colIdLieuS.setCellValueFactory(new PropertyValueFactory<Salle, String>("idLieu"));
        colNomSalle.setCellValueFactory(new PropertyValueFactory<Salle, String>("nomSalle"));
        colLargeur.setCellValueFactory(new PropertyValueFactory<Salle, Integer>("largeur"));
        colLongueur.setCellValueFactory(new PropertyValueFactory<Salle, Integer>("longueur"));
        colSurface.setCellValueFactory(new PropertyValueFactory<Salle, Integer>("surface"));
        colHauteur.setCellValueFactory(new PropertyValueFactory<Salle, Integer>("hauteur"));
        colCapacite.setCellValueFactory(new PropertyValueFactory<Salle, Integer>("capacite"));

        colTarif.setCellValueFactory(new PropertyValueFactory<Salle, Double>("tarifDemiJournee"));
        colIdSalle.setCellValueFactory(new PropertyValueFactory<Salle, String>("idSalle"));

        tableSalles.setItems(data);
    }

    public void transfertFunction(Lieu unLieu) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        nomLieu.setText("Le nom du lieu : " +unLieu.getLibelleLieu());
//        nomPrenomLabel.setText(uneFiche.getNomPrenomUtilisateur());
//        adresseVisiteurLabel.setText(uneFiche.getUtilisateur().getAdresse());
//        cpVilleVisiteurLabel.setText(uneFiche.getUtilisateur().getCPVille());
//        dateEmbaucheLabel.setText("Date d'embauche : "+ dateFormat.format(uneFiche.getUtilisateur().getDateEmbauche()));
//        if (uneFiche.getDateCloture()!=null) {
//            dateClotureLabel.setText("Date cl�ture : "+ dateFormat.format(uneFiche.getDateCloture()));
//        }
//        else {
//            dateClotureLabel.setText("date cl�ture : ");
//        }
//        etatLabel.setText("Etat : "+ uneFiche.getEtatLong());
//        montantDeclareLabel.setText("Montant d�clar� : "+ String.format("%.2f", uneFiche.getMontantDeclare())+ " �");

        if(unLieu.getIdLieu()!=null) {

            remplissagetableViewSalles(unLieu);

        }

        lieuActif = unLieu;

    }

    @FXML private void supprimerSalleClick(ActionEvent e){
        String id = tableSalles.getSelectionModel().getSelectedItem().getIdSalle();

        if(id!=null){
            SalleDAO.supprimerSalle(id);
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Selectionnez une salle");
            alert.getDialogPane().setContentText("Vous devez selectionner une salle afin de pouvoir la supprimer");
            alert.showAndWait();
        }
    }

    private void viderTableView(){
        tableSalles.getItems().clear();
    }

    @FXML private void rafraichirClick(ActionEvent e){
        viderTableView();
        remplissagetableViewSalles(lieuActif);
    }

    @FXML	private void ajouterSalleClick(ActionEvent e) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../view/viewAjouterSalle.fxml"));

            Parent ajouterSalleLayout = (Parent) loader.load();

            ControllerAjouterSalle setController = loader.getController();

            setController.transfertFunction(lieuActif);

            Stage ajouterSalleStage = new Stage();

            ajouterSalleStage.setScene(new Scene(ajouterSalleLayout));
            ajouterSalleStage.setTitle("Ajouter une salle");
            ajouterSalleStage.initModality(Modality.APPLICATION_MODAL);
            ajouterSalleStage.show();
        }catch (IOException e1) {
            e1.printStackTrace();
        }

    }
}
