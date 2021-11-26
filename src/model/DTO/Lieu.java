package model.DTO;

public class Lieu {

    private String idVille;

    private String idLieu;
    private String libelleLieu;
    private String adresseLieu;

    private boolean annulationGratuite;
    private String nbEtoiles;
    private String descriptif;

    public Lieu(String pidVille, String pidLieu, String plibelleLieu, String padresseLieu, String pdescriptif){
        this.idVille=pidVille;
        this.idLieu=pidLieu;
        this.libelleLieu=plibelleLieu;
        this.adresseLieu=padresseLieu;
        this.descriptif=pdescriptif;
    }

    public String getIdVille() {
        return idVille;
    }

    public void setIdVille(String idVille) {
        this.idVille = idVille;
    }

    public String getIdLieu() {
        return idLieu;
    }

    public void setIdLieu(String idLieu) {
        this.idLieu = idLieu;
    }

    public String getLibelleLieu() {
        return libelleLieu;
    }

    public void setLibelleLieu(String libelleLieu) {
        this.libelleLieu = libelleLieu;
    }

    public String getAdresseLieu() {
        return adresseLieu;
    }

    public void setAdresseLieu(String adresseLieu) {
        this.adresseLieu = adresseLieu;
    }

    public boolean isAnnulationGratuite() {
        return annulationGratuite;
    }

    public void setAnnulationGratuite(boolean annulationGratuite) {
        this.annulationGratuite = annulationGratuite;
    }

    public String getNbEtoiles() {
        return nbEtoiles;
    }

    public void setNbEtoiles(String nbEtoiles) {
        this.nbEtoiles = nbEtoiles;
    }

    public String getDescriptif() {
        return descriptif;
    }

    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }
}
