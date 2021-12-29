package model.DTO;

public class Lieu {

    private String idVille;
    private String idEntreprise;

    private String idLieu;
    private String libelleLieu;
    private String adresseLieu;

    private int annulationGratuite;
    private String nbEtoiles;
    private String descriptif;

    private Double coordx;
    private Double coordy;

    public Lieu(String pidVille, String pidLieu, String plibelleLieu, String padresseLieu, String pdescriptif, String pidEntreprise){
        this.idVille=pidVille;
        this.idLieu=pidLieu;
        this.libelleLieu=plibelleLieu;
        this.adresseLieu=padresseLieu;
        this.descriptif=pdescriptif;
        this.idEntreprise=pidEntreprise;
    }

    public Lieu(String pidVille, String pidLieu, String plibelleLieu, String padresseLieu, String pdescriptif,
                String pidEntreprise, int pannulation, String pnbEtoiles, Double pcoordx, Double pcoordy ){
        this.idVille=pidVille;
        this.idLieu=pidLieu;
        this.libelleLieu=plibelleLieu;
        this.adresseLieu=padresseLieu;
        this.descriptif=pdescriptif;
        this.idEntreprise=pidEntreprise;
        this.annulationGratuite=pannulation;
        this.nbEtoiles=pnbEtoiles;
        this.coordx=pcoordx;
        this.coordy=pcoordy;
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

    public int getAnnulationGratuite() {
        return annulationGratuite;
    }

    public void setAnnulationGratuite(int annulationGratuite) {
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

    public String getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(String idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public Double getCoordx() {
        return coordx;
    }

    public void setCoordx(Double coordx) {
        this.coordx = coordx;
    }

    public Double getCoordy() {
        return coordy;
    }

    public void setCoordy(Double coordy) {
        this.coordy = coordy;
    }
}
