package vue;

import java.util.List;

import architecture.Vue;
import controleur.ControleurMusee;
import javafx.scene.control.Label;
import modele.Musee;

public class VueMusee extends Vue {

    protected ControleurMusee controleur;
    protected static VueMusee instance = null;

    public static VueMusee getInstance() {
        if (instance == null) instance = new VueMusee();
        return instance;
    }

    private VueMusee() {
        super("musee.fxml", VueMusee.class);
        super.controleur = this.controleur = new ControleurMusee();
    }

    @Override
    public void activerControles() {
        super.activerControles();
        this.controleur.initialiser();
    }

    public void afficherMusees(List<Musee> musees) {

        
        for (int i = 0; i < musees.size() && i < 3; i++) {
            Musee m = musees.get(i);

            
            Label titre = (Label) lookup("#musee-titre-" + (i + 1));
            Label annee = (Label) lookup("#musee-annee-" + (i + 1));
            Label nom   = (Label) lookup("#musee-nom-" + (i + 1));

            if (titre == null || annee == null || nom == null) continue;

            titre.setText(m.getTitre() != null ? m.getTitre() : "");
            annee.setText(m.getAnnee() != null ? m.getAnnee() : "");
            nom.setText(m.getNom() != null ? m.getNom() : "");
        }
    }
}
