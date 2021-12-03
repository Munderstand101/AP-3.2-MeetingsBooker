package model.DTO;

public class FicheClient {
    private String nomEntreprise;
    private String adresseEntreprise;
    private String vilePays;
    private String telEntreprise;
    private String emailEntreprise;
    private String nomPrenomContact;
    private String mailContact;
    private String telContact;

    public FicheClient(String nomEntreprise, String adresseEntreprise, String vilePays, String telEntreprise, String emailEntreprise, String nomPrenomContact, String mailContact, String telContact) {
        this.nomEntreprise = nomEntreprise;
        this.adresseEntreprise = adresseEntreprise;
        this.vilePays = vilePays;
        this.telEntreprise = telEntreprise;
        this.emailEntreprise = emailEntreprise;
        this.nomPrenomContact = nomPrenomContact;
        this.mailContact = mailContact;
        this.telContact = telContact;
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
