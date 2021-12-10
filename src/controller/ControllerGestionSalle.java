package controller;

import javafx.scene.control.cell.PropertyValueFactory;
import model.DTO.FicheFrais;
import model.DTO.LigneFrais;

import java.text.SimpleDateFormat;

public class ControllerGestionSalle {




    public void transfertFunction(Lieu unLieu) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        numFicheLabel.setText("Fiche de frais n� " +uneFiche.getIdFiche() + " - " + uneFiche.getMoisLettre() +  " " + uneFiche.getAnnee());
        nomPrenomLabel.setText(uneFiche.getNomPrenomUtilisateur());
        adresseVisiteurLabel.setText(uneFiche.getUtilisateur().getAdresse());
        cpVilleVisiteurLabel.setText(uneFiche.getUtilisateur().getCPVille());
        dateEmbaucheLabel.setText("Date d'embauche : "+ dateFormat.format(uneFiche.getUtilisateur().getDateEmbauche()));
        if (uneFiche.getDateCloture()!=null) {
            dateClotureLabel.setText("Date cl�ture : "+ dateFormat.format(uneFiche.getDateCloture()));
        }
        else {
            dateClotureLabel.setText("date cl�ture : ");
        }
        etatLabel.setText("Etat : "+ uneFiche.getEtatLong());
        montantDeclareLabel.setText("Montant d�clar� : "+ String.format("%.2f", uneFiche.getMontantDeclare())+ " �");

        if(uneFiche.nbLignes()>0) {



            for(LigneFrais uneLigne :uneFiche.getLesLignes() ) {
                dataLignes.add(uneLigne);
            }

            colLibelleTypeFrais.setCellValueFactory(new PropertyValueFactory<LigneFrais,String>("libelle"));
            colTarifTypeFrais.setCellValueFactory(new PropertyValueFactory<LigneFrais,Float>("tarif"));
            colQuantiteDeclaree.setCellValueFactory(new PropertyValueFactory<LigneFrais,Integer>("quantiteDeclaree"));
            colTotalDeclaree.setCellValueFactory(new PropertyValueFactory<LigneFrais,Float>("montant"));

            tableDetailFicheComptable.setItems(dataLignes);


        }

        ficheActive = uneFiche;

    }
}
