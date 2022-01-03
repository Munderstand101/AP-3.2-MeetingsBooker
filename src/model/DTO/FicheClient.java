package model.DTO;

public class FicheClient {
    private String idLoueur;
    private String idEntreprise;
    private String nomEntreprise;
    private String adresseEntreprise;
    private String vilePays;
    private String telEntreprise;
    private String emailEntreprise;
    private String nomPrenomContact;
    private Boolean etatContact;
    private String mailContact;
    private String telContact;

    public FicheClient(String idLoueur, String idEntreprise, String nomEntreprise, String adresseEntreprise, String vilePays, String telEntreprise, String emailEntreprise, String nomPrenomContact, Boolean etatContact, String mailContact, String telContact) {
        this.idLoueur = idLoueur;
        this.idEntreprise = idEntreprise;
        this.nomEntreprise = nomEntreprise;
        this.adresseEntreprise = adresseEntreprise;
        this.vilePays = vilePays;
        this.telEntreprise = telEntreprise;
        this.emailEntreprise = emailEntreprise;
        this.nomPrenomContact = nomPrenomContact;
        this.etatContact = etatContact;
        this.mailContact = mailContact;
        this.telContact = telContact;
    }

    public String getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(String idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public String getIdLoueur() {
        return idLoueur;
    }

    public void setIdLoueur(String idLoueur) {
        this.idLoueur = idLoueur;
    }

    public String getNomEntreprise() {
        return nomEntreprise;
    }

    public void setNomEntreprise(String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
    }

    public String getAdresseEntreprise() {
        return adresseEntreprise;
    }

    public void setAdresseEntreprise(String adresseEntreprise) {
        this.adresseEntreprise = adresseEntreprise;
    }

    public String getVilePays() {
        return vilePays;
    }

    public void setVilePays(String vilePays) {
        this.vilePays = vilePays;
    }

    public String getTelEntreprise() {
        return telEntreprise;
    }

    public void setTelEntreprise(String telEntreprise) {
        this.telEntreprise = telEntreprise;
    }

    public String getEmailEntreprise() {
        return emailEntreprise;
    }

    public void setEmailEntreprise(String emailEntreprise) {
        this.emailEntreprise = emailEntreprise;
    }

    public String getNomPrenomContact() {
        return nomPrenomContact;
    }

    public void setNomPrenomContact(String nomPrenomContact) {
        this.nomPrenomContact = nomPrenomContact;
    }

    public Boolean getEtatContact() {
        return etatContact;
    }

    public void setEtatContact(Boolean etatContact) {
        this.etatContact = etatContact;
    }

    public String getMailContact() {
        return mailContact;
    }

    public void setMailContact(String mailContact) {
        this.mailContact = mailContact;
    }

    public String getTelContact() {
        return telContact;
    }

    public void setTelContact(String telContact) {
        this.telContact = telContact;
    }
}
