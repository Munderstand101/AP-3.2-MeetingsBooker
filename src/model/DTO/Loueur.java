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
}
