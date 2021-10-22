package model.DTO;

public class LigneFrais {

	private int idFiche;
    private String idTypeFrais;
    private int quantiteDeclaree;
    private String libelle;
    private float tarif;
    private float montant;
    

    public LigneFrais(int unIdFiche, String unIdTypeFrais, int uneQuantiteDeclaree , String unLibelle , float unTarif)
    {
    	idFiche = unIdFiche;
        idTypeFrais = unIdTypeFrais;
        quantiteDeclaree = uneQuantiteDeclaree;
        libelle = unLibelle;
        tarif = unTarif;
        montant = unTarif * uneQuantiteDeclaree;
    }



	public int getIdFiche() {
		return idFiche;
	}

	public void setIdFiche(int idFiche) {
		this.idFiche = idFiche;
	}

	public String getIdTypeFrais() {
		return idTypeFrais;
	}

	public void setIdTypeFrais(String idTypeFrais) {
		this.idTypeFrais = idTypeFrais;
	}

	public int getQuantiteDeclaree() {
		return quantiteDeclaree;
	}

	public void setQuantiteDeclaree(int quantiteDeclaree) {
		this.quantiteDeclaree = quantiteDeclaree;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public float getTarif() {
		return tarif;
	}

	public void setTarif(float tarif) {
		this.tarif = tarif;
	}
	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = tarif*quantiteDeclaree;
	}

	
}