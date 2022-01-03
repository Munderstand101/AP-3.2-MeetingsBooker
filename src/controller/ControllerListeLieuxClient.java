package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.DAO.FicheClientDAO;
import model.DAO.ListeLieuxDAO;
import model.DAO.ReservationsLieuxDAO;
import model.DTO.FicheClient;
import model.DTO.ListeLieux;
import model.DTO.ReservationsLieux;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControllerListeLieuxClient implements Initializable {
    public TableView tableListeLieuxParClient;
    public TableColumn colNomEntreprise;
    public TableColumn colLibelleLieu;
    public TableColumn colAdresseLieu;
    public TableColumn colCoordX;
    public TableColumn colCoordY;
    public TableColumn colAnnulationGratuite;
    public TableColumn colNbEtoiles;
    public TableColumn colDescriptif;
    public TableColumn colVilePays;
    public TableView tableListeReservationsParLieu;
    public TableColumn colNomEntreprise1;
    public TableColumn colNomSalle;
    public TableColumn colTarifDemiJournee;
    public TableColumn colDateResa;
    public TableColumn colNbPersonnes;
    public TableColumn colVilePays1;
    public TableColumn colDateDebut;
    public Label labelTotal;


    /**
     * Remplissage le la tableView "tableListeLieuxParClient"
     */
    private void remplissageLieux(int id) {

        try {
            ObservableList<ListeLieux> data = FXCollections.observableArrayList();

            ArrayList<ListeLieux> lesListeLieux = ListeLieuxDAO.listeLieuxClient(id);

            for(ListeLieux uneListeLieux: lesListeLieux){
                data.add(uneListeLieux);
            }


            colNomEntreprise.setCellValueFactory(new PropertyValueFactory<ListeLieux, String>("nomEntreprise"));
            colLibelleLieu.setCellValueFactory(new PropertyValueFactory<ListeLieux, String>("libelleLieu"));
            colAdresseLieu.setCellValueFactory(new PropertyValueFactory<ListeLieux, String>("adresseLieu"));
            colCoordX.setCellValueFactory(new PropertyValueFactory<ListeLieux, String>("coordX"));
            colCoordY.setCellValueFactory(new PropertyValueFactory<ListeLieux, String>("coordY"));
            colAnnulationGratuite.setCellValueFactory(new PropertyValueFactory<ListeLieux, String>("annulationGratuite"));
            colNbEtoiles.setCellValueFactory(new PropertyValueFactory<ListeLieux, String>("nbEtoiles"));
            colDescriptif.setCellValueFactory(new PropertyValueFactory<ListeLieux, String>("descriptif"));
            colVilePays.setCellValueFactory(new PropertyValueFactory<ListeLieux, String>("vilePays"));

            tableListeLieuxParClient.setItems(data);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * Remplissage le la tableView "tableListeLieuxParClient"
     */
    private void remplissageReservationsLieux(int id, int idEntreprise) {
        try {
            ObservableList<ReservationsLieux> data = FXCollections.observableArrayList();

            ArrayList<ReservationsLieux> lesReservationsLieux = ReservationsLieuxDAO.lesReservationsLieux(id, idEntreprise);

            for(ReservationsLieux uneReservationsLieux: lesReservationsLieux){
                data.add(uneReservationsLieux);
            }

            colNomEntreprise1.setCellValueFactory(new PropertyValueFactory<ReservationsLieux, String>("nomEntreprise"));
            colNomSalle.setCellValueFactory(new PropertyValueFactory<ReservationsLieux, String>("nomSalle"));
            colTarifDemiJournee.setCellValueFactory(new PropertyValueFactory<ReservationsLieux, String>("tarifDemiJournee"));
            colDateResa.setCellValueFactory(new PropertyValueFactory<ReservationsLieux, String>("dateResa"));
            colNbPersonnes.setCellValueFactory(new PropertyValueFactory<ReservationsLieux, String>("nbPersonnes"));
            colVilePays1.setCellValueFactory(new PropertyValueFactory<ReservationsLieux, String>("vilePays"));
            colDateDebut.setCellValueFactory(new PropertyValueFactory<ReservationsLieux, String>("dateDebut"));


            tableListeReservationsParLieu.setItems(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       // remplissageLieux();

        //remplissagedes reservations par Lieux
        tableListeLieuxParClient.getSelectionModel().selectedIndexProperty().addListener(observable -> {
            int index = tableListeLieuxParClient.getSelectionModel().getSelectedIndex();

            if(index >= 0) {
                ListeLieux uneFiche = (ListeLieux) tableListeLieuxParClient.getSelectionModel().getSelectedItem();

                tableListeReservationsParLieu.getItems().clear();
                remplissageReservationsLieux(Integer.parseInt(uneFiche.getIdLieu()), Integer.parseInt(uneFiche.getIdEntreprise()));
            }
        });
    }

    public void transfertFunction(FicheClient uneFiche) {
        remplissageLieux(Integer.parseInt(uneFiche.getIdEntreprise()));
        labelTotal.setText("Total : "+ReservationsLieuxDAO.totalReservClient(Integer.parseInt(uneFiche.getIdEntreprise())));
    }
}
