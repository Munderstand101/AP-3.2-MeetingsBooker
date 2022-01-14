package model.DTO;

public class ListeLieux {
    private String idEntreprise;
    private String nomEntreprise;
    private String idLieu;
    private String libelleLieu;
    private String adresseLieu;
    private String coordX;
    private String coordY;
    private String annulationGratuite;
    private String nbEtoiles;
    private String descriptif;
    private String vilePays;

    public ListeLieux(String idEntreprise, String nomEntreprise, String idLieu, String libelleLieu, String adresseLieu, String coordX, String coordY, String annulationGratuite, String nbEtoiles, String descriptif, String vilePays) {
        this.idEntreprise = idEntreprise;
        this.nomEntreprise = nomEntreprise;
        this.idLieu = idLieu;
        this.libelleLieu = libelleLieu;
        this.adresseLieu = adresseLieu;
        this.coordX = coordX;
        this.coordY = coordY;
        this.annulationGratuite = annulationGratuite;
        this.nbEtoiles = nbEtoiles;
        this.descriptif = descriptif;
        this.vilePays = vilePays;
    }


    public String getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(String idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public String getNomEntreprise() {
        return nomEntreprise;
    }

    public void setNomEntreprise(String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
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

    public String getCoordX() {
        return coordX;
    }

    public void setCoordX(String coordX) {
        this.coordX = coordX;
    }

    public String getCoordY() {
        return coordY;
    }

    public void setCoordY(String coordY) {
        this.coordY = coordY;
    }

    public String getAnnulationGratuite() {
        return annulationGratuite;
    }

    public void setAnnulationGratuite(String annulationGratuite) {
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

    public String getVilePays() {
        return vilePays;
    }

    public void setVilePays(String vilePays) {
        this.vilePays = vilePays;
    }
}
