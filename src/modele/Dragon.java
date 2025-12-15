package modele;

import java.lang.ProcessHandle.Info;

public class Dragon {
	  protected String id;    
	  protected  String nom;     
	  protected  String titre;    
	  protected  String description; 
	  protected  Info info;
	 

	  public Dragon(String id, String nom, String titre, String description, Info info) {
		super();
		this.id = id;
		this.nom = nom;
		this.titre = titre;
		this.description = description;
		//this.info = info;
	}

	  public Dragon(String id, String nom, String titre, String description) {
		    this.id = id;
		    this.nom = nom;
		    this.titre = titre;
		    this.description = description;
		}

	  public Dragon(String id2, String nom2, String titre2, String description2, String elementDragon, int niveau,
			String rarete) {
		// TODO Auto-generated constructor stub
	}

	  public void setId(String id) {
		  this.id = id;
	  }
	  public String getNom() {
		  return nom;
	  }
	  public void setNom(String nom) {
		  this.nom = nom;
	  }
	  public String getTitre() {
		  return titre;
	  }
	  public void setTitre(String titre) {
		  this.titre = titre;
	  }
	  public String getDescription() {
		  return description;
	  }
	  public void setDescription(String description) {
		  this.description = description;
	  }
	  public Info getInfo() {
		  return info;
	  }
	  public void setInfo(Info info) {
		  this.info = info;
	  } 
    
}
