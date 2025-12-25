package modele;

public class Nouvelle {

    protected String titre;
    protected String auteur;
    protected String episode;
    protected String date;
    protected String texte;

    public Nouvelle(String titre, String auteur, String episode, String date, String texte) 
    {
        this.titre = titre;
        this.auteur = auteur;
        this.episode = episode;
        this.date = date;
        this.texte = texte;
    }

    public String getTitre() 
    { 
    	return titre; 
    }
    public void setTitre(String titre) 
    { 
    	this.titre = titre; 
    }

    public String getAuteur() 
    { 
    	return auteur; 
    }
    public void setAuteur(String auteur) 
    { 
    	this.auteur = auteur; 
    }

    public String getEpisode() 
    { 
    	return episode; 
    }
    public void setEpisode(String episode) 
    { 
    	this.episode = episode; 
    }

    public String getDate() 
    { 
    	return date; 
    }
    public void setDate(String date) 
    { 
    	this.date = date; 
    }

    public String getTexte() 
    { 
    	return texte; 
    }
    public void setTexte(String texte) 
    { 
    	this.texte = texte; 
    }
}
