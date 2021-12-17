package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.DAO.SalleDAO;
import model.DTO.Lieu;
import model.DTO.LigneFrais;
import model.DTO.Salle;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;

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

    private void remplissagetableViewSalles(Lieu unLieu) {
        try {

            ResultSet rsSalles = SalleDAO.lesSalles(unLieu.getIdLieu());

            rsSalles.beforeFirst();
            while (rsSalles.next()) {

                Salle theSalle = new Salle(rsSalles.getString(1),rsSalles.getString(2),rsSalles.getString(9), rsSalles.getInt(3), rsSalles.getInt(4)
                        ,rsSalles.getInt(5),rsSalles.getInt(6),rsSalles.getInt(7), rsSalles.getFloat(8));

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

        if(unLieu.getIdLieu()!=null) { //uneFiche.nbLignes()>0

            remplissagetableViewSalles(unLieu);



//            for(LigneFrais uneLigne :uneFiche.getLesLignes() ) {
//                dataLignes.add(uneLigne);
//            }
//
//            colLibelleTypeFrais.setCellValueFactory(new PropertyValueFactory<LigneFrais,String>("libelle"));
//            colTarifTypeFrais.setCellValueFactory(new PropertyValueFactory<LigneFrais,Float>("tarif"));
//            colQuantiteDeclaree.setCellValueFactory(new PropertyValueFactory<LigneFrais,Integer>("quantiteDeclaree"));
//            colTotalDeclaree.setCellValueFactory(new PropertyValueFactory<LigneFrais,Float>("montant"));
//
//            tableDetailFicheComptable.setItems(dataLignes);


        }

        lieuActif = unLieu;

    }
}
