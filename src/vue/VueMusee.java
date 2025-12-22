package vue;

import java.util.Arrays;
import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import architecture.Vue;
import controleur.ControleurMusee;
import javafx.scene.control.Label;
import modele.Musee;

public class VueMusee extends Vue {
	
	protected ControleurMusee controleur;
	protected static VueMusee instance = null; 
	public static VueMusee getInstance() {if(null==instance)instance = new VueMusee();return VueMusee.instance;}; 
	
	private VueMusee()  {
		super("musee.fxml", VueMusee.class);
		Logger.logMsg(Logger.INFO, "new VueMusee()");
		this.controleur = new ControleurMusee();
		
		
		}
	public void afficherMusees(List<Musee> musees) {
		
	}
}