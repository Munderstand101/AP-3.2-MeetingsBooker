package model.DTO;

public class VilePays {
    private int idVille;
    private String vilepays;

    public VilePays(int idVille, String vilepays) {
        this.idVille = idVille;
        this.vilepays = vilepays;
    }

    public int getIdVille() {
        return idVille;
    }

    public void setIdVille(int idVille) {
        this.idVille = idVille;
    }

    public String getVilepays() {
        return vilepays;
    }

    public void setVilepays(String vilepays) {
        this.vilepays = vilepays;
    }
}
