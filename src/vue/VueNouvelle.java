package vue;


import java.util.List;

import architecture.Vue;
import controleur.ControleurNouvelle;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import modele.Nouvelle;


	public class VueNouvelle extends Vue {

	    protected ControleurNouvelle controleur;
	    protected static VueNouvelle instance = null;

	    public static VueNouvelle getInstance() {
	        if (instance == null) instance = new VueNouvelle();
	        return instance;
	    }

	    private VueNouvelle() {
	    	super("nouvelle.fxml", VueNouvelle.class);
	        super.controleur = this.controleur = new ControleurNouvelle();
	    }
	    
	    @Override
	    public void activerControles() {
	        super.activerControles();
	        this.controleur.initialiser();
	    }

	    public void afficherNouvelles(List<Nouvelle> nouvelles) 
	  {
	    	 int index = 1;

	         for (Nouvelle n : nouvelles) {

	             if (index > 6) break;

	             
	             Pane boite = (Pane) lookup("#nouvelle" + index);
	             Label titre = (Label) lookup("#nouvelle-titre-" + index);
	             Label auteur = (Label) lookup("#nouvelle-auteur-" + index);


	             if (boite == null || titre == null || auteur == null) {
	                 index++;
	                 continue;
	             }
	             String t = (n.getTitre() != null) ? n.getTitre() : "";
	             String a = (n.getAuteur() != null) ? n.getAuteur() : "";

	             titre.setText(t);
	             auteur.setText(a);

	             index++;
	         }
	     }
	}
	   
	
	
	
	    
