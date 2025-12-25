package vue;

import java.util.List;

import architecture.Vue;
import controleur.ControleurMusique;
import javafx.scene.control.TextField;
import modele.Musique;

public class VueMusique extends Vue {

    protected ControleurMusique controleur;
    protected static VueMusique instance = null;

    public static VueMusique getInstance() {
        if (instance == null) instance = new VueMusique();
        return instance;
    }

    private VueMusique() {
        super("musique.fxml", VueMusique.class);
        super.controleur = this.controleur = new ControleurMusique();
    }

    @Override
    public void activerControles() {
        super.activerControles();
    }

	public void afficherMusiques(List<Musique> musiques) {
		// TODO Auto-generated method stub
		
	}
}