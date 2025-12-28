package modele;

public class Musee {

    protected String titre;
    protected String annee;
    protected String nom;

    public Musee(String titre, String annee, String nom) {
        this.titre = titre;
        this.annee = annee;
        this.nom = nom;
    }

    public String getTitre() { return titre; }
    public String getAnnee() { return annee; }
    public String getNom() { return nom; }

    public void setTitre(String titre) { this.titre = titre; }
    public void setAnnee(String annee) { this.annee = annee; }
    public void setNom(String nom) { this.nom = nom; }
}
