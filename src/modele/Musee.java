package modele;

public class Musee {

    protected String titre;
    protected String annee;
    protected String nom;

    public Musee(String titre, String annee, String nom, String nom2, String pays) {
        this.titre = titre;
        this.annee = annee;
        this.nom = nom;
    }

   

	public Musee(String string, String string2, String string3) {
		// TODO Auto-generated constructor stub
	}



	public String getTitre() { return titre; }
    public String getAnnee() { return annee; }
    public String getNom() { return nom; }

    public void setTitre(String titre) { this.titre = titre; }
    public void setAnnee(String annee) { this.annee = annee; }
    public void setNom(String nom) { this.nom = nom; }
}
