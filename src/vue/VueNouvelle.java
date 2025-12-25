package vue;


	import java.util.List;

	import architecture.Vue;
	import controleur.ControleurNouvelle;
	import javafx.scene.control.TextArea;
	import javafx.scene.control.TextField;
	import modele.Nouvelle;

	public class VueNouvelle extends Vue {

	    protected ControleurNouvelle controleur;
	    protected static VueNouvelle instance = null;

	    public static VueNouvelle getInstance() {
	        if (instance == null) instance = new VueNouvelle();
	        return instance;
	    }

	    private VueNouvelle() {
	        super("nouvelles.fxml", VueNouvelle.class);
	        super.controleur = this.controleur = new ControleurNouvelle();
	    }
	    
	    @Override
	    public void activerControles() {
	        super.activerControles();
	    }

	    public void afficherNouvelles(List<Nouvelle> nouvelles) {

	}
	   
	
	}
	
	    
