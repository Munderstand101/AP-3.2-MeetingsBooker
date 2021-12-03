package model.DTO;


import java.util.Date;
import java.util.ArrayList;



public class Utilisateur {

	private String id;
    private String nom ;
    private String prenom;
    private String login;
    private String mdp;
    private String statut;
    private String adresse;
    private String cp;
    private String ville;
    private Date dateEmbauche;
    

    public Utilisateur(String unId, String unNom , String unPrenom  , String unLogin , String unMdp , String unStatut ,  String uneAdresse , String unCp , String uneVille , Date uneDateEmb)
    {
        id = unId;
        nom = unNom;
        prenom = unPrenom;
        login = unLogin;
        mdp = unMdp;
        statut = unStatut;
        adresse = uneAdresse;
        cp = unCp;
        ville = uneVille;
        dateEmbauche = uneDateEmb;
    }


}
	

