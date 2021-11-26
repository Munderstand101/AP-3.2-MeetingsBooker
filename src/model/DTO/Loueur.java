package model.DTO;

public class Loueur {


    private int idLoueur;
    private int IdEntreprise;
    private String Nom;
    private String Prenom;
    private boolean contact;
    private String telContact;
    private String mailContact;


    public Loueur(int idLoueur, int idEntreprise, String nom, String prenom, boolean contact, String telContact, String mailContact) {
        this.idLoueur = idLoueur;
        IdEntreprise = idEntreprise;
        Nom = nom;
        Prenom = prenom;
        this.contact = contact;
        this.telContact = telContact;
        this.mailContact = mailContact;
    }

    public int getIdLoueur() {
        return idLoueur;
    }

    public void setIdLoueur(int idLoueur) {
        this.idLoueur = idLoueur;
    }

    public int getIdEntreprise() {
        return IdEntreprise;
    }

    public void setIdEntreprise(int idEntreprise) {
        IdEntreprise = idEntreprise;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public boolean isContact() {
        return contact;
    }

    public void setContact(boolean contact) {
        this.contact = contact;
    }

    public String getTelContact() {
        return telContact;
    }

    public void setTelContact(String telContact) {
        this.telContact = telContact;
    }

    public String getMailContact() {
        return mailContact;
    }

    public void setMailContact(String mailContact) {
        this.mailContact = mailContact;
    }
}
