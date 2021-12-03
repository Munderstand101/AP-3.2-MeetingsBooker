package model.DTO;

import java.sql.Date;
import java.util.ArrayList;

public class Loueur {


    private int idLoueur;
    private int IdEntreprise;
    private String Nom;
    private String Prenom;
    private Boolean contact;
    private String telContact;
    private String mailContact;
    private Utilisateur user;
    private Entreprise entreprise;

    public Loueur(int idLoueur, int idEntreprise, String nom, String prenom, Boolean contact, String telContact, String mailContact, Utilisateur user, Entreprise entreprise) {
        this.idLoueur = idLoueur;
        this.IdEntreprise = idEntreprise;
        this.Nom = nom;
        this.Prenom = prenom;
        this.contact = contact;
        this.telContact = telContact;
        this.mailContact = mailContact;
        this.user = user;
        this.entreprise = entreprise;
    }

    public Boolean getContact() {
        return contact;
    }

    public void setContact(Boolean contact) {
        this.contact = contact;
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
