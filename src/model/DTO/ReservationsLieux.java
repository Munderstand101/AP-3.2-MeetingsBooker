package model.DTO;

public class ReservationsLieux {
    private String idLieu;
    private String libelleLieu;
    private String idResa;
    private String idEntreprise;
    private String nomEntreprise;
    private String nomSalle;
    private String tarifDemiJournee;
    private String dateResa;
    private String nbPersonnes;
    private String vilePays;
    private String dateDebut;

    public ReservationsLieux(String idLieu, String libelleLieu, String idResa, String idEntreprise, String nomEntreprise, String nomSalle, String tarifDemiJournee, String dateResa, String nbPersonnes, String vilePays, String dateDebut) {
        this.idLieu = idLieu;
        this.libelleLieu = libelleLieu;
        this.idResa = idResa;
        this.idEntreprise = idEntreprise;
        this.nomEntreprise = nomEntreprise;
        this.nomSalle = nomSalle;
        this.tarifDemiJournee = tarifDemiJournee;
        this.dateResa = dateResa;
        this.nbPersonnes = nbPersonnes;
        this.vilePays = vilePays;
        this.dateDebut = dateDebut;
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

    public String getIdResa() {
        return idResa;
    }

    public void setIdResa(String idResa) {
        this.idResa = idResa;
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

    public String getNomSalle() {
        return nomSalle;
    }

    public void setNomSalle(String nomSalle) {
        this.nomSalle = nomSalle;
    }

    public String getTarifDemiJournee() {
        return tarifDemiJournee;
    }

    public void setTarifDemiJournee(String tarifDemiJournee) {
        this.tarifDemiJournee = tarifDemiJournee;
    }

    public String getDateResa() {
        return dateResa;
    }

    public void setDateResa(String dateResa) {
        this.dateResa = dateResa;
    }

    public String getNbPersonnes() {
        return nbPersonnes;
    }

    public void setNbPersonnes(String nbPersonnes) {
        this.nbPersonnes = nbPersonnes;
    }

    public String getVilePays() {
        return vilePays;
    }

    public void setVilePays(String vilePays) {
        this.vilePays = vilePays;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }
}
