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
    private ArrayList<FicheFrais> mesFiches;
    

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
        mesFiches = new ArrayList<FicheFrais>();
    }


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getMdp() {
		return mdp;
	}


	public void setMdp(String mdp) {
		this.mdp = mdp;
	}


	public String getCp() {
		return cp;
	}


	public void setCp(String cp) {
		this.cp = cp;
	}


	public ArrayList<FicheFrais> getMesFiches() {
		return mesFiches;
	}


	public void setMesFiches(ArrayList<FicheFrais> mesFiches) {
		this.mesFiches = mesFiches;
	}


	public void setId(String id) {
		this.id = id;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}




    public String getId()
    {
        return id;
    }

    public String getNom()
    {
        return nom;
    }

    public String getPrenom()
    {
        return prenom;
    }

    public String getAdresse()
    {
        return adresse;
    }

    public String getCodePostal()
    {
        return cp;
    }

    public String getVille()
    {
        return ville;
    }

    public Date getDateEmbauche()
    {
        return dateEmbauche;
    }

    public String getNomComplet()
    {
        return  nom + " " + prenom;
    }

    public String getCPVille()
    {
        return cp + " " +  ville;
    }

    public ArrayList<FicheFrais> getFichesDeFrais()
    {
        return mesFiches;
    }
   
    public String getStatut() {
		return statut;
	}


	public void setStatut(String statut) {
		this.statut = statut;
	}
}
	

