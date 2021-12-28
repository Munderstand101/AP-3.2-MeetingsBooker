package model.DTO;

public class Salle {

    private String idSalle;
    private String nomSalle;
    private int largeur;
    private int longueur;
    private int surface;
    private int hauteur;
    private int capacite;
    private Double tarifDemiJournee;
    private String idLieu;

    public Salle(String pidSalle, String pnomSalle,String pidLieu, int plargeur, int plongueur, int psurface, int phauteur, int pcapacite, Double ptarifDemiJournee){
        this.idSalle=pidSalle;
        this.nomSalle=pnomSalle;
        this.idLieu=pidLieu;
        this.largeur=plargeur;
        this.longueur=plongueur;
        this.surface=psurface;
        this.hauteur=phauteur;
        this.capacite=pcapacite;
        this.tarifDemiJournee=ptarifDemiJournee;
    }

    public String getIdSalle() {
        return idSalle;
    }

    public void setIdSalle(String idSalle) {
        this.idSalle = idSalle;
    }

    public String getNomSalle() {
        return nomSalle;
    }

    public void setNomSalle(String nomSalle) {
        this.nomSalle = nomSalle;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public int getLongueur() {
        return longueur;
    }

    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }

    public int getSurface() {
        return surface;
    }

    public void setSurface(int surface) {
        this.surface = surface;
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public Double getTarifDemiJournee() {
        return tarifDemiJournee;
    }

    public void setTarifDemiJournee(Double tarifDemiJournee) {
        this.tarifDemiJournee = tarifDemiJournee;
    }

    public String getIdLieu() {
        return idLieu;
    }

    public void setIdLieu(String idLieu) {
        this.idLieu = idLieu;
    }
}
