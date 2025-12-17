package modele;

public class Musee {
	 protected String titre;
	 protected  String objets;
	 protected  String annee;
	 protected  String nom;
	 protected  String pays;
	 
	 public Musee(String string, String string2, String string3, String string4, String string5, String string6) {
		
	}
	 public Musee(String titre, String annee, String nom, String pays) {
		super();
		this.titre = titre;
		this.annee = annee;
		this.nom = nom;
		this.pays = pays;
	}
	 public Musee(String string) {
		
	}
	 public Musee(String titre, String objets, String annee, String nom, String pays) {
		super();
		this.titre = titre;
		this.objets = objets;
		this.annee = annee;
		this.nom = nom;
		this.pays = pays;
	}
	 public String getTitre() {
		 return titre;
	 }
	 public void setTitre(String titre) {
		 this.titre = titre;
	 }
	 public String getObjets() {
		 return objets;
	 }
	 public void setObjets(String objets) {
		 this.objets = objets;
	 }
	 public String getAnnee() {
		 return annee;
	 }
	 public void setAnnee(String annee) {
		 this.annee = annee;
	 }
	 public String getNom() {
		 return nom;
	 }
	 public void setPays(String pays) {
		 this.pays = pays;
	 }
	 public String getPays() {
		 return pays;
	 }
	 public void setNom(String pays) {
		 this.pays = pays;
	 }
}
	  