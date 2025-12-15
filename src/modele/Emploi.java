package modele;
public class Emploi {
	 protected String id;
	 protected String titre;  
	 protected String entreprise;
	 protected String url;           
	 protected String companyLogo;
	 public Emploi(String string, String string2) {
		
	}
	 public Emploi(String string, String string2, String string3, String string4) {
		
	}
	 public Emploi(String id, String titre, String entreprise, String url, String companyLogo) {
		super();
		this.id = id;
		this.titre = titre;
		this.entreprise = entreprise;
		this.url = url;
		this.companyLogo = companyLogo;
	}
	 public Emploi(String id, String titre, String entreprise) {
		super();
		this.id = id;
		this.titre = titre;
		this.entreprise = entreprise;
	}
	 
	 public String getId() {
		 return id;
	 }
	 public void setId(String id) {
		 this.id = id;
	 }
	 public String getTitre() {
		 return titre;
	 }
	 public void setTitre(String titre) {
		 this.titre = titre;
	 }
	 public String getEntreprise() {
		 return entreprise;
	 }
	 public void setEntreprise(String entreprise) {
		 this.entreprise = entreprise;
	
    
}
	 public String getCategorie() {
		
		return null;
	 }
	 public Emploi(String companyLogo) {
		super();
		this.companyLogo = companyLogo;
	 }
	 public String getCompanyLogo() {
		    return companyLogo;
		}

	 public void setCompanyLogo(String companyLogo) {
		 this.companyLogo = companyLogo;
	 }
	 }

	 
